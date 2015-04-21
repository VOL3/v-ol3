package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;
import com.vaadin.client.ServerConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.OLMapConnector;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.client.feature.GeometrySerializer;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.View;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.feature.FeatureChangeListener;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.source.VectorSourceOptions;
import org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Client-side connector for the OLVectorSource
 */
@Connect(OLVectorSource.class)
public class OLVectorSourceConnector extends OLSourceConnector implements FeatureSetChangeListener, FeatureChangeListener {

    private Timer sendTimer;
    private static final int MODIFY_THRESHOLD=200; // milliseconds to wait for modifications before they are flushed to server
    private Set<Feature> modifiedFeatures=new HashSet<Feature>();
    private List<Feature> tempFeatures=new LinkedList<Feature>();
    private String viewProjection;

    @Override
    protected void init() {
        super.init();
        registerRpc(OLVectorSourceClientRpc.class, new ClientRpcImpl());
        sendTimer=new Timer() {
            @Override
            public void run() {
                for (Feature feature : modifiedFeatures) {
                    String serializedGeometry = GeometrySerializer.writeGeometry(feature.getGeometry(), getViewProjection(), getInputProjection());
                    getRpcProxy(OLVectorSourceServerRpc.class).featureModified(feature.getId(), serializedGeometry);
                    modifiedFeatures.clear();
                }
            }
        };
    }

    protected class ClientRpcImpl implements OLVectorSourceClientRpc{

        @Override
        public void createOrUpdateFeatures(List<SerializedFeature> features) {
            VectorSource source=getSource();
            for(SerializedFeature serializedFeature : features){
                Feature oldFeature=getSource().getFeatureById(serializedFeature.id);
                Feature newFeature=createFeature(serializedFeature);
                if(oldFeature!=null){
                    //update feature
                    oldFeature.setGeometry(newFeature.getGeometry());
                    if(newFeature.getStyles()!=null){
                        oldFeature.setStyles(newFeature.getStyles());
                    }
                } else{
                    // add new one
                    getSource().addFeature(newFeature);
                }
            }
            removeTemporaryFeatures();
        }

        private Feature createFeature(SerializedFeature feature) {
            Feature f=Feature.create();
            f.setId(feature.id);
            Geometry geom= GeometrySerializer.readGeometry(feature.serializedGeometry, getInputProjection(), getViewProjection());
            f.setGeometry(geom);
            if(feature.styles!=null){
                f.setStyles(OLStyleConverter.convert(feature.styles));
            }
            return f;
        }

        @Override
        public void removeFeatures(List<String> featureIds) {
            VectorSource source=getSource();
            for(String id : featureIds){
                removeFeatureById(source,id);
            }
        }

        private void removeFeatureById(VectorSource source, String id){
            Feature removed=source.getFeatureById(id);
            if(removed!=null){
                source.removeFeature(removed);
            }
        }
    }

    @Override
    protected VectorSource createSource() {
        VectorSourceOptions options=VectorSourceOptions.create();
        if(getState().attributions!=null){
            JsArray<Attribution> jsArray= JsArray.createArray().cast();
            for(String attribution : getState().attributions){
                jsArray.push(Attribution.create(attribution));
            }
            options.setAttributions(jsArray);
        }
        if(getState().logo!=null){
            options.setLogo(getState().logo);
        }
        VectorSource source=VectorSource.create(options);
        source.addFeatureSetChangeListener(this);
        return source;
    }

    @Override
    public OLVectorSourceState getState() {
        return (OLVectorSourceState) super.getState();
    }

    @Override
    public VectorSource getSource() {
        return (VectorSource) super.getSource();
    }

    private void sendModifiedFeature(Feature feature) {
        // delay execution since we will get plenty of these
        modifiedFeatures.add(feature);
        sendTimer.schedule(MODIFY_THRESHOLD);
    }

    private void sendDeletedFeature(Feature feature) {
        getRpcProxy(OLVectorSourceServerRpc.class).featureDeleted(feature.getId());
    }

    private void sendNewFeature(Feature feature){
        String serializedGeometry = GeometrySerializer.writeGeometry(feature.getGeometry(), getViewProjection(), getInputProjection());
        getRpcProxy(OLVectorSourceServerRpc.class).featureAdded(serializedGeometry);
    }

    @Override
    public void featureDeleted(Feature feature) {
        if(feature.getId()!=null){ // do not send temp features
            sendDeletedFeature(feature);
        }
    }

    @Override
    public void featureAdded(Feature feature) {
        if(feature.getId()==null){ // send only drawn features back to server
            sendNewFeature(feature);
            tempFeatures.add(feature);
        } else{
            // we are adding new feature with id, add change listener
            feature.addFeatureChangeListener(this);
        }
    }

    @Override
    public void featureChanged(Feature feature) {
        sendModifiedFeature(feature);
    }

    private void removeTemporaryFeatures(){
        for(Feature f : tempFeatures){
            getSource().removeFeature(f);
        }
        tempFeatures.clear();
    }

    private String getInputProjection(){
        return Projections.EPSG4326;
    }

    /** Returns the currently used view projection
     *
     * @return
     */
    private String getViewProjection(){
        // we want to find out the projection only once since that will not change
        if(viewProjection==null){
            // we make an educated guess here since most base layers are in this projection
            viewProjection= Projections.EPSG3857;
            // but let's still try to fetch the actual projection from view
            ServerConnector connector=this.getParent();
            while(connector!=null && !(connector instanceof OLMapConnector)){
                connector=connector.getParent();
            }
            if(connector instanceof OLMapConnector){
                OLMapConnector mapConnector=(OLMapConnector) connector;
                View view=mapConnector.getWidget().getMap().getView();
                if(view!=null){
                    viewProjection=view.getProjection().getCode();
                }
            }
        }
        return viewProjection;
    }
}

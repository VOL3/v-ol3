package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.format.GeoJSONFormat;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.source.VectorSourceOptions;

import java.util.List;

/**
 * Created by mjhosio on 07/07/14.
 */
@Connect(OLVectorSource.class)
public class OLVectorSourceConnector extends OLSourceConnector {

    @Override
    protected void init() {
        super.init();
        registerRpc(OLVectorSourceClientRpc.class, new ClientRpcImpl());
    }

    protected class ClientRpcImpl implements OLVectorSourceClientRpc{

        @Override
        public void createOrUpdateFeatures(List<SerializedFeature> features) {
            VectorSource source=getSource();
            for(SerializedFeature feature : features){
                // we just do delete and add for simplicity
                // remove old feature with same id
                removeFeatureById(source, feature.id);
                // add the new one
                getSource().addFeature(createFeature(feature));
            }
        }

        private Feature createFeature(SerializedFeature feature) {
            Feature f=Feature.create();
            f.setId(feature.id);
            f.setGeometry(GeoJSONFormat.create().readGeometry(feature.serializedGeometry));
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
        if(getState().projection!=null){
            options.setProjection(getState().projection);
        }
        if(getState().attributions!=null){
            JsArray<Attribution> jsArray= JsArray.createArray(getState().attributions.length).cast();
            for(String attribution : getState().attributions){
                jsArray.push(Attribution.create(attribution));
            }
            options.setAttributions(jsArray);
        }
        if(getState().extent!=null){
            OLExtent e=getState().extent;
            Extent extent=Extent.create(e.minX,e.minY,e.maxX,e.maxY);
            options.setExtent(extent);
        }
        if(getState().logo!=null){
            options.setLogo(getState().logo);
        }
        if(getState().projection!=null){
            options.setProjection(getState().projection);
        }
        return VectorSource.create(options);
    }

    @Override
    public OLVectorSourceState getState() {
        return (OLVectorSourceState) super.getState();
    }

    @Override
    public VectorSource getSource() {
        return (VectorSource) super.getSource();
    }
}

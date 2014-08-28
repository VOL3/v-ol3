package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.source.OLVectorSourceClientRpc;
import org.vaadin.addon.vol3.client.source.OLVectorSourceServerRpc;
import org.vaadin.addon.vol3.client.source.OLVectorSourceState;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLFeatureSerializer;
import org.vaadin.addon.vol3.feature.OLGeometry;

import java.util.*;

/**
 * Base class for vector sources
 * Created by mjhosio on 07/07/14.
 */
public class OLVectorSource extends OLSource{

    private Map<String, OLFeature> features=new HashMap <String,OLFeature>();
    private Set<String> dirtyFeatures=new HashSet<String>();
    private long featureIdSeed=0;
    private List<FeatureModificationListener> modificationListeners = new LinkedList<FeatureModificationListener>();
    private List<FeatureSetChangeListener> featureSetChangeListeners = new LinkedList<FeatureSetChangeListener>();

    public OLVectorSource(){
        super();
    }

    public OLVectorSource(OLVectorSourceOptions options){
        this();
        setOptions(options);
        registerRpc(new OLVectorSourceServerRpcImpl(), OLVectorSourceServerRpc.class);
    }

    private void setOptions(OLVectorSourceOptions options) {
        this.getState().attributions=options.getAttributions();
        this.getState().extent=options.getExtent();
        this.getState().logo=options.getLogo();
        this.getState().projection=options.getProjection();
        this.getState().state=options.getState();
    }

    public void addFeature(OLGeometry geometry){
        OLFeature feature=new OLFeature(generateNextFeatureId());
        feature.setGeometry(geometry);
        addFeature(feature);
    }

    public void updateFeature(OLFeature feature){
        updateFeatureInternal(feature, true);
    }

    public void addFeature(OLFeature feature){
        addFeatureInternal(feature);
    }

    public void addFeatures(List<OLFeature> features){
        for(OLFeature feature : features){
            this.addFeature(feature);
        }
    }

    public void removeFeatureById(String featureId){
        OLFeature feature=features.get(featureId);
        if(featureId!=null){
            features.remove(featureId);
            dirtyFeatures.add(featureId);
        }
        fireFeatureDeleted(feature);
        markAsDirty();
    }

    public List<OLFeature> getFeatures(){
        LinkedList<OLFeature> features=new LinkedList<OLFeature>();
        features.addAll(this.features.values());
        return features;
    }

    private void addFeatureInternal(OLFeature feature){
        if(feature.getId()==null){
            feature.setId(generateNextFeatureId());
        }
        features.put(feature.getId(), feature);
        dirtyFeatures.add(feature.getId());
        markAsDirty();
        fireFeatureAdded(feature);
    }

    private void updateFeatureInternal(OLFeature feature, boolean updateClientSide){
        features.put(feature.getId(), feature);
        if(updateClientSide){
            dirtyFeatures.add(feature.getId());
            markAsDirty();
        }
        fireFeatureModified(feature);
    }

    public OLFeature getFeatureById(String id){
        return this.features.get(id);
    }

    public OLExtent getExtent(){
        return getState(false).extent;
    }


    @Override
    protected OLVectorSourceState getState() {
        return (OLVectorSourceState) super.getState();
    }

    @Override
    protected OLVectorSourceState getState(boolean markAsDirty) {
        return (OLVectorSourceState) super.getState(markAsDirty);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        if(initial){
            // send all features to client side
            updateFeatures(getFeatures());
        } else{
            List<OLFeature> newFeatures=new ArrayList<OLFeature>();
            List<String> deletedFeatures=new ArrayList<String>();
            for(String featureId : dirtyFeatures){
                OLFeature feature = features.get(featureId);
                if(feature==null){
                    deletedFeatures.add(featureId);
                } else{
                    newFeatures.add(feature);
                }
            }
            if(newFeatures.size()>0){
                // ask to add / update the new features
                updateFeatures(newFeatures);
            }
            if(deletedFeatures.size()>0){
                // ask to remove the ones that are removed
                removeFeatures(deletedFeatures);
            }
        }
        // no more dirty features
        dirtyFeatures.clear();
    }

    private void removeFeatures(List<String> featureIds){
        getRpcProxy(OLVectorSourceClientRpc.class).removeFeatures(featureIds);
    }

    private void updateFeatures(List<OLFeature> features){
        List<SerializedFeature> serialized = new LinkedList<SerializedFeature>();
        for (OLFeature feature : features) {
            serialized.add(OLFeatureSerializer.serializeFeature(feature));
        }
        getRpcProxy(OLVectorSourceClientRpc.class).createOrUpdateFeatures(serialized);
    }

    private String generateNextFeatureId(){
        String featureId="feature-"+featureIdSeed;
        while(features.containsKey(featureId) && featureIdSeed<Long.MAX_VALUE){
            featureId="feature-"+featureIdSeed;
            featureIdSeed++;
        }
        featureIdSeed++;
        return featureId;
    }

    /** Removes the specified feature modification listener
     *
     * @param listener
     */
    public void removeFeatureModificationListener(FeatureModificationListener listener){
        modificationListeners.remove(listener);
    }

    /** Add listener that will be notified when features are modified
     *
     * @param listener
     */
    public void addFeatureModificationListener(FeatureModificationListener  listener){
        modificationListeners.add(listener);
    }

    /** Removes the specified feature set change listener
     *
     * @param listener
     */
    public void removeFeatureSetChangeListener(FeatureSetChangeListener listener){
        featureSetChangeListeners.remove(listener);
    }

    /** Adds listener that will be notified when features are added or removed
     *
     * @param listener
     */
    public void addFeatureSetChangeListener(FeatureSetChangeListener listener){
        featureSetChangeListeners.add(listener);
    }


    private void fireFeatureModified(OLFeature feature){
        for(FeatureModificationListener listener : this.modificationListeners){
            listener.featureModified(feature);
        }
    }

    private void fireFeatureDeleted(OLFeature feature){
        for(FeatureSetChangeListener listener : this.featureSetChangeListeners){
            listener.featureDeleted(feature);
        }
    }

    private void fireFeatureAdded(OLFeature feature){
        for(FeatureSetChangeListener listener : this.featureSetChangeListeners){
            listener.featureAdded(feature);
        }
    }


    private final class OLVectorSourceServerRpcImpl implements OLVectorSourceServerRpc{

        @Override
        public void featureModified(String id, String serializedGeometry) {
            OLFeature feature=getFeatureById(id);
            if(feature!=null){
                OLGeometry geometry = OLFeatureSerializer.deSerializeGeometry(serializedGeometry);
                feature.setGeometry(geometry);
                updateFeatureInternal(feature, false);
            }
        }

        @Override
        public void featureDeleted(String id) {
            OLFeature feature=getFeatureById(id);
            if(feature!=null){
                removeFeatureById(id);
                fireFeatureDeleted(feature);
            }
        }

        @Override
        public void featureAdded(String serializedGeometry) {
            OLGeometry geometry = OLFeatureSerializer.deSerializeGeometry(serializedGeometry);
            addFeature(geometry);
        }
    }

    /** Listener for feature modification
     *
     */
    public interface FeatureModificationListener{
        public void featureModified(OLFeature feature);
    }

    /** Listener for feature modification
     *
     */
    public interface FeatureSetChangeListener{
        public void featureAdded(OLFeature feature);
        public void featureDeleted(OLFeature feature);
    }

}

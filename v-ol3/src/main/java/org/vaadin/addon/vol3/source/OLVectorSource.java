package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.source.OLVectorSourceClientRpc;
import org.vaadin.addon.vol3.client.source.OLVectorSourceServerRpc;
import org.vaadin.addon.vol3.client.source.OLVectorSourceState;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLFeatureSerializer;
import org.vaadin.addon.vol3.feature.OLGeometry;

import java.util.*;

/**
 * Vector source implementation that provides api for adding features. NOTE: the coordinates for the shapes of the features
 * must always be expressed in EPSG:4326 / WGS84 (lon/lat). The wrapper handles the conversion to the projection set for the view automatically.
 */
public class OLVectorSource extends OLSource{

    private Map<String, OLFeature> features=new HashMap <String,OLFeature>();
    private Set<String> dirtyFeatures=new HashSet<String>();
    private long featureIdSeed=0;
    private List<FeatureModificationListener> modificationListeners = new LinkedList<FeatureModificationListener>();
    private List<FeatureSetChangeListener> featureSetChangeListeners = new LinkedList<FeatureSetChangeListener>();

    /** Creates a new instance of the vector source
     *
     */
    public OLVectorSource(){
        super();
        registerRpc(new OLVectorSourceServerRpcImpl(), OLVectorSourceServerRpc.class);
    }

    /** Creates a new instance of the vector source
     *
     * @param options options for the vector source
     */
     public OLVectorSource(OLVectorSourceOptions options){
        this();
        setOptions(options);
    }

    private void setOptions(OLVectorSourceOptions options) {
        this.getState().attributions=options.getAttributions();
        this.getState().logo=options.getLogo();
        this.getState().inputProjection=options.getInputProjection();
    }

    /** Adds feature to the source. The id is generated automatically for the feature
     *
     * @param geometry the geometry for the feature
     */
    public void addFeature(OLGeometry geometry){
        OLFeature feature=new OLFeature(generateNextFeatureId());
        feature.setGeometry(geometry);
        addFeature(feature);
    }

    /** Searches the feature from the source that has the same id than the one given as parameter. After that the
     * geometry and styles of the feature are updated accordingly
     * @param feature the feature that holds the data to be updated
     */
    public void updateFeature(OLFeature feature){
        updateFeatureInternal(feature, true);
    }

    /** Updates all features on the source. Very handy if changing style of layer.
     *
     */
    public void updateAllFeatures(){
        for (OLFeature olFeature : features.values()) {
            updateFeature(olFeature);
        }
    }

    /** Adds the specified feature to the source
     *
     * @param feature the feature to be added
     */
    public void addFeature(OLFeature feature){
        addFeatureInternal(feature);
    }

    /** Adds the given list of features to the source
     *
     * @param features
     */
    public void addFeatures(List<OLFeature> features){
        for(OLFeature feature : features){
            this.addFeature(feature);
        }
    }

    /** Removes the feature by id provided
     *
     * @param featureId the id of the feature to be removed
     */
    public void removeFeatureById(String featureId){
        OLFeature feature=features.get(featureId);
        if(featureId!=null){
            features.remove(featureId);
            dirtyFeatures.add(featureId);
        }
        fireFeatureDeleted(feature);
        markAsDirty();
    }

    /** Gets all features from the source
     *
     * @return the features from the source
     */
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

    /** Returns the feature based on the provided id
     *
     * @param id the id of the feature being fetched
     * @return the feature matching the id or null if not found
     */
    public OLFeature getFeatureById(String id){
        return this.features.get(id);
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

    /** Listener that is notified when features are modified
     *
     */
    public interface FeatureModificationListener{
        /** Called when feature has been modified
         *
         * @param feature the modified feature
         */
        public void featureModified(OLFeature feature);
    }

    /** Listener that is notified when features are added or removed
     *
     */
    public interface FeatureSetChangeListener{
        /** Called when a feature has been added to the source
         *
         * @param feature the feature that was added
         */
        public void featureAdded(OLFeature feature);

        /** Called when a feature has been removed from the source
         *
         * @param feature the feature that was removed
         */
        public void featureDeleted(OLFeature feature);
    }

}

package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.source.OLVectorSourceClientRpc;
import org.vaadin.addon.vol3.client.source.OLVectorSourceState;
import org.vaadin.addon.vol3.feature.OLFeature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Base class for vector sources
 * Created by mjhosio on 07/07/14.
 */
public class OLVectorSource extends OLSource{

    private List<OLFeature> features=new ArrayList<OLFeature>();
    private List<OLFeature> newFeatures=new ArrayList<OLFeature>();
    private List<OLFeature> removedFeatures=new ArrayList<OLFeature>();

    public OLVectorSource(){
        super();
    }

    public OLVectorSource(OLVectorSourceOptions options){
        this();
        setOptions(options);
    }

    private void setOptions(OLVectorSourceOptions options) {
        this.getState().attributions=options.getAttributions();
        this.getState().extent=options.getExtent();
        this.getState().logo=options.getLogo();
        this.getState().projection=options.getProjection();
        this.getState().state=options.getState();
    }

    public void addFeature(OLFeature feature){
        features.add(feature);
        newFeatures.add(feature);
    }

    public void addFeatures(List<OLFeature> features){
        for(OLFeature feature : features){
            this.addFeature(feature);
        }
    }

    public void removeFeature(OLFeature feature){
        removedFeatures.add(feature);
        features.remove(feature);
        newFeatures.remove(feature);
    }

    public List<OLFeature> getFeatures(){
        // just return copy of the list to prevent modifying the original one
        LinkedList<OLFeature> features=new LinkedList<OLFeature>();
        features.addAll(this.features);
        return features;
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
        // serialize new features to the client
        updateNewFeatures();
        // ask to remove the ones that are removed
        updateRemovedFeatures();
    }

    private void updateRemovedFeatures(){
        if(removedFeatures.size()>0) {
            List<String> removed = new ArrayList<String>();
            for (OLFeature feature : removedFeatures) {
                removed.add(feature.getId());
            }
            getRpcProxy(OLVectorSourceClientRpc.class).removeFeatures(removed);
            removedFeatures.clear();
        }
    }

    private void updateNewFeatures() {
        long time=System.currentTimeMillis();
        if(newFeatures.size()>0) {
            List<SerializedFeature> serialized = new LinkedList<SerializedFeature>();
            for (OLFeature feature : newFeatures) {
                serialized.add(feature.asSerializedFeature());
            }
            getRpcProxy(OLVectorSourceClientRpc.class).createOrUpdateFeatures(serialized);
            newFeatures.clear();
        }

    }
}

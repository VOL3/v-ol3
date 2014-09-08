package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.client.source.OLMapQuestSourceState;

/**
 * Layer source for the MapQuest tile server
 */
public class OLMapQuestSource extends OLXYZSource {

    /** Creates a MapQuest source
     * @param layer the MapQuest layer used (osm, sat, hyb)
     */
    public OLMapQuestSource(OLMapQuestLayerName layer){
        super();
        getState().layer=layer;
    }

    /** Gets the name of the layer fetched by the source
     *
     * @return the name of the layer fetched by the source
     */
    public OLMapQuestLayerName getLayerName(){
        return getState(false).layer;
    }

    @Override
    protected OLMapQuestSourceState getState() {
        return (OLMapQuestSourceState) super.getState();
    }

    @Override
    protected OLMapQuestSourceState getState(boolean markAsDirty) {
        return (OLMapQuestSourceState) super.getState(markAsDirty);
    }
}

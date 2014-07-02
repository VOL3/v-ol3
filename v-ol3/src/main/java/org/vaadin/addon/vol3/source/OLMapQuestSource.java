package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.client.source.OLMapQuestSourceState;

/**
 * Layer source for the MapQuest tile server
 * Created by mjhosio on 30/06/14.
 */
public class OLMapQuestSource extends OLSource {

    /** Creates a MapQuest source
     * @param layer the MapQuest layer used (osm, sat, hyb)
     */
    public OLMapQuestSource(OLMapQuestLayerName layer){
        super();
        getState().layer=layer;
    }

    @Override
    protected OLMapQuestSourceState getState() {
        return (OLMapQuestSourceState) super.getState();
    }
}

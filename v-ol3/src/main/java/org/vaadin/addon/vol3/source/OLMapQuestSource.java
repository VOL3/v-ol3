package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLMapQuestSourceState;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLMapQuestSource extends OLSource {

    public static final String LAYER_OSM="osm";
    public static final String LAYER_SAT="sat";
    public static final String LAYER_HYB="hyb";

    /** Creates a MapQuest source
     * @param layer the MapQuest layer used (osm, sat, hyb)
     */
    public OLMapQuestSource(String layer){
        super();
        getState().layer=layer;
    }

    @Override
    protected OLMapQuestSourceState getState() {
        return (OLMapQuestSourceState) super.getState();
    }
}

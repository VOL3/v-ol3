package org.vaadin.gwtol3.client.source;

import java.util.logging.Logger;

/**
 * Created by mjhosio on 24/06/14.
 */
public class MapQuest extends XYZ {

    private static Logger logger= Logger.getLogger(MapQuest.class.getName());

    public static final String LAYER_OSM="osm";
    public static final String LAYER_SAT="sat";
    public static final String LAYER_HYB="hyb";

    protected MapQuest() {
    }

    public static MapQuest create(String layer){
        logger.info("Creating MapQuest source "+layer);
        MapQuest source=createNative(layer);
        logger.info("MapQuest source created");
        return source;
    }

    private static native MapQuest createNative(String layerString)
    /*-{
        return new $wnd.ol.source.MapQuest({layer: layerString});
    }-*/;

}

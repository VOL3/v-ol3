package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * Control to show all the attributions associated with the layer sources in the map. This control is one of the default controls included in maps. By default it will show in the bottom right portion of the map, but this can be changed by using a css selector for .ol-attribution.
 * Created by mjhosio on 11/07/14.
 */
public class OLAttributionControl implements Serializable {
    // css class name for the control. The default is .ol-attribution
    public String className;
}

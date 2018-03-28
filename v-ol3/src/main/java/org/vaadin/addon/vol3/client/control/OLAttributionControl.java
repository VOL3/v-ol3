package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * Control to show all the attributions associated with the layer sources in the map. This control is one of the default controls included in maps. By default it will show in the bottom right portion of the map, but this can be changed by using a css selector for .ol-attribution.
 */
public class OLAttributionControl implements Serializable {
    /**
     * CSS class name for the control. The default is .ol-attribution
     */
    public String className;
    /**
     * Collapsibility of the attributions. When using an OSM source,
     * should be set to false - see
     * <a href="http://www.openstreetmap.org/copyright">OSM Copyright</a> -
     * Default is true.
     */
    public Boolean collapsible;
    /**
     * Are attributions collapsed at startup. Default is true
     */
    public Boolean collapsed;
    /**
     * Text label to use for the button tip. Default is Attributions
     */
    public String tipLabel;
    /**
     * Text label to use for the collapsed attributions button. Default is i.
     * Instead of text, also e.g. a span element can be used.
     */
    public String label;
    /**
     * Text label to use for the expanded attributions button. Default is ».
     * Instead of text, also a Node (e.g. a span element) can be used.
     */
    public String collapseLabel;
}

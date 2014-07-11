package org.vaadin.gwtol3.client.control;

/**
 * Control to show all the attributions associated with the layer sources in the map. This control is one of the default controls included in maps. By default it will show in the bottom right portion of the map, but this can be changed by using a css selector for .ol-attribution.
 * Created by mjhosio on 10/07/14.
 */
public class AttributionControl extends Control{
    protected AttributionControl() {
    }

    public static final native AttributionControl create()/*-{
        return new $wnd.ol.control.Attribution();
    }-*/;

    /**
     * Creates the control with given css-classname. The default is .ol-attribution.
     *
     * @param className
     * @return
     */
    public static final native AttributionControl create(String className)/*-{
        return new $wnd.ol.control.Attribution({className: className});
    }-*/;

}

package org.vaadin.gwtol3.client.control;

/**
 * Shows a logo for all the layer sources in the map that have a logo associated with them, such as Bing. This control is part of a default map. By default it will show in the bottom-left portion of the map, but it can be styled by using a css selector for .ol-logo.
 * Created by mjhosio on 10/07/14.
 */
public class LogoControl extends Control{
    protected LogoControl() {
    }

    public static final native LogoControl create()/*-{
        return new $wnd.ol.control.Logo();
    }-*/;

    /** Creates the control with given css-classname. The default is .ol-logo
     *
     * @param className
     * @return
     */
    public static final native LogoControl create(String className)/*-{
        return new $wnd.ol.control.Logo({className: className});
    }-*/;

}

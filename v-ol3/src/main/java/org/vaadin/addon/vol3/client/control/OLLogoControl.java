package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * Shows a logo for all the layer sources in the map that have a logo associated with them, such as Bing. This control is part of a default map. By default it will show in the bottom-left portion of the map, but it can be styled by using a css selector for .ol-logo.
 * Created by mjhosio on 11/07/14.
 */
public class OLLogoControl implements Serializable {
    //the css class name of the control. Default is ol-logo
    public String className;
}

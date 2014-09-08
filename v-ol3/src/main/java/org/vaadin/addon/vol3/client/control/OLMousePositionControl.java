package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A control to show the 2D coordinates of the mouse cursor. By default, these are in the view projection, but can be in any supported projection. By default the control is shown in the top right corner of the map, but this can be changed by using the css selector .ol-mouse-position.
 */
public class OLMousePositionControl implements Serializable {
    //the css class name of the control. Default is ol-mouse-position
    public String className;
    // the projection where mouse position is reported in (EPSG:3857 and EPSG:4326 are supported out of the box)
    public String projection;
    //Sets the string displayed when there is no coordinates to display. Empty string by default
    public String undefinedHTML;
}

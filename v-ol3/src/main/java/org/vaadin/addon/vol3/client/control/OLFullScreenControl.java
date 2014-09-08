package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * Provides a button that when clicked fills up the full screen with the map. When in full screen mode, a close button is shown to exit full screen mode. The Fullscreen API is used to toggle the map in full screen mode.
 */
public class OLFullScreenControl implements Serializable {
    //the css class name of the control. Default is ol-full-screen
    public String className;
    // label to use for the button tip. Default is Toggle full-screen
    public String tipLabel;
    // allow full keyboard access
    public Boolean fullKeyboardAccess;
}

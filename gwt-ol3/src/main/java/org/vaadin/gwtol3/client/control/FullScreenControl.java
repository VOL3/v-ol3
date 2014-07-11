package org.vaadin.gwtol3.client.control;

/**
 * Provides a button that when clicked fills up the full screen with the map. When in full screen mode, a close button is shown to exit full screen mode. The Fullscreen API is used to toggle the map in full screen mode.
 * Created by mjhosio on 10/07/14.
 */
public class FullScreenControl extends Control {
    protected FullScreenControl() {
    }

    public static final native FullScreenControl create()/*-{
        return new $wnd.ol.control.FullScreen();
    }-*/;

    public static final native FullScreenControl create(FullScreenControlOptions options)/*-{
        return new $wnd.ol.control.FullScreen(options);
    }-*/;

}

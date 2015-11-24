package org.vaadin.gwtol3.client.control;

/**
 * OpenLayers 3 Layer Switcher Control
 */
public class LayerSwitcherControl extends Control{
    protected LayerSwitcherControl() {
    }

    public static final native LayerSwitcherControl create()/*-{
        return new $wnd.ol.control.LayerSwitcher();
    }-*/;

    public static final native LayerSwitcherControl create(LayerSwitcherControlOptions options)/*-{
        return new $wnd.ol.control.LayerSwitcher(options);
    }-*/;
}

package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options passed to the LayerSwitcher on creation
 */
public class LayerSwitcherControlOptions extends JavaScriptObject {
    protected LayerSwitcherControlOptions() {
    }

    public static final native LayerSwitcherControlOptions create()/*-{
        return {};
    }-*/;

    /** label to use for the close/open icon tooltip. Default is 'Legend'
     *
     * @param tipLabel
     */
    public final native void setTipLabel(String tipLabel)/*-{
        this.tipLabel=tipLabel;
    }-*/;
}

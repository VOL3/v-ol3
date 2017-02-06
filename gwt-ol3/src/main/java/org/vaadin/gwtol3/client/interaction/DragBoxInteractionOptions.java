/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.style.Style;

/**
 * @author iserge
 */
public class DragBoxInteractionOptions extends PointerInteraction {

    protected DragBoxInteractionOptions() {
        //
    }

    public final static native DragBoxInteractionOptions create() /*-{
        return {};
    }-*/;

    public final native void setClassName(String className) /*-{
        this.className = className;
    }-*/;

    /** Sets the style for the sketch features
     *
     * @param style
     */
    public final native void setStyle(Style style)/*-{
        this.style = style;
    }-*/;

    public final native void setCondition(String condition) /*-{
        if (condition === "altKeyOnly") {
            this.condition = $wnd.ol.events.condition.altKeyOnly;
        } else if (condition === "altShiftKeysOnly") {
            this.condition = $wnd.ol.events.condition.altShiftKeysOnly;
        } else if (condition === "always") {
            this.condition = $wnd.ol.events.condition.always;
        } else if (condition === "never") {
            this.condition = $wnd.ol.events.condition.never;
        } else if (condition === "pointerMove") {
            this.condition = $wnd.ol.events.condition.pointerMove;
        } else if (condition === "singleClick") {
            this.condition = $wnd.ol.events.condition.singleClick;
        } else if (condition === "noModifierKeys") {
            this.condition = $wnd.ol.events.condition.noModifierKeys;
        } else if (condition === "platformModifierKeyOnly") {
            this.condition = $wnd.ol.events.condition.platformModifierKeyOnly;
        } else if (condition === "shiftKeyOnly") {
            this.condition = $wnd.ol.events.condition.shiftKeyOnly;
        } else if (condition === "targetNotEditable") {
            this.condition = $wnd.ol.events.condition.targetNotEditable;
        } else if (condition === "mouseOnly") {
            this.condition = $wnd.ol.events.condition.mouseOnly;
        }
    }-*/;

    public static enum Condition {
        altKeyOnly, altShiftKeysOnly, always, never, pointerMove, singleClick, noModifierKeys, platformModifierKeyOnly, shiftKeyOnly, targetNotEditable, mouseOnly
    }
}

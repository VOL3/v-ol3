/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author iserge
 */
public class OverviewMapControlOptions extends JavaScriptObject {
    protected OverviewMapControlOptions() {
        //
    }
    
    public static final native OverviewMapControlOptions create() /*-{
        return {};
    }-*/;
    
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;
    
    public static final native void setCollapsed(boolean collapsed) /*-{
            this.collapsed = collapsed;
    }-*/;
    
    public static final native void setCollapseLabel(String collapseLabel) /*-{
        //
    }-*/;
    
    public static final native void setCollapsible(boolean collapsible) /*-{
        this.collapsible = collapsible;
    }-*/;
    
    public static final native void setLabel(String label) /*-{
        this.label = label;
    }-*/;
    
    public static final native void setTipLabel(String tipLabel) /*-{
        this.tipLabel = tipLabel;
    }-*/;
}

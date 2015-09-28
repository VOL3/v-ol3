/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.control;

/**
 * Need set size for map! (_mapWidget.getMap().setSize(Size.create(1, 1));)
 * @author iserge
 */
public class OverviewMapControl extends Control {
    protected OverviewMapControl() {
        //
    }
    
    public static final native OverviewMapControl create() /*-{
        return new $wnd.ol.control.OverviewMap();
    }-*/;
    
    public static final native OverviewMapControl create(OverviewMapControlOptions options) /*-{
        return new $wnd.ol.control.OverviewMap(options);
    }-*/;
}

package org.vaadin.addon.vol3.util;

import org.vaadin.addon.vol3.client.style.OLCircleStyle;
import org.vaadin.addon.vol3.client.style.OLFillStyle;
import org.vaadin.addon.vol3.client.style.OLStrokeStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;

/**
 * Utility methods for handling styles
 * Created by mjhosio on 09/07/14.
 */
public class StyleUtils {

    public static final OLStyle createDefaultStyle(){
        OLStyle defaultStyle=new OLStyle();
        defaultStyle.fillStyle=createDefaultFillStyle();
        defaultStyle.strokeStyle=createDefaultStrokeStyle();
        defaultStyle.circleStyle=createDefaultCircleStyle();
        return defaultStyle;
    }

    public static OLStrokeStyle createDefaultStrokeStyle(){
        OLStrokeStyle stroke=new OLStrokeStyle();
        stroke.color="#3399CC";
        stroke.width=1.25;
        return stroke;
    }

    public static OLFillStyle createDefaultFillStyle(){
        return new OLFillStyle("rgba(255,255,255,0.4");
    }

    public static OLCircleStyle createDefaultCircleStyle(){
        OLCircleStyle circle=new OLCircleStyle();
        circle.fill=createDefaultFillStyle();
        circle.stroke=createDefaultStrokeStyle();
        circle.radius=5.0;
        return circle;
    }
}

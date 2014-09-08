package org.vaadin.addon.vol3.client.control;

import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.control.*;
import org.vaadin.gwtol3.client.proj.Projection;

import java.util.logging.Logger;

/**
 * Utility methods for dealing with controls
 */
public class OLControlUtils {

    private static final Logger logger= Logger.getLogger(OLControlUtils.class.getName());

    public static final AttributionControl createAttributionControl(OLAttributionControl attribution){
        return attribution.className!=null ? AttributionControl.create(attribution.className) : AttributionControl.create();
    }

    public static final FullScreenControl createFullScreenControl(OLFullScreenControl fullScreen){
        FullScreenControlOptions opts=FullScreenControlOptions.create();
        if(fullScreen.fullKeyboardAccess!=null){
            opts.setFullKeyboardAccess(fullScreen.fullKeyboardAccess);
        }
        if(fullScreen.className!=null){
            opts.setClassName(fullScreen.className);
        }
        if(fullScreen.tipLabel!=null){
            opts.setTipLabel(fullScreen.tipLabel);
        }
        return FullScreenControl.create(opts);
    }

    public static final MousePositionControl createMousePositionControl(OLMousePositionControl mousePos){
        MousePositionControlOptions opts=MousePositionControlOptions.create();
        if(mousePos.className!=null){
            opts.setClassName(mousePos.className);
        }
        if(mousePos.projection!=null){
            opts.setProjection(Projection.get(mousePos.projection));
        }
        if(mousePos.undefinedHTML!=null){
            opts.setUndefinedHTML(mousePos.undefinedHTML);
        }
        return MousePositionControl.create(opts);
    }

    public static final RotateControl createRotateControl(OLRotateControl rotate){
        RotateControlOptions opts=RotateControlOptions.create();
        if(rotate.className!=null){
            opts.setClassName(rotate.className);
        }
        if(rotate.label!=null){
            opts.setLabel(rotate.label);
        }
        if(rotate.tipLabel!=null){
            opts.setLabel(rotate.tipLabel);
        }
        if(rotate.duration!=null){
            opts.setDuration(rotate.duration);
        }
        if(rotate.autoHide!=null){
            opts.setAutoHide(rotate.autoHide);
        }
        return RotateControl.create(opts);
    }

    public static final ScaleLineControl createScaleLineControl(OLScaleLineControl scale){
        ScaleLineControlOptions opts= ScaleLineControlOptions.create();
        if(scale.className!=null){
            opts.setClassName(scale.className);
        }
        if(scale.minWidth!=null){
            opts.setMinWidth(scale.minWidth);
        }
        if(scale.units!=null){
            opts.setUnits(scale.units);
        }
        return ScaleLineControl.create(opts);
    }

    public static final ZoomControl createZoomControl(OLZoomControl zoom){
        ZoomControlOptions opts= ZoomControlOptions.create();
        if(zoom.className!=null){
            opts.setClassName(zoom.className);
        }
        if(zoom.duration!=null){
            opts.setDuration(zoom.duration);
        }
        if(zoom.zoomInLabel!=null){
            opts.setZoomInLabel(zoom.zoomInLabel);
        }
        if(zoom.zoomOutLabel!=null){
            opts.setZoomOutLabel(zoom.zoomOutLabel);
        }
        if(zoom.zoomInTipLabel!=null){
            opts.setZoomInTipLabel(zoom.zoomInTipLabel);
        }
        if(zoom.zoomOutTipLabel!=null){
            opts.setZoomOutTipLabel(zoom.zoomOutTipLabel);
        }
        if(zoom.delta!=null){
            opts.setDelta(zoom.delta);
        }
        return ZoomControl.create(opts);
    }

    public static final ZoomSliderControl createZoomSliderControl(OLZoomSliderControl zoom){
        ZoomSliderControlOptions opts= ZoomSliderControlOptions.create();
        if(zoom.className!=null){
            opts.setClassName(zoom.className);
        }
        if(zoom.minResolution!=null){
            opts.setMinResolution(zoom.minResolution);
        }
        if(zoom.maxResolution!=null){
            opts.setMaxResolution(zoom.maxResolution);
        }
        return ZoomSliderControl.create(opts);
    }

    public static final ZoomToExtentControl createZoomToExtentControl(OLZoomToExtentControl zoom){
        ZoomToExtentControlOptions opts= ZoomToExtentControlOptions.create();
        if(zoom.className!=null){
            opts.setClassName(zoom.className);
        }
        if(zoom.tipLabel!=null){
            opts.setTipLabel(zoom.tipLabel);
        }
        if(zoom.extent!=null){
            opts.setExtent(Extent.create(zoom.extent.minX,zoom.extent.minY, zoom.extent.maxX, zoom.extent.maxY));
        }
        return ZoomToExtentControl.create(opts);
    }
}

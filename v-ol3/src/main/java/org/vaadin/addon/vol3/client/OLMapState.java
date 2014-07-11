package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;
import org.vaadin.addon.vol3.client.control.*;

/**
 * Created by mjhosio on 27/06/14.
 */
public class OLMapState extends AbstractComponentState {
    public Boolean showOl3Logo;
    public OLRendererType renderer;
    public Double pixelRatio;
    public OLDeviceOptions deviceOptions;
    // controls added to the map
    public OLAttributionControl attributionControl;
    public OLFullScreenControl fullScreenControl;
    public OLLogoControl logoControl;
    public OLMousePositionControl mousePositionControl;
    public OLRotateControl rotateControl;
    public OLScaleLineControl scaleLineControl;
    public OLZoomControl zoomControl;
    public OLZoomSliderControl zoomSliderControl;
    public OLZoomToExtentControl zoomToExtentControl;
}

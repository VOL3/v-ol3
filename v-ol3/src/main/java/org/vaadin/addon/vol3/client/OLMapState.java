package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;
import org.vaadin.addon.vol3.client.control.*;

import java.util.List;
import java.util.Map;

/**
 * State for the map
 */
public class OLMapState extends AbstractComponentState {
    public Boolean showOl3Logo;
    public OLRendererType renderer;
    public Double pixelRatio;
    // coordinate system definitions
    public Map<String,String> coordinateSystemDefinitions;
    // controls added to the map
    public OLAttributionControl attributionControl;
    public OLFullScreenControl fullScreenControl;
    public OLMousePositionControl mousePositionControl;
    public OLRotateControl rotateControl;
    public OLScaleLineControl scaleLineControl;
    public OLZoomControl zoomControl;
    public OLZoomSliderControl zoomSliderControl;
    public OLZoomToExtentControl zoomToExtentControl;
    public boolean hasClickListeners;
    public Boolean loadTilesWhileAnimating;
    public Boolean loadTilesWhileInteracting;
    public String inputProjection;
    public List<OLOverlay> overlays;
}

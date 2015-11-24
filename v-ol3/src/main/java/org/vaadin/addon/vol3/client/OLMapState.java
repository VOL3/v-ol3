package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;

import java.util.List;
import java.util.Map;

import org.vaadin.addon.vol3.client.control.OLAttributionControl;
import org.vaadin.addon.vol3.client.control.OLFullScreenControl;
import org.vaadin.addon.vol3.client.control.OLLayerSwitcherControl;
import org.vaadin.addon.vol3.client.control.OLMousePositionControl;
import org.vaadin.addon.vol3.client.control.OLRotateControl;
import org.vaadin.addon.vol3.client.control.OLScaleLineControl;
import org.vaadin.addon.vol3.client.control.OLZoomControl;
import org.vaadin.addon.vol3.client.control.OLZoomSliderControl;
import org.vaadin.addon.vol3.client.control.OLZoomToExtentControl;

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
    public OLLayerSwitcherControl layerSwitcherControl;
    public boolean hasClickListeners;
    public Boolean loadTilesWhileAnimating;
    public Boolean loadTilesWhileInteracting;
    public String inputProjection;
    public List<OLOverlay> overlays;
}

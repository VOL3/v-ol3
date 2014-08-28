package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;
import org.vaadin.addon.vol3.client.style.OLStyle;

import java.util.List;

/**
 * Created by mjhosio on 25/08/14.
 */
public class OLDrawInteractionState extends AbstractComponentState {
    // Pixel distance for snapping to the drawing finish. Default is 12.
    public Double snapTolerance;
    //  the drawing type ('Point', 'LineString', 'Polygon', 'MultiPoint', 'MultiLineString', or 'MultiPolygon')
    public String type;
    // The number of points that must be drawn before a polygon ring can be finished. Default is 3
    public Double minPointsPerRing;
    // the style for the sketch features
    public List<OLStyle> featureStyles;
    // geometry name for the drawn features
    public String geometryName;
    // destination layer for the drawn features
    public Connector layer;

}

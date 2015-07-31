package org.vaadin.addon.vol3.client.feature;

import org.vaadin.gwtol3.client.format.GeoJSONFormat;
import org.vaadin.gwtol3.client.geom.Geometry;

import java.util.logging.Logger;

/**
 * Serializer for geometries used on the client side
 */
public class GeometrySerializer {

    private static final Logger logger = Logger.getLogger(GeometrySerializer.class.getName());

    private static final GeoJSONFormat serializer=GeoJSONFormat.create();

    public static Geometry readGeometry(String serializedGeometry, String sourceProjection, String targetProjection){
        return serializer.readGeometry(serializedGeometry, sourceProjection, targetProjection);
    }

    /** We always write the geometry in EPSG4326
     *
     * @param geometry
     * @param sourceProjection
     * @return
     */
    public static String writeGeometry(Geometry geometry, String sourceProjection, String targetProjection){
        return serializer.writeGeometry(geometry, sourceProjection, targetProjection);
    }

}

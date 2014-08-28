package org.vaadin.addon.vol3.client.feature;

import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.gwtol3.client.format.GeoJSONFormat;
import org.vaadin.gwtol3.client.geom.Geometry;

import java.util.logging.Logger;

/**
 * /** Serializer for geometries used on the client side
 * Created by mjhosio on 27/08/14.
 */
public class GeometrySerializer {

    private static final Logger logger= Logger.getLogger(GeometrySerializer.class.getName());

    private static final GeoJSONFormat serializer=GeoJSONFormat.create();

    public static Geometry readGeometry(String serializedGeometry, String targetGeometry){
        Geometry geometry=serializer.readGeometry(serializedGeometry, Projections.EPSG4326, targetGeometry);
        // it seems GeoJSONFormat does not (yet) project the coordinates on the fly, hence we need to do it manually
        geometry.transform(Projections.EPSG4326, targetGeometry);
        return geometry;
    }

    /** We always write the geometry in EPSG4326
     *
     * @param geometry
     * @param sourceProjection
     * @return
     */
    public static String writeGeometry(Geometry geometry, String sourceProjection){
//        logger.info("###writing geometry "+sourceProjection+" -> "+Projections.EPSG4326);
//        logger.info(serializer.writeGeometry(geometry, sourceProjection, Projections.EPSG4326));
//        logger.info(serializer.writeGeometry(geometry, sourceProjection, Projections.EPSG3857));
        // it seems GeoJSONFormat does not (yet) project the coordinates on the fly, hence we need to do it manually
        if(!sourceProjection.equals(Projections.EPSG4326)){
            geometry=geometry.clone();
            geometry.transform(sourceProjection, Projections.EPSG4326);
        }
        return serializer.writeGeometry(geometry, sourceProjection, Projections.EPSG4326);
    }

}

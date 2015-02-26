package org.vaadin.gwtol3.client.proj;

import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;

/**
 * Created by mjhosio on 25/02/15.
 */
public class Transform {

	public static native final Coordinate transform(Coordinate coordinate, String sourceProjection, String targetProjection)/*-{
		if(sourceProjection==targetProjection){
			return coordinate;
		}
        return $wnd.ol.proj.transform(coordinate, sourceProjection, targetProjection);
	}-*/;

	public static native final Extent transformExtent(Extent extent, String sourceProjection, String targetProjection)/*-{
		if(sourceProjection == targetProjection){
			return extent;
		}
        return $wnd.ol.proj.transform(extent, sourceProjection, targetProjection);
    }-*/;

}

package org.vaadin.addon.vol3.client.util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;

/**
 * Utility class for performing data type conversions
 * Created by mjhosio on 23/02/15.
 */
public class DataConversionUtils {

	public static JsArrayNumber toJsArrayNumber(double [] array) {
		JsArrayNumber jsArray = JsArrayNumber.createArray().cast();
		for (double value : array) {
			jsArray.push(value);
		}
		return jsArray;
	}

	public static JsArrayInteger toJsArrayInteger(int [] array) {
		JsArrayInteger jsArray = JsArrayInteger.createArray().cast();
		for (int value : array) {
			jsArray.push(value);
		}
		return jsArray;
	}


	public static JsArrayString toJsArrayString(String [] array){
		JsArrayString jsArray = JsArrayString.createArray().cast();
		for(String value : array){
			jsArray.push(value);
		}
		return jsArray;
	}

	public static JsArray<Coordinate> toJsArrayCoordinate(OLCoordinate [] coordinates) {
		JsArray<Coordinate> coordinateArray = JsArray.createArray().cast();
		for (OLCoordinate coordinate : coordinates) {
			coordinateArray.push(Coordinate.create(coordinate.x, coordinate.y));
		}
		return coordinateArray;
	}

	public static native final Extent transformExtent(String sourceProjection, String targetProjection, Extent extent)/*-{
        return $wnd.ol.proj.transformExtent(extent, sourceProjection, targetProjection);
	}-*/;

	public static native final Coordinate transformCoordinate(String sourceProjection, String targetProjection, Coordinate coordinate)/*-{
        return $wnd.ol.proj.transformExtent(coordinate, sourceProjection, targetProjection);
    }-*/;

}

package org.vaadin.addon.vol3.client.util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.gwtol3.client.Coordinate;

/**
 * Utility class for performing data type conversions
 * Created by mjhosio on 23/02/15.
 */
public class DataConversionUtils {

	public static JsArrayNumber toJsArrayNumber(double [] array) {
		JsArrayNumber jsArray = JsArrayNumber.createArray(array.length).cast();
		for (double value : array) {
			jsArray.push(value);
		}
		return jsArray;
	}

	public static JsArrayString toJsArrayString(String [] array){
		JsArrayString jsArray = JsArrayString.createArray(array.length).cast();
		for(String value : array){
			jsArray.push(value);
		}
		return jsArray;
	}

	public static JsArray<Coordinate> toJsArrayCoordinate(OLCoordinate [] coordinates) {
		JsArray<Coordinate> coordinateArray = JsArray.createArray(coordinates.length).cast();
		for (OLCoordinate coordinate : coordinates) {
			coordinateArray.push(Coordinate.create(coordinate.x, coordinate.y));
		}
		return coordinateArray;
	}
}

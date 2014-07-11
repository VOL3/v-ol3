package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A control displaying rough x-axis distances. By default it will show in the bottom left portion of the map, but this can be changed by using the css selector .ol-scale-line.
 * Created by mjhosio on 11/07/14.
 */
public class OLScaleLineControl implements Serializable {

    //the css class name of the control. Default is ol-scale-line
    public String className;
    // The minimum width of the scale line in pixels. Default is 64
    public Integer minWidth;
    // Units of the scale line ('degrees', 'imperial', 'nautical', 'metric', 'us') Default is metric.
    public String units;

    public static final String UNITS_DEGREES="degrees";
    public static final String UNITS_IMPERIAL="imperial";
    public static final String UNITS_NAUTICAL="nautical";
    public static final String UNITS_METRIC="metric";
    public static final String UNITS_US="us";

}

package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Created by Vaadin Ltd / mjhosio on 13/11/15.
 */
public class OLOverlay implements Serializable {

	public static final String POSITION_BOTTOM_LEFT="bottom-left";
	public static final String POSITION_BOTTOM_CENTER="bottom-center";
	public static final String POSITION_BOTTOM_RIGHT="bottom-right";
	public static final String POSITION_CENTER_LEFT="center-left";
	public static final String POSITION_CENTER_CENTER="center-center";
	public static final String POSITION_CENTER_RIGHT="center-right";
	public static final String POSITION_TOP_LEFT="top-left";
	public static final String POSITION_TOP_CENTER="top-center";
	public static final String POSITION_TOP_RIGHT="top-right";

	public String htmlContent;
	public int [] offset;
	public OLCoordinate position;
	public String positioning;
	public Boolean stopEvent;
	public Boolean insertFirst;
	public String classNames;
}

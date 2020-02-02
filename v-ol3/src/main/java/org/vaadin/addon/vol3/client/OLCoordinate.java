package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Models a coordinate in some projection units
 */
public class OLCoordinate implements Serializable {
	private static final long serialVersionUID = 1L;

	public double x;
	public double y;
	
	public OLCoordinate() {
		x = 0.0;
		y = 0.0;
	}

	public OLCoordinate(double lon, double lat) {
		x = lon;
		y = lat;
	}

	public double getLon() {
		return x;
	}

	public double getLat() {
		return y;
	}

	@Override
	public String toString() {
		return "OLCoordinate{" + "x=" + x + ", y=" + y + "}";
	}
}

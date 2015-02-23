package org.vaadin.addon.vol3.client.tilegrid;

import java.util.Arrays;

import org.vaadin.addon.vol3.client.OLCoordinate;


public class OLWMTSTileGridOptions {

	public OLCoordinate origin;
	public OLCoordinate[] origins;
	public Double[] resolutions;
	public String[] matrixIds;
	public Double tileSize;
	public Double[] tileSizes;
	@Override
	public String toString() {
		return "OLWMTSTileGridOptions [origin=" + origin + ", origins="
				+ Arrays.toString(origins) + ", resolutions="
				+ Arrays.toString(resolutions) + ", matrixIds="
				+ Arrays.toString(matrixIds) + ", tileSize=" + tileSize
				+ ", tileSizes=" + Arrays.toString(tileSizes) + "]";
	}
	
	
	
}
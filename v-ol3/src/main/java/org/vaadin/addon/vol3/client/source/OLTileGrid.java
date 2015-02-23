package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.OLCoordinate;

import java.io.Serializable;

/**
 * Created by mjhosio on 23/02/15.
 */
public class OLTileGrid implements Serializable{

	public Double minZoom;
	public Double maxZoom;
	public OLCoordinate origin;
	public OLCoordinate [] origins;
	public double [] resolutions;
	public Double tileSize;
	public double [] tileSizes;
	public String[] matrixIds;
//
//	@Override
//	public String toString() {
//		return "OLWMTSTileGridOptions [origin=" + origin + ", origins="
//				+ Arrays.toString(origins) + ", resolutions="
//				+ Arrays.toString(resolutions) + ", matrixIds="
//				+ Arrays.toString(matrixIds) + ", tileSize=" + tileSize
//				+ ", tileSizes=" + Arrays.toString(tileSizes) + "]";
//	}
}

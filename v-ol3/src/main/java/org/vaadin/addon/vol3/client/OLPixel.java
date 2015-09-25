package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Created by Vaadin Ltd / mjhosio on 25/09/15.
 */
public class OLPixel implements Serializable{

	public int x;
	public int y;

	public OLPixel(){
		x=0;
		y=0;
	}

	public OLPixel(int xCoord, int yCoord){
		x=xCoord;
		y=yCoord;
	}


	@Override
	public String toString() {
		return "OLPixel{" +	"x=" + x +", y=" + y +'}';
	}
}

package org.vaadin.addon.vol3.client;

import java.io.Serializable;


public class OLSize implements Serializable{
	
	public Double width;
	public Double height;
	
	public OLSize(){
		width = 0.0;
		height = 0.0;
	}
	
	public OLSize(double width, double height){
		this.width = width;
		this.height = height;
	}
	
}

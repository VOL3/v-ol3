package org.vaadin.addon.vol3.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Click event
 */
public class OLClickEvent implements Serializable {
	private OLCoordinate coordinate;
	private EventType eventType;
	// list of feature info urls in case there are visible WMS layers displayed on the map
	List<String> featureInfoUrls;

	public OLClickEvent(){

	}

	public OLClickEvent(OLCoordinate coordinate, EventType type){
		this.coordinate=coordinate;
		this.eventType=type;
	}

	public OLCoordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(OLCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public static enum EventType{
		SINGLE_CLICK, DOUBLE_CLICK;
	}

	public List<String> getFeatureInfoUrls() {
		return featureInfoUrls;
	}

	public void setFeatureInfoUrls(List<String> featureInfoUrls) {
		this.featureInfoUrls = featureInfoUrls;
	}

	public void addFeatureInfoUrl(String url){
		if(this.featureInfoUrls==null){
			this.featureInfoUrls=new ArrayList<String>();
		}
		this.featureInfoUrls.add(url);
	}

	public String toString(){
		String representation=this.eventType+" "+coordinate.toText();
		if(featureInfoUrls!=null && featureInfoUrls.size()>0){
			representation+=" featureInfoUrls: "+featureInfoUrls;
		}
		return representation;
	}
}



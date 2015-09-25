package org.vaadin.gwtol3.client.map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Pixel;

/**
 * Created by Vaadin Ltd / mjhosio on 25/09/15.
 */
public class ClickEvent extends JavaScriptObject{

	public static enum Type{LEFT_CLICK, RIGHT_CLICK, DOUBLE_CLICK}

	protected ClickEvent() {
	}

	public native final Coordinate getCoordinate()/*-{
		return this.coordinate;
    }-*/;

	public native final Pixel getPixel()/*-{
		return this.pixel;
    }-*/;

	public native final NativeEvent getNativeEvent()/*-{
		return this.nativeEvent;
	}-*/;

	public final Type getType(){
		String type = getTypeNative();
		if(type.equals("leftclick")){
			return Type.LEFT_CLICK;
		} else if(type.equals("doubleclick")){
			return Type.DOUBLE_CLICK;
		}
		else{
			return Type.RIGHT_CLICK;
		}
	}

	private native final String getTypeNative()/*-{
		return this.type;
	}-*/;

}

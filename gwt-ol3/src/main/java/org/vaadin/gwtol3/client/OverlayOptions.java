package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.dom.client.Element;
import org.vaadin.gwtol3.client.animation.PanOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 13/11/15.
 */
public class OverlayOptions extends JavaScriptObject {
	protected OverlayOptions() {

	}

	public static native OverlayOptions create()
    /*-{
        return {};
    }-*/;

	public native final void setElement(Element element)
    /*-{
        this.element = element;
    }-*/;

	public native final void setOffset(JsArrayInteger offset)
    /*-{
        this.offset=offset;
    }-*/;

	public native final void setPosition(Coordinate position)
    /*-{
        this.position=position;
    }-*/;

	public native final void setPositioning(String positioning)
    /*-{
        this.positioning=positioning;
    }-*/;

	public native final void setStopEvent(boolean stopEvent)
    /*-{
        this.stopEvent=stopEvent;
    }-*/;

	public native final void setInsertFirst(boolean insertFirst)
    /*-{
        this.insertFirst = insertFirst;
    }-*/;
        
    public final native void setAutoPan(Boolean autoPan) /*-{
        this.autoPan = autoPan;
    }-*/;
    
    public final native void setAutoPanMargin(Integer autoPanMargin) /*-{
        this.autoPanMargin = autoPanMargin;
    }-*/;
    
    public final native void setAutoPanAnimation(PanOptions panOptions) /*-{
        this.autoPanAnimation = panOptions;
    }-*/;
}

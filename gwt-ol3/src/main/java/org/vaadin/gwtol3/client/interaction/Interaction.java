package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for all the interactions
 */
public class Interaction extends JavaScriptObject{
    protected Interaction(){}
    
    public final native void setActive(boolean active) /*-{
        this.setActive(active);
    }-*/;
    
    public final native boolean getActive() /*-{
        return this.getActive();
    }-*/;
}

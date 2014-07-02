package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for layer sources.
 * Created by mjhosio on 24/06/14.
 */
public abstract class Source extends JavaScriptObject{

    public static final String STATE_LOADING="loading";
    public static final String STATE_READY="ready";
    public static final String STATE_ERROR="error";

    protected Source(){

    }

    /** Returns the state of the source (loading, ready, error)
     * @return the state of the source
     */
    public final native String getState()/*-{
        return this.getState();
    }-*/;
}

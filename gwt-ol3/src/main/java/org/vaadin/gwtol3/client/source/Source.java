package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Logo;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for layer sources.
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

    /** Returns the attributions for the source
     * @return the attributions
     */
    public final native JsArray<Attribution> getAttributions()/*-{
        return this.getAttributions();
    }-*/;

    /** Returns the logo for the source
     * @return the logo
     */
    public final native Logo getLogo()/*-{
        return this.getLogo();
    }-*/;

    /** Returns the projection for the source
     * @return the projection for the source
     */
    public final native Projection getProjection()/*-{
        return this.getProjection();
    }-*/;





}

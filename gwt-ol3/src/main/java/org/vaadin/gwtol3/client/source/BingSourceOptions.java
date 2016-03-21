package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by Martin Stypinski 20/03/2016
 */
public class BingSourceOptions extends JavaScriptObject {


    protected BingSourceOptions() {
    }

    public static native final BingSourceOptions create()/*-{
        return {};
    }-*/;

     /** Sets the cross origin setting for image requests. Default is 'anonymous'
     *
     * @param key API-Token for access to Bing-maps
     */
    public final native void setKey(String key)/*-{
        this.key = key;
    }-*/;

    /** Sets the max zoom level for the source
     *
     * @param imagerySet to chose which basemap
     */
    public final native void setImagerySet(String imagerySet)/*-{
        this.imagerySet = imagerySet;
    }-*/;

    /** Sets the max zoom level for the source
     *
     * @param culture to chose rendering language
     */
    public final native void setCulture(String culture)/*-{
        this.culture = culture;
    }-*/;


}

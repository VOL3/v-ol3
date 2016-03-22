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

     /** Sets the API-Token to get access to Bing-maps
     *
     * @param key API-Token for access to Bing-maps
     */
    public final native void setKey(String key)/*-{
        this.key = key;
    }-*/;

    /** Chooses BaseMap, Strings according to: https://msdn.microsoft.com/en-us/library/gg427625.aspx
     *
     * @param imagerySet to chose which basemap
     */
    public final native void setImagerySet(String imagerySet)/*-{
        this.imagerySet = imagerySet;
    }-*/;

    /** Adjust language of map, according to: https://msdn.microsoft.com/en-us/library/hh441729.aspx
     *  Default is 'en-us'
     *
     * @param culture to chose rendering language
     */
    public final native void setCulture(String culture)/*-{
        this.culture = culture;
    }-*/;


}

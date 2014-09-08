package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options for the WFSFormat
 */
public class WFSFormatOptions extends JavaScriptObject{
    protected WFSFormatOptions() {
    }

    public static final native WFSFormatOptions create()/*-{
        return {}
    }-*/;

    /** Sets feature namespace
     *
     * @param featureNS
     */
    public final native void setFeatureNS(String featureNS)/*-{
        this.featureNS=featureNS;
    }-*/;

    /** Sets feature type
     *
     * @param featureType
     */
    public final native void setFeatureType(String featureType)/*-{
        this.featureType=featureType;
    }-*/;

    /** Optional schemaLocation to use for serialization, this will override the default provided.
     *
     * @param schemaLocation
     */
    public final native void setSchemaLocation(String schemaLocation)/*-{
        this.schemaLocation=schemaLocation;
    }-*/;
}

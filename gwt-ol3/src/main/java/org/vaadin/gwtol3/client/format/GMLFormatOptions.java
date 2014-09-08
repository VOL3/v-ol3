package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;

/** Options for the GMLFormat
 *
 */
public class GMLFormatOptions extends JavaScriptObject {
    protected GMLFormatOptions() {
    }

    public static final native GMLFormatOptions create()/*-{
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

    /** Sets srsName to use when writing geometries
     *
     * @param srcName
     */
    public final native void setSrcName(String srcName)/*-{
        this.srcName=srcName;
    }-*/;

    /** Write gml:Surface instead of gml:Polygon elements. This also affects the elements in multi-part geometries. Default is false
     *
     * @param surface
     */
    public final native void setSurface(boolean surface)/*-{
        this.surface=surface;
    }-*/;

    /**Write gml:Curve instead of gml:LineString elements. This also affects the elements in multi-part geometries. Default is false.
     *
     * @param curve
     */
    public final native void setCurve(boolean curve)/*-{
        this.curve=curve;
    }-*/;

    /** Write gml:MultiCurve instead of gml:MultiLineString. Since the latter is deprecated in GML 3, the default is true.
     *
     * @param multiCurve
     */
    public final native void setMultiCurve(boolean multiCurve)/*-{
        this.multiCurve=multiCurve;
    }-*/;

    /** Write gml:multiSurface instead of gml:MultiPolygon. Since the latter is deprecated in GML 3, the default is true.
     *
      * @param multiSurface
     */
    public final native void setMultiSurface(boolean multiSurface)/*-{
        this.multiSurface=multiSurface;
    }-*/;

    /** Optional schemaLocation to use when writing out the GML, this will override the default provided.
     *
      * @param schemaLocation
     */
    public final native void setSchemaLocation(String schemaLocation)/*-{
        this.schemaLocation=schemaLocation;
    }-*/;
}

package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.style.OLStyle;

import java.util.List;

/**
 * Options for the draw interaction
 * Created by mjhosio on 25/08/14.
 */
public class OLDrawInteractionOptions {

    public enum DrawingType{
        POINT, LINESTRING, POLYGON, MULTIPOINT, MULTILINESTRING, MULTIPOLYGON;
    }

    // Pixel distance for snapping to the drawing finish. Default is 12.
    private Double snapTolerance;
    //  the drawing type
    private DrawingType type;
    // The number of points that must be drawn before a polygon ring can be finished. Default is 3
    private Double minPointsPerRing;
    // the style for the sketch features
    private List<OLStyle> styles;
    // geometry name for the drawn features
    private String geometryName;

    /** Gets pixel distance for snapping to the drawing finish.
     *
     * @return
     */
    public Double getSnapTolerance() {
        return snapTolerance;
    }

    /** Sets pixel distance for snapping to the drawing finish. Default is 12.
     *
     * @param snapTolerance
     */
    public void setSnapTolerance(Double snapTolerance) {
        this.snapTolerance = snapTolerance;
    }

    /** Gets the drawing type
     *
     * @return
     */
    public DrawingType getType() {
        return type;
    }

    /** Sets the drawing type
     *
     * @param type
     */
    public void setType(DrawingType type) {
        this.type = type;
    }

    /** Gets the number of points that must be drawn before a polygon ring can be finished.
     *
     * @return
     */
    public Double getMinPointsPerRing() {
        return minPointsPerRing;
    }

    /** Sets the number of points that must be drawn before a polygon ring can be finished. Default is 3
     *
     * @param minPointsPerRing
     */
    public void setMinPointsPerRing(Double minPointsPerRing) {
        this.minPointsPerRing = minPointsPerRing;
    }

    /** Gets the style used for the sketch features
     *
     * @return
     */
     public List<OLStyle> getStyles() {
        return styles;
    }

    /** Sets the style for the sketch features
     *
     * @param styles
     */
     public void setStyles(List<OLStyle> styles) {
        this.styles = styles;
    }

    /** Gets geometry name for the drawn features
     *
     * @return
     */
     public String getGeometryName() {
        return geometryName;
    }

    /** Sets the geometry name for the drawn features
     *
     * @param geometryName
     */
    public void setGeometryName(String geometryName) {
        this.geometryName = geometryName;
    }

    static String getTypeAsString(DrawingType type){
        switch(type){
            case POINT : return "Point";
            case LINESTRING: return "LineString";
            case POLYGON: return "Polygon";
            case MULTIPOINT: return "MultiPoint";
            case MULTILINESTRING: return "MultiLineString";
            case MULTIPOLYGON: return "MultiPolygon";
            default: return "";
        }
    }
}

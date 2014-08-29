package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.style.OLStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Feature implementation for the vector layer.
 * Created by mjhosio on 07/07/14.
 */
public class OLFeature implements Serializable{
    // id of the feature
    private String id;
    // geometry of the feature (the marker drawn on the map)
    private OLGeometry geometry;
    // styles used when drawing the geometry
    private List<OLStyle> styles=new ArrayList<OLStyle>();

    /** Creates a new instance of the feature
     *
     */
    public OLFeature(){
        super();
    }

    /** Creates a new instance of the feature with specified id. If you don't specify the id, it will be generated
     * when the feature is added to the Vector layer
     *
     * @param id the id of the feature
     */
    public OLFeature(String id){
        super();
        this.id=id;
    }

    /** Sets the geometry of the feature
     *
     * @param geometry the geometry
     */
    public void setGeometry(OLGeometry geometry){
        this.geometry=geometry;
    }

    public String getId() {
        return id;
    }

    /** Sets the id of the feature
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    public OLGeometry getGeometry() {
        return geometry;
    }

    public List<OLStyle> getStyles() {
        return styles;
    }

    /** Sets the feature-specific style used when the feature is drawn. This style overrides the styles specified on the Vector layer
     *
     * @param style
     */
    public void setStyle(OLStyle style){
        styles.clear();
        styles.add(style);
    }

    /** Sets the feature-specific styles used when the feature is drawn. This style overrides the styles specified on the Vector layer
     *
     * @param styles
     */
    public void setStyles(List<OLStyle> styles){
        this.styles.clear();
        this.styles.addAll(styles);
    }
}

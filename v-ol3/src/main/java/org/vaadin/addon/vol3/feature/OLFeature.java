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
    private String id;
    private OLGeometry geometry;
    private List<OLStyle> styles=new ArrayList<OLStyle>();

    public OLFeature(){
        super();
    }

    public OLFeature(String id){
        super();
        this.id=id;
    }

    public void setGeometry(OLGeometry geometry){
        this.geometry=geometry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OLGeometry getGeometry() {
        return geometry;
    }

    public List<OLStyle> getStyles() {
        return styles;
    }

    public void setStyle(OLStyle style){
        styles.clear();
        styles.add(style);
    }

    public void setStyles(List<OLStyle> styles){
        this.styles.clear();
        this.styles.addAll(styles);
    }
}

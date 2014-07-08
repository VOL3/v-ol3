package org.vaadin.addon.vol3.feature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.GeoJsonObject;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;
import org.vaadin.addon.vol3.client.style.OLStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OLFeature implements Serializable{
    private String id;
    private GeoJsonObject geometry;
    private List<OLStyle> styles=new ArrayList<OLStyle>();

    private static final ObjectMapper mapper=new ObjectMapper();

    public OLFeature(String id){
        super();
        this.id=id;
    }

    public void setGeometry(GeoJsonObject geometry){
        this.geometry=geometry;
    }

    public String getId() {
        return id;
    }

    public GeoJsonObject getGeometry() {
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

    public SerializedFeature asSerializedFeature() {
        SerializedFeature serialized=new SerializedFeature();
        serialized.id=id;
        serialized.styles=styles;
        if(geometry!=null) {
            serialized.serializedGeometry=serializeGeometry(geometry);
        }
        return serialized;
    }

    private String serializeGeometry(GeoJsonObject geometry){
        try {
            return mapper.writeValueAsString(geometry);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

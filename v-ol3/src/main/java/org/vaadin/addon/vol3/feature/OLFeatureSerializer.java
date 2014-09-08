package org.vaadin.addon.vol3.feature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.*;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Serializes the features so that they can be sent to the client side
 */
public class OLFeatureSerializer {

    private static final Logger logger= Logger.getLogger(OLFeatureSerializer.class.getName());

    private static final ObjectMapper mapper=new ObjectMapper();

    public static SerializedFeature serializeFeature(OLFeature feature) {
        SerializedFeature serialized=new SerializedFeature();
        serialized.id=feature.getId();
        if(feature.getStyles().size()>0){
            serialized.styles=feature.getStyles();
        }
        if(feature.getGeometry()!=null) {
            serialized.serializedGeometry=serializeGeometry(feature.getGeometry());
        }
        return serialized;
    }

    public static String serializeGeometry(OLGeometry geometry){
            GeoJsonObject geoJsonObject=null;
            if(geometry instanceof OLPoint){
                geoJsonObject= convertPoint((OLPoint) geometry);
            } else if(geometry instanceof OLPolygon){
                geoJsonObject= convertPolygon((OLPolygon) geometry);
            } else if(geometry instanceof OLLineString){
                geoJsonObject= convertLineString((OLLineString) geometry);
            } else if(geometry instanceof OLMultiPoint){
                geoJsonObject= convertMultiPoint((OLMultiPoint) geometry);
            } else if(geometry instanceof OLMultiLineString){
                geoJsonObject= convertMultiLineString((OLMultiLineString) geometry);
            } else if(geometry instanceof OLMultiPolygon){
                geoJsonObject= convertMultiPolygon((OLMultiPolygon) geometry);
            } else{
                return "";
            }
        try {
            return mapper.writeValueAsString(geoJsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Point convertPoint(OLPoint point){
        return new Point(asLngLatAlt(point.elements.get(0)));
    }

    private static LineString convertLineString(OLLineString lineString){
        LineString geoJsonLineString=new LineString();
        geoJsonLineString.setCoordinates(asLngLatAlts(lineString.elements));
        return geoJsonLineString;
    }

    private static Polygon convertPolygon(OLPolygon polygon){
        Polygon geoJsonPolygon=new Polygon();
        for(List<OLCoordinate> element : polygon.elements){
            geoJsonPolygon.add(asLngLatAlts(element));
        }
        return geoJsonPolygon;
    }

    private static MultiPoint convertMultiPoint(OLMultiPoint multiPoint){
        MultiPoint geoJsonMultiPoint=new MultiPoint();
        for(OLPoint element : multiPoint.elements){
            geoJsonMultiPoint.add(asLngLatAlt(element.elements.get(0)));
        }
        return geoJsonMultiPoint;
    }

    private static MultiLineString convertMultiLineString(OLMultiLineString geometry) {
        MultiLineString geoJson=new MultiLineString();
        for(OLLineString lineString : geometry.elements){
            geoJson.add(asLngLatAlts(lineString.elements));
        }
        return geoJson;
    }

    private static MultiPolygon convertMultiPolygon(OLMultiPolygon geometry) {
        MultiPolygon geoJson=new MultiPolygon();
        for(OLPolygon polygon : geometry.elements){
            geoJson.add(convertPolygon(polygon));
        }
        return geoJson;
    }

    private static LngLatAlt asLngLatAlt(OLCoordinate coord){
        return new LngLatAlt(coord.x, coord.y);
    }

    private static List<LngLatAlt> asLngLatAlts(List<OLCoordinate> coords){
        List<LngLatAlt> result=new LinkedList<LngLatAlt>();
        for(OLCoordinate coord : coords){
            result.add(asLngLatAlt(coord));
        }
        return result;
    }

    public static OLFeature deSerializeFeature(SerializedFeature serializedFeature){
        OLFeature feature=new OLFeature(serializedFeature.id);
        feature.setStyles(serializedFeature.styles);
        feature.setGeometry(deSerializeGeometry(serializedFeature.serializedGeometry));
        return feature;
    }

    public static final OLGeometry deSerializeGeometry(String valueString){
        try {
            OLGeometry result;
            GeoJsonObject geometry = mapper.readValue(valueString,GeoJsonObject.class);
            if(geometry instanceof Point){
                result= convertPoint((Point) geometry);
            } else if(geometry instanceof Polygon){
                result= convertPolygon((Polygon) geometry);
            } else if(geometry instanceof LineString){
                result= convertLineString((LineString) geometry);
            } else if(geometry instanceof MultiPoint){
                result= convertMultiPoint((MultiPoint) geometry);
            } else if(geometry instanceof MultiLineString){
                result= convertMultiLineString((MultiLineString) geometry);
            } else if(geometry instanceof MultiPolygon){
                result= convertMultiPolygon((MultiPolygon) geometry);
            } else{
                result=null;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static OLMultiPolygon convertMultiPolygon(MultiPolygon geometry) {
        OLMultiPolygon multiPolygon=new OLMultiPolygon();
        for(List<List<LngLatAlt>> element : geometry.getCoordinates()){
            OLPolygon polygon=new OLPolygon();
            for(List<LngLatAlt> subElement : element){
                polygon.add(asCoordinates(subElement));
            }
            multiPolygon.add(polygon);
        }
        return multiPolygon;
    }

    private static OLMultiLineString convertMultiLineString(MultiLineString geometry) {
        OLMultiLineString multiLine=new OLMultiLineString();
        for(List<LngLatAlt> element : geometry.getCoordinates()){
            OLLineString line=new OLLineString();
            line.setElements(asCoordinates(element));
            multiLine.add(line);
        }
        return multiLine;
    }

    private static OLMultiPoint convertMultiPoint(MultiPoint geometry) {
        OLMultiPoint multiPoint=new OLMultiPoint();
        for(LngLatAlt element : geometry.getCoordinates()){
            multiPoint.add(new OLPoint(asCoordinate(element)));
        }
        return multiPoint;
    }

    private static OLLineString convertLineString(LineString geometry) {
        OLLineString result=new OLLineString();
        result.setElements(asCoordinates(geometry.getCoordinates()));
        return result;
    }

    private static OLPolygon convertPolygon(Polygon geometry) {
        OLPolygon result=new OLPolygon();
        for(List<LngLatAlt> element : geometry.getCoordinates()){
            result.add(asCoordinates(element));
        }
        return result;
    }

    private static OLPoint convertPoint(Point geometry) {
        return new OLPoint(asCoordinate(geometry.getCoordinates()));
    }

    private static OLCoordinate asCoordinate(LngLatAlt lngLatAlt){
        return new OLCoordinate(lngLatAlt.getLongitude(), lngLatAlt.getLatitude());
    }

    private static List<OLCoordinate> asCoordinates(List<LngLatAlt> lngLatAlts){
        List<OLCoordinate> result=new LinkedList<OLCoordinate>();
        for(LngLatAlt lngLatAlt: lngLatAlts){
            result.add(asCoordinate(lngLatAlt));
        }
        return result;
    }

}

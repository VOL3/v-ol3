package org.vaadin.addon.vol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import org.vaadin.gwtol3.client.Size;
import org.vaadin.gwtol3.client.style.*;

import java.util.List;

/**
 * Converter for converting the OLStyle class to its GWT-counterpart
 */
public class OLStyleConverter {

    public static JsArray<Style> convert(List<OLStyle> olStyles){
        JsArray<Style> styles=JsArray.createArray().cast();
        if(olStyles==null || olStyles.size()==0){
            styles.push(Style.getDefaultStyle());
        } else {
            for (OLStyle olStyle : olStyles) {
                styles.push(convert(olStyle));
            }
        }
        return styles;
    }

    public static Style convert(OLStyle olStyle){
        if(olStyle==null){
            return Style.getDefaultStyle();
        }
        StyleOptions styleOptions=StyleOptions.create();
        if(olStyle.circleStyle!=null){
            styleOptions.setImage(convertCircleStyle(olStyle.circleStyle));
        } else if(olStyle.iconStyle!=null){
            styleOptions.setImage(convertIconStyle(olStyle.iconStyle));
        }
        if(olStyle.zIndex!=null){
            setIfNotNull(styleOptions, "zIndex", olStyle.zIndex);
//            styleOptions.setZIndex(olStyle.zIndex);
        }
        if(olStyle.fillStyle!=null){
            styleOptions.setFill(convertFillStyle(olStyle.fillStyle));
        }
        if(olStyle.strokeStyle!=null){
            styleOptions.setStroke(convertStrokeStyle(olStyle.strokeStyle));
        }
        if(olStyle.textStyle!=null){
            styleOptions.setText(convertTextStyle(olStyle.textStyle));
        }
        return Style.create(styleOptions);
    }

    private static TextStyle convertTextStyle(OLTextStyle textStyle) {
        if(textStyle==null){
            return null;
        }
        TextStyleOptions opts=TextStyleOptions.create();
        setIfNotNull(opts, "stroke", convertStrokeStyle(textStyle.stroke));
        setIfNotNull(opts, "fill", convertFillStyle(textStyle.fill));
        setIfNotNull(opts, "font",textStyle.font);
        setIfNotNull(opts, "offsetX", textStyle.offsetX);
        setIfNotNull(opts, "offsetY", textStyle.offsetY);
        setIfNotNull(opts, "rotation", textStyle.rotation);
        setIfNotNull(opts, "scale", textStyle.scale);
        setIfNotNull(opts, "text", textStyle.text);
        setIfNotNull(opts, "textAlign", textStyle.textAlign);
        setIfNotNull(opts, "textBaseline", textStyle.textBaseline);
        return TextStyle.create(opts);
    }

    private static StrokeStyle convertStrokeStyle(OLStrokeStyle strokeStyle) {
        if(strokeStyle==null){
            return null;
        }
        StrokeStyleOptions opts=StrokeStyleOptions.create();
        setIfNotNull(opts, "color", strokeStyle.color);
        setIfNotNull(opts, "lineCap", strokeStyle.lineCap);
        setIfNotNull(opts, "lineDash", toJsArray(strokeStyle.lineDash));
        setIfNotNull(opts, "lineJoin", strokeStyle.lineJoin);
        setIfNotNull(opts, "miterLimit", strokeStyle.miterLimit);
        setIfNotNull(opts, "width", strokeStyle.width);
        return StrokeStyle.create(opts);
    }

    private static ImageStyle convertCircleStyle(OLCircleStyle circleStyle) {
        if(circleStyle==null){
            return null;
        }
        CircleStyleOptions opts=CircleStyleOptions.create();
        setIfNotNull(opts, "fill", convertFillStyle(circleStyle.fill));
        setIfNotNull(opts, "radius", circleStyle.radius);
        setIfNotNull(opts, "snapToPixel", circleStyle.snapToPixel);
        setIfNotNull(opts, "stroke", convertStrokeStyle(circleStyle.stroke));
        return CircleStyle.create(opts);
    }

    private static ImageStyle convertIconStyle(OLIconStyle iconStyle) {
        if(iconStyle==null){
            return null;
        }
        IconStyleOptions opts=IconStyleOptions.create();
        setIfNotNull(opts, "rotation", iconStyle.rotation);
        setIfNotNull(opts, "snapToPixel", iconStyle.snapToPixel);
        setIfNotNull(opts, "anchor", toJsArray(iconStyle.anchor));
        setIfNotNull(opts, "anchorOrigin", iconStyle.anchorOrigin);
        setIfNotNull(opts, "anchorXUnits", iconStyle.anchorXUnits);
        setIfNotNull(opts, "anchorYUnits", iconStyle.anchorYUnits);
        setIfNotNull(opts, "crossOrigin", iconStyle.crossOrigin);
        setIfNotNull(opts, "offset", toJsArray(iconStyle.offset));
        setIfNotNull(opts, "offsetOrigin", iconStyle.offsetOrigin);
        setIfNotNull(opts, "rotateWithView", iconStyle.rotateWithView);
        setIfNotNull(opts, "scale", iconStyle.scale);
        setIfNotNull(opts, "size", toSize(iconStyle.size));
        setIfNotNull(opts, "src", iconStyle.src);
        return IconStyle.create(opts);
    }

    private static FillStyle convertFillStyle(OLFillStyle fillStyle) {
        if(fillStyle==null || fillStyle.color==null){
            return null;
        }
        return FillStyle.create(fillStyle.color);
    }

    private static JsArrayNumber toJsArray(double [] numbers){
        JsArrayNumber array=null;
        if(numbers!=null){
            array=JsArrayNumber.createArray().cast();
            for(double d : numbers){
                array.push(d);
            }
        }
        return array;
    }

    private static Size toSize(double [] size){
        if(size!=null && size.length==2){
            return Size.create(size[0],size[1]);
        }
        return null;
    }

    private static final void setIfNotNull(JavaScriptObject options, String property, Number value){
        if(value!=null){
            setDouble(options, property, value.doubleValue());
        }
    }

    private static final void setIfNotNull(JavaScriptObject options, String property, Boolean value){
        if(value!=null){
            setBoolean(options, property, value.booleanValue());
        }
    }

    private static final native void setIfNotNull(JavaScriptObject options, String property, String value)/*-{
        if(value!=null){
            options[property]=value;
        }
    }-*/;

    private static final native void setIfNotNull(JavaScriptObject options, String property, JavaScriptObject value)/*-{
        if(value!=null){
            options[property]=value;
        }
    }-*/;

    private static final native void setDouble(JavaScriptObject options, String property, double value)/*-{
        options[property]=value;
    }-*/;

    private static final native void setBoolean(JavaScriptObject options, String property, boolean value)/*-{
        options[property]=value;
    }-*/;


}

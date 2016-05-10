package org.vaadin.addon.vol3.client;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class OLObjectPropertiesConverter {
    public static JavaScriptObject convert(Map<String, String> olprop) {
        JavaScriptObject properties = JavaScriptObject.createObject();
        for (Map.Entry<String, String> entry : olprop.entrySet()) {
            set(properties, entry.getKey(), entry.getValue());
        }
        return properties;
    }
    private static final native void set(JavaScriptObject options, String property, String value)/*-{
        options[property]=value;
    }-*/;
    
    private static final native void set(JavaScriptObject options, String property, JavaScriptObject value)/*-{
        options[property]=value;
    }-*/;
}

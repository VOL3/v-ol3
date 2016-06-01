package org.vaadin.addon.vol3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Feature implementation for the vector layer. Used for adding custom markup on the vector layer.
 */
@SuppressWarnings("serial")
public abstract class OLObject implements Serializable {

    private Map<String, String> properties = new HashMap<String, String>(); // TODO object

    public void set(String key, String value) {
        properties.put(key, value);
    }

    public Object get(String key) {
        return properties.get(key);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "OLObject{" +
                properties.toString() +
                '}';
    }
}

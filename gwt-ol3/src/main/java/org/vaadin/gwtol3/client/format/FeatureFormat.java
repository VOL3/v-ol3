package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for feature formats. Subclasses provide the ability to decode and encode Feature objects from a variety of commonly used geospatial file formats. See the documentation for each format for more details.
 */
public abstract class FeatureFormat extends JavaScriptObject{
    protected FeatureFormat() {
    }
}

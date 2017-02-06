package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Base class for sources providing a single image.
 */
public abstract class ImageStaticSource extends Source {
    protected ImageStaticSource() {
    }

    public static final native ImageStaticSource create(ImageStaticSourceOptions options) /*-{
        return new $wnd.ol.source.ImageStatic(options);
    }-*/;

    public static final native ImageStaticSource create() /*-{
        return new $wnd.ol.source.ImageStatic();
    }-*/;

}

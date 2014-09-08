package org.vaadin.gwtol3.client.source;

/**
 *
 * Layer source for tile data with URLs in a set XYZ format.
 */
public class XYZSource extends TileImageSource {
    protected XYZSource() {
    }

    /** Sets the URL template used by the source. Must include {x}, {y} or {-y}, and {z} placeholders.
     *
     * @param url
     */
    public final native void setUrl(String url)/*-{
        return this.setUrl(url);
    }-*/;

    //TODO: implement rest of the wrapper methods and add static factory method to create an instance. Implementing the wrapper would allow defining arbitrary tile image sources.
}

package org.vaadin.gwtol3.client.source;

/**
 * Base class for vector sources
 * Created by mjhosio on 02/07/14.
 */
public class VectorSource extends AbstractVectorSource{
    protected VectorSource() {
    }

    public static final native VectorSource create()/*-{
        return new $wnd.ol.source.Vector();
    }-*/;

    public static final native VectorSource create(VectorSourceOptions options)/*-{
        return new $wnd.ol.source.Vector(options);
    }-*/;
}

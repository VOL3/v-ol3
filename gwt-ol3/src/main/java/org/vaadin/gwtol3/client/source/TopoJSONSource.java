package org.vaadin.gwtol3.client.source;

/**
 * Created by mjhosio on 07/07/14.
 */
public class TopoJSONSource extends StaticVectorSource{
    protected TopoJSONSource() {
    }

    public static final native TopoJSONSource create() /*-{
        return new $wnd.ol.source.TopoJSON();
    }-*/;

    public static final native TopoJSONSource create(TopoJSONSourceOptions options) /*-{
        return new $wnd.ol.source.TopoJSON(options);
    }-*/;
}

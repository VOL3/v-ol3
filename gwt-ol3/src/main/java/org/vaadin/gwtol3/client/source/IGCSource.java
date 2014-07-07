package org.vaadin.gwtol3.client.source;

/**
 * Vector source for IGC format
 * Created by mjhosio on 07/07/14.
 */
public class IGCSource extends StaticVectorSource{
    protected IGCSource() {
    }

    public static final native IGCSource create() /*-{
        return new $wnd.ol.source.IGC();
    }-*/;

    public static final native IGCSource create(IGCSourceOptions options) /*-{
        return new $wnd.ol.source.IGC(options);
    }-*/;
}

package org.vaadin.gwtol3.client.source;

/**
 * Vector source for IGC format
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

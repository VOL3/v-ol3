package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class IGCFormat extends FeatureFormat{
    protected IGCFormat() {
    }

    public static final native IGCFormat create()/*-{
        return new $wnd.ol.format.IGC();
    }-*/;

    public static final native IGCFormat create(String altitudeMode)/*-{
        return new $wnd.ol.format.IGC({altitudeMode: altitudeMode});
    }-*/;
}

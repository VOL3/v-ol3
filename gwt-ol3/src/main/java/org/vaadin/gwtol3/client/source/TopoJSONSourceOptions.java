package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 07/07/14.
 */
public class TopoJSONSourceOptions extends AbstractVectorSourceOptions{
    protected TopoJSONSourceOptions() {
    }

    public static native final TopoJSONSourceOptions create()/*-{
        return {};
    }-*/;

    public native final void setUrl(String url)/*-{
        this.url = url;
    }-*/;

    public final native void setText(String text)/*-{
        this.text=text;
    }-*/;

    public final native void setObject(JavaScriptObject object)/*-{
        this.object=object;
    }-*/;

    public final native void setDefaultProjection(String defaultProjection)/*-{
        this.defaultProjection=defaultProjection;
    }-*/;
}

package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Node;

/**
 * Options for the GPXSource
 */
public class GPXSourceOptions extends AbstractVectorSourceOptions{
    protected GPXSourceOptions() {
    }

    public static final native GPXSourceOptions create() /*-{
        return {};
    }-*/;

    public native final void setUrl(String url)/*-{
        this.url = url;
    }-*/;

    public native final void setUrls(JsArrayString urls)/*-{
        this.urls = urls;
    }-*/;

    public final native void setText(String text)/*-{
        this.text=text;
    }-*/;

    public final native void setDoc(Document document)/*-{
        this.doc=doc;
    }-*/;

    public final native void setNode(Node node)/*-{
        this.node=node;
    }-*/;


}

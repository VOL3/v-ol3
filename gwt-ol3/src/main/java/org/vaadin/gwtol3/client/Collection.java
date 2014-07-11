package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 25/06/14.
 */
public class Collection extends JavaScriptObject{

    protected Collection(){}

    public static native Collection create() /*-{
        return new $wnd.ol.Collection();
    }-*/;

    public native final void clear() /*-{
        this.clear();
    }-*/;

    public native final void setAt(int index, JavaScriptObject element) /*-{
        this.setAt(index, element);
    }-*/;

    public native final void removeAt(int index) /*-{
        this.removeAt(index);
    }-*/;

    public native final void remove(JavaScriptObject element) /*-{
        this.remove(element);
    }-*/;

    public native final void push(JavaScriptObject element) /*-{
        this.push(element);
    }-*/;

    public native final JavaScriptObject pop() /*-{
        return this.pop();
    }-*/;

    public native final JavaScriptObject item(int index) /*-{
        return this.item(index);
    }-*/;

    public native final void insertAt(int index, JavaScriptObject elem) /*-{
        this.insertAt(index, elem);
    }-*/;

    public native final int getLength() /*-{
        return this.getLength();
    }-*/;

}

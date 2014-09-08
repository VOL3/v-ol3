package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Wrapper for the ol3 collection
 */
public class Collection<T extends JavaScriptObject> extends JavaScriptObject{

    protected Collection(){}

    public static native Collection create() /*-{
        return new $wnd.ol.Collection();
    }-*/;

    public static native Collection create(JsArray array) /*-{
        var coll=new $wnd.ol.Collection();
        return coll.extend(array);
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

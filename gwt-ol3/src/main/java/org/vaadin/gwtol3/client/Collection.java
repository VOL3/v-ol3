package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.collection.OnCollectionAddListener;
import org.vaadin.gwtol3.client.collection.OnCollectionRemoveListener;

/**
 * Wrapper for the ol3 collection
 * Example usage add listener
 * _mapWidget.getMap().getLayers().addOnCollectionAddListener(new OnCollectionAddListener() {
 *     \@Override
 *     public void onCollectionAdd(JavaScriptObject element) {
 *         Layer ol3Layer = (Layer)element.cast();
 *         if (ol3Layer != null) {
 *             // Do something
 *             _logger.info(ol3Layer.get("name") + " added");
 *
 *         }
 *     }
 * });
 * @param <T>
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

    public native final T item(int index) /*-{
        return this.item(index);
    }-*/;

    public native final void insertAt(int index, JavaScriptObject elem) /*-{
        this.insertAt(index, elem);
    }-*/;

    public native final int getLength() /*-{
        return this.getLength();
    }-*/;
    
    public native final void addOnCollectionAddListener(OnCollectionAddListener onCollectionAddListener) /*-{
        if (!this.__onCollectionAddRegistered) {
            var that = this;
            var addCallback = function(event) {
                that.__notifyCollectionAddListeners(event.element);
            };
            this.on("add", $entry(addCallback), this);
            
            this.__onCollectionAddRegistered=true;
            this.__addListeners=[];
            this.__notifyCollectionAddListeners = function(addEvent) {
                var length=this.__addListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__addListeners[i];
                    listener.@org.vaadin.gwtol3.client.collection.OnCollectionAddListener::onCollectionAdd(Lcom/google/gwt/core/client/JavaScriptObject;)(addEvent);
                }
            };
        }
        this.__addListeners.push(onCollectionAddListener);
    }-*/;
    
    public native final void removeOnCollectionAddListener(OnCollectionAddListener onCollectionAddListener) /*-{
        var index = this.__addListeners.indexOf(onCollectionAddListener);
        if (index > -1) {
            this.__addListeners.splice(index, 1);
        }
    }-*/;
    
    public native final void addOnCollectionRemoveListener(OnCollectionRemoveListener onCollectionRemoveListener) /*-{
        if (!this.__onCollectionRemoveRegistered) {
            var that = this;
            var removeCallback = function(event) {
                that.__notifyCollectionRemoveListeners(event.element);
            };
            this.on("remove", $entry(removeCallback), this);
            
            this.__onCollectionRemoveRegistered=true;
            this.__removeListeners=[];
            this.__notifyCollectionRemoveListeners = function(removeEvent) {
                var length=this.__removeListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__removeListeners[i];
                    listener.@org.vaadin.gwtol3.client.collection.OnCollectionRemoveListener::onCollectionRemove(Lcom/google/gwt/core/client/JavaScriptObject;)(removeEvent);
                }
            };
        }
        this.__removeListeners.push(onCollectionRemoveListener);
    }-*/;
    
    public native final void removeOnCollectionRemoveListener(OnCollectionRemoveListener onCollectionRemoveListener) /*-{
        var index = this.__removeListeners.indexOf(onCollectionRemoveListener);
        if (index > -1) {
            this.__removeListeners.splice(index, 1);
        }
    }-*/;
}

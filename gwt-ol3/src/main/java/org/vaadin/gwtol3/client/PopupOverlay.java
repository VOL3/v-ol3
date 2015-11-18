/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client;

/**
 *
 * @author iserge
 * 
 * Example Usage:
 * OverlayOptions overlayOptions = OverlayOptions.create();
 * PopupOverlay popupOverlay = PopupOverlay.create(overlayOptions);
 * _ol3Map.addOverlay(popupOverlay);
 * // Set context and set position worked only after add overlay to map !!!
 * popupOverlay.setContext(text);
 * popupOverlay.setPosition(center);
 * 
 * Example css places in gwt-ol3/src/main/resources/org/vaadin/gwtol3/client/resources/popup.css
 */
public class PopupOverlay extends Overlay {
    protected PopupOverlay() {
        //
    }
    
    public static final native PopupOverlay create(OverlayOptions options) /*-{
        var d = new Date().getTime();
        var id = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
            var r = (d + Math.random()*16)%16 | 0;
            d = Math.floor(d/16);
            return (c=='x' ? r : (r&0x3|0x8)).toString(16);
        });
        
        var div = $wnd.document.createElement('div');
        div.id = 'popup_' + id;
        div.className = 'ol-popup';

        var closer = $wnd.document.createElement('a');
        closer.href = '#';
        closer.id = 'popup-closer';
        closer.className='ol-popup-closer';
        div.appendChild(closer);

        var content = $wnd.document.createElement('div');
        content.id = 'popup-content';
        content.className='ol-popup-content';
        div.appendChild(content);

        $wnd.document.body.appendChild(div);

        var overlay = new $wnd.ol.Overlay(options);
        overlay.set('id', id);
        overlay.setElement(div);
        return overlay;
    }-*/;
    
    public final native String getId() /*-{
        return this.get('id');
    }-*/;
    
    public final native void setContent(String content) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        var _content = popup.getElementsByClassName('ol-popup-content')[0];
        _content.innerHTML = content;
    }-*/;
    
    public final native void setOpacity(Float opacity) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.opacity = opacity;
    }-*/;
    
    public final native void setSize(int width, int height) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.width  = width + 'px';
        popup.style.height = height + 'px';
            
        var content = popup.getElementsByClassName('ol-popup-content')[0];
        content.style.width  = width + 'px';
        content.style.height = height + 'px';
    }-*/;
    
    public final native void setMinSize(int minWidth, int minHeight) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.minWidth  = minWidth + 'px';
        popup.style.minHeight = minHeight + 'px';
    }-*/;
    
    public final native void setWidth(int width) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.width  = width + 'px';
            
        var content = popup.getElementsByClassName('ol-popup-content')[0];
        content.style.width  = width + 'px';
    }-*/;
    
    public final native void setHeight(int height) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.height = height + 'px';
            
        var content = popup.getElementsByClassName('ol-popup-content')[0];
        content.style.height = height + 'px';
    }-*/;
    
    public final native void setMinWidth(int minWidth) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.minWidth = minWidth + 'px';
    }-*/;
    
    public final native void setMinHeight(int minHeight) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.minHeight = minHeight + 'px';
    }-*/;
    
    public final native void show() /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.display = '';
    }-*/;
    
    public final native void hide() /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        popup.style.display = 'none';
    }-*/;
    
    public final native void addOnPopupOverlayCloserListener(OnPopupOverlayCloserListener onPopupOverlayCloserListener) /*-{
        var popup = $wnd.document.getElementById('popup_' + this.get('id'));
        var closer = popup.getElementsByClassName('ol-popup-closer')[0];
        var that = this;
        closer.onclick = function() {
            onPopupOverlayCloserListener.@org.vaadin.gwtol3.client.OnPopupOverlayCloserListener::onPopupOverlayCloser(Lorg/vaadin/gwtol3/client/PopupOverlay;)(that);
        };
    }-*/;
}

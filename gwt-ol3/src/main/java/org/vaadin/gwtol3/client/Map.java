package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import org.vaadin.gwtol3.client.layer.Base;

/**
 * Created by mjhosio on 24/06/14.
 */
public class Map extends JavaScriptObject{

    protected Map(){

    }

    /** Initializes Open Layer v3 map to the given element
     *
     * @param root the element root for the map
     * @return the OL3 map instance
     */
    public static native Map create(Element root)
    /*-{
        return new $wnd.ol.Map({target: root});
    }-*/;

    public native final void addControl()/*-{

    }-*/;

    public native final void addInteraction()/*-{

    }-*/;

    public native final void addLayer(Base layer)/*-{
        this.addLayer(layer);
    }-*/;

    public native final void addOverlay()/*-{

    }-*/;

    public native final void beforeRender()/*-{
        //TODO: find a nice way to do this in GWT
    }-*/;

    public native final void forEachFeatureAtPixel()/*-{
        //TODO: find a nice way to do this in GWT
    }-*/;

    public native final void getControls()/*-{

    }-*/;

    public native final void getCoordinateFromPixel()/*-{

    }-*/;

    public native final void getEventCoordinate()/*-{

    }-*/;

    public native final void getEventPixel()/*-{

    }-*/;

    public native final void getInteractions()/*-{

    }-*/;

    public native final void getLayerGroup()/*-{

    }-*/;

    public native final void getLayers()/*-{

    }-*/;

    public native final void getOverlays()/*-{

    }-*/;

    public native final void getPixelFromCoordinate()/*-{

    }-*/;

    public native final void getSize()/*-{

    }-*/;

    public native final void getTarget()/*-{

    }-*/;

    public native final View getView()/*-{
        return this.getView();
    }-*/;

    public native final void getViewPort()/*-{

    }-*/;

    public native final void removeControl()/*-{

    }-*/;

    public native final void removeInteraction()/*-{

    }-*/;

    public native final void removeLayer()/*-{

    }-*/;

    public native final void removeOverlay()/*-{

    }-*/;

    public native final void render()/*-{

    }-*/;

    public native final void renderSync()/*-{

    }-*/;

    public native final void setLayerGroup()/*-{

    }-*/;

    public native final void setSize()/*-{

    }-*/;

    public native final void setTarget()/*-{

    }-*/;

    public native final void setView(View view)/*-{
        this.setView(view);
    }-*/;

    /**Force a recalculation of the map viewport size. This should be called when third-party code changes the size of the map viewport.
     *
     */
    public native final void updateSize()/*-{
        this.updateSize();
    }-*/;


}

package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.view.StatusChangeListener;
import org.vaadin.gwtol3.client.geom.SimpleGeometry;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * View of the map
 */
public class View extends JavaScriptObject {

    protected View(){

    }

    public static final native View create()/*-{
		var view = $wnd.ol.View({});
        return view;
    }-*/;

    public static final native View create(ViewOptions options)/*-{
        // we may need to transform the extent before passing it to the view
        if(typeof options.__inputProjection !== 'undefined' && typeof options.extent !== 'undefined'){
            var projection = options.projection ? options.projection : "EPSG:3857";
            if(projection !== options.__inputProjection){
                options.extent=$wnd.ol.proj.transformExtent(options.extent, options.__inputProjection, projection);
            }
        }

        if (typeof options.__restrictedExtent !== 'undefined') {
            var maxVaadinExtent = options.__restrictedExtent;
            options.constrainCenter = function (center, resolution) {
                if (center !== undefined && resolution !== undefined) {
                    var mapSize = (map.getSize()); // @type {ol.Size}
                    var viewResolution = resolution;
                    var mapHalfWidth = (mapSize[0] * viewResolution) / 2.0;
                    var mapHalfHeight = (mapSize[1] * viewResolution) / 2.0;
                    var maxExtent = this.__restrictedExtent;
                    if (maxExtent === undefined && maxVaadinExtent !== undefined) {
                        maxExtent = maxVaadinExtent;
                    }
                    if (center[0] - mapHalfWidth < maxExtent[0]) {
                        center[0] = maxExtent[0] + mapHalfWidth;
                    } else if (center[0] + mapHalfWidth > maxExtent[2]) {
                        center[0] = maxExtent[2] - mapHalfWidth;
                    }
                    if (center[1] - mapHalfHeight < maxExtent[1]) {
                        center[1] = maxExtent[1] + mapHalfHeight;
                    } else if (center[1] + mapHalfHeight > maxExtent[3]) {
                        center[1] = maxExtent[3] - mapHalfHeight;
                    }
                }
                return center;
            }
        }
        var view = new $wnd.ol.View(options);
        if(typeof options.__inputProjection !== 'undefined'){
            view.__inputProjection=options.__inputProjection;
        }
        if(typeof options.extent !== 'undefined'){
            view.extent=options.extent;
        }
        if(typeof options.__restrictedExtent !== 'undefined'){
            view.__restrictedExtent=options.__restrictedExtent;
        }
        // add projection helpers
        view.__transformInputCoordinate = function(coordinate){
            return typeof this.__inputProjection !== 'undefined' ? $wnd.ol.proj.transform(coordinate, this.__inputProjection, this.getProjection()) : coordinate;
        };

        view.__transformOutputCoordinate = function(coordinate){
            return typeof this.__inputProjection !== 'undefined' ? $wnd.ol.proj.transform(coordinate, this.getProjection(), this.__inputProjection) : coordinate;
        };

        view.__transformInputExtent = function(extent){
            return typeof this.__inputProjection !== 'undefined' ? $wnd.ol.proj.transformExtent(extent, this.__inputProjection, this.getProjection()) : extent;
        };

        view.__transformOutputExtent = function(extent){
            return typeof this.__inputProjection !== 'undefined' ? $wnd.ol.proj.transformExtent(extent, this.getProjection(), this.__inputProjection) : extent;
        };
		return view;
    }-*/;

    public native final Extent calculateExtent(Size size)/*-{
        try{
            return this.__transformOutputExtent(this.calculateExtent(size));
        } catch (e){

        }
    }-*/;

    /**
     * Center on coordinate and view position. Take care on the map angle.
     *
     * @param coordinate coordinate
     * @param size box pixel size
     * @param pixel Position on the view to center on
     */
    public native final void centerOn(Coordinate coordinate, Size size, Pixel pixel)/*-{
        this.centerOn(this.__transformInputCoordinate(coordinate), size, pixel);
    }-*/;

/*
    /** Gets the constrained center of this view
     *
     * @param coordinate
    public native final Coordinate constrainCenter(Coordinate coordinate)*//*-{
        return this.constrainCenter(coordinate, this.getResolution());
    }-*//*;
*/
    /** Gets the constrained center of this view
     *
     * @param coordinate
     * @param resolution
     */
    public native final Coordinate constrainCenter(Coordinate coordinate, double resolution)/*-{
        return this.constrainCenter(this.__transformInputCoordinate(coordinate), resolution);
    }-*/;

    /** Get the constrained resolution of this view.
     *
     * @param resolution
     * @param delta
     * @param direction
     * @return
     */
    public native final Double constrainResolution(double resolution, double delta, double direction)/*-{
		var res = this.constrainResolution(resolution, delta, direction);
        return res==null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    /**
     * Get the constrained rotation of this view.
     * @param rotation
     * @param delta
     * @return
     */
    public native final Double constrainRotation(double rotation, double delta)/*-{
        var res = this.constrainRotation(rotation, delta);
        return res==null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;


    public native final void fitExtent(Extent extent, Size size)/*-{
        this.fit(this.__transformInputExtent(extent), size);
    }-*/;

    /**
     * Fit the given geometry based on the given map size and border. Take care on the map angle.
     *
     * @param geometry
     * @param size
     */
    public native final void fitGeometry(SimpleGeometry geometry, Size size)/*-{
        this.fitGeometry(geometry, size);
    }-*/;

    /** Gets the center of the view
     *
     * @return
     */
    public native final Coordinate getCenter()/*-{
        return this.__transformOutputCoordinate(this.getCenter());
    }-*/;

    /** Gets the projection of the view
     *
     * @return
     */
    public native final Projection getProjection()/*-{
        return this.getProjection();
    }-*/;

    /** Gets the resolution of the view
     *
     * @return
     */
    public native final Double getResolution()/*-{
		res=this.getResolution();
        return res==null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    /**
     * Get the resolution for a provided extent (in map units) and size (in pixels).
     *
     * @param extent
     * @param size
     * @return The resolution at which the provided extent will render at the given size
     */
    public native final Double getResolutionForExtent(Extent extent, Size size)/*-{
        var res = this.getResolutionForExtent(this.__transformInputExtent(extent), size);
        return res==null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    /** Gets the rotation of the view
     *
     * @return
     */
    public native final Double getRotation()/*-{
        var res = this.getRotation();
		if(res==null){
			res=0;
		}
        return @java.lang.Double::valueOf(D)(res);
    }-*/;

    /** Gets the zoom of the view
     *
     * @return
     */
    public native final Double getZoom()/*-{
		var res=this.getZoom();
        return res==null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    /** Rotate the view around a given coordinate.
     *
     * @param rotation
     * @param anchor
     */
    public native final void rotate(double rotation, Coordinate anchor)/*-{
        this.rotate(rotation, this.__transformInputCoordinate(anchor));
    }-*/;

    /** Set the center of the current view.
     *
     * @param coordinate
     */
    public native final void setCenter(Coordinate coordinate)/*-{
        this.setCenter(this.__transformInputCoordinate(coordinate));
    }-*/;

    /** Set the projection of this view. Currently not implemented by the library
     *
     * @param projection
     */
//    public native final void setProjection(Projection projection)/*-{
//        this.setProjection(projection);
//    }-*/;

    /** Set the resolution of this view.
     *
     * @param resolution
     */
    public native final void setResolution(double resolution)/*-{
        this.setResolution(resolution);
    }-*/;

    /** Set the rotation for view.
     *
     * @param rotation
     */
    public native final void setRotation(double rotation)/*-{
        this.setRotation(rotation);
    }-*/;

    /**
     * Zoom to a specific zoom level
     *
     * @param zoom
     */
    public native final void setZoom(double zoom)/*-{
        this.setZoom(zoom);
    }-*/;

	/** Adds status change listener to the view
	 *
	 * @param listener the listener to be added
	 * @return listener key that can be used to remove the listener
	 */

	public native final JavaScriptObject addStatusChangeListener(StatusChangeListener listener)/*-{
		if(typeof this.statusChangeListeners == 'undefined'){
            this.statusChangeListeners=[];
			var self=this;
            var fireCenterChanged=function(){
                var listenerCount=self.statusChangeListeners.length;
                for(var i=0;i<listenerCount;i++){
                    self.statusChangeListeners[i].centerChanged();
                }
            };
            var fireResolutionChanged=function(){
                var listenerCount=self.statusChangeListeners.length;
                for(var i=0;i<listenerCount;i++){
                    self.statusChangeListeners[i].resolutionChanged();
                }
            };
            var fireRotationChanged=function(){
                var listenerCount=self.statusChangeListeners.length;
                for(var i=0;i<listenerCount;i++){
                    self.statusChangeListeners[i].rotationChanged();
                }
            };
            this.on("change:center", fireCenterChanged, this);
            this.on("change:resolution", fireResolutionChanged, this);
			this.on("change:rotation", fireRotationChanged, this);
		}
        var changeListener = {
			 centerChanged: $entry(function(){
                 listener.@org.vaadin.gwtol3.client.view.StatusChangeListener::centerChanged()();
                 }),
			 resolutionChanged: $entry(function(){
                 listener.@org.vaadin.gwtol3.client.view.StatusChangeListener::resolutionChanged()();
             }),
             rotationChanged: $entry(function(){
                 listener.@org.vaadin.gwtol3.client.view.StatusChangeListener::rotationChanged()();
             })
		 };
		 this.statusChangeListeners.push(changeListener);
	}-*/;

	public native final void removeStatusChangeListener(JavaScriptObject listenerKey)/*-{
        var listenerCount=this.statusChangeListeners.length;
        for(var i=0;i<listenerCount;i++){
            if(this.statusChangeListeners[i]==listenerKey){
                this.statusChangeListeners[i].splice(i,1);
                return;
            }
        }
    }-*/;

}

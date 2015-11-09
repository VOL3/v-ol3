package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponent;
import org.vaadin.addon.vol3.client.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The view associated with a map. The view provides api for controlling things like zoom (resolution), rotation and extent
 */
public class OLView extends AbstractComponent {

	private OLCoordinate center;
	private Double rotation=0d;
	private Double resolution;
	private Integer zoom;
    private OLExtent extent;
    private List<ViewChangeListener> listeners=new ArrayList<ViewChangeListener>();

    /** Creates a new instance of the view
     *
     */
    public OLView(){
        this(null);
    }

    /** Creates a new instance of the view with provided options
     *
     * @param options view options
     */
    public OLView(OLViewOptions options){
        if(options!=null){
            setOptions(options);
        }
		registerRpc();
		center=new OLCoordinate(0,0);
    }

    /** Zoom to a specific zoom level.
     *
     * @param zoom
     */
    public void setZoom(int zoom){
        this.zoom=zoom;
		getRpcProxy(OLViewClientRpc.class).setZoom(zoom);
    }

    /** Set the center of the current view.
     *
     * @param center
     */
    public void setCenter(OLCoordinate center){
		this.center=center;
        getRpcProxy(OLViewClientRpc.class).setCenter(center);
    }

    public void setCenter(double xCoord, double yCoord){
        setCenter(new OLCoordinate(xCoord, yCoord));
    }

    public void fitExtent(OLExtent extent){
       	getRpcProxy(OLViewClientRpc.class).fitExtent(extent);
    }

    /** Set the rotation for this view.
     *
     * @param rotation
     */
    public void setRotation(double rotation){
		this.rotation=rotation;
        getRpcProxy(OLViewClientRpc.class).setRotation(rotation);
    }

    /** Set the resolution for this view.
     *
     * @param resolution
     */
    public void setResolution(double resolution){
        this.resolution=resolution;
		getRpcProxy(OLViewClientRpc.class).setResolution(resolution);
    }

	/** Gets the last known center position of the view
	 *
	 * @return
	 */
	public OLCoordinate getCenter() {
		return center;
	}

	/** Gets the last known rotation of the view
	 *
	 * @return
	 */
	public Double getRotation() {
		return this.rotation;
	}

	/** Gets the last known resolution of the view
	 *
	 * @return
	 */
	public Double getResolution() {
		return resolution;
	}

	/** Gets the last known zoom level of the view
	 *
	 * @return
	 */
	public Integer getZoom() {
		return zoom;
	}

    /** Gets the last known viewport extent of the view
     *
      * @return the last known viewport extent of the view
     */
    public OLExtent getViewportExtent(){
        return this.extent;
    }

	@Override
    protected OLViewState getState() {
        return (OLViewState) super.getState();
    }

    @Override
    protected OLViewState getState(boolean markAsDirty) {
        return (OLViewState) super.getState(markAsDirty);
    }

    public OLRotationConstraint getRotationConstraint() {
        return getState(false).rotationConstraint;
    }

    public Boolean getEnableRotation() {
        return getState(false).enableRotation;
    }

    public OLExtent getExtent() {
        return getState(false).extent;
    }

    public Double getMaxResolution() {
        return getState(false).maxResolution;
    }

    public Double getMinResolution() {
        return getState(false).minResolution;
    }

    public Integer getMaxZoom() {
        return getState(false).maxZoom;
    }

    public Integer getMinZoom() {
        return getState(false).minZoom;
    }

    public Double getZoomFactor() {
        return getState(false).zoomFactor;
    }

    public String getMapProjection() {
        return getState(false).mapProjection;
    }

    public String getInputProjection() {
        return getState(false).inputProjection;
    }

    public void addViewChangeListener(ViewChangeListener listener){
        this.listeners.add(listener);
    }

    public void removeViewChangeListener(ViewChangeListener listener){
        this.listeners.remove(listener);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        // make sure that we sent the stored values to client when ever we have initial state change
        // this way we remember the state over visibility changes
        if(initial){
            if(this.resolution!=null){
                this.setResolution(this.resolution);
            }
            if(this.center!=null){
                this.setCenter(this.center);
            }
            if(this.rotation!=null){
                this.setRotation(this.rotation);
            }
            if(this.zoom!=null){
                this.setZoom(this.zoom);
            }
        }
    }



    private void setOptions(OLViewOptions options) {
        getState().enableRotation=options.getEnableRotation();
        getState().rotationConstraint=options.getRotationConstraint();
        getState().extent=options.getExtent();
        getState().minResolution=options.getMinResolution();
        getState().maxResolution=options.getMaxResolution();
        getState().minZoom=options.getMinZoom();
        getState().maxZoom=options.getMaxZoom();
        getState().zoomFactor=options.getZoomFactor();
        getState().mapProjection=options.getMapProjection();
        getState().inputProjection=options.getInputProjection();
        getState().resolutions=options.getResolutions();
    }

	private void registerRpc(){
		registerRpc(new OLViewServerRpcImpl(), OLViewServerRpc.class);
	}

	private class OLViewServerRpcImpl implements OLViewServerRpc{

		@Override
		public void updateCenter(OLCoordinate coordinate) {
			OLView.this.center=coordinate;
            fireCenterChanged();
		}

		@Override
		public void updateRotation(Double rotation) {
			OLView.this.rotation=rotation;
            fireRotationChanged();
		}

		@Override
		public void updateResolution(Double resolution) {
			OLView.this.resolution=resolution;
            fireResolutionChanged();
		}

		@Override
		public void updateZoom(Double zoom) {
			OLView.this.zoom = zoom==null ? null : Integer.valueOf((int)zoom.doubleValue());
            fireZoomChanged();
		}

        @Override
        public void flush() {
            // NO-OP
        }

        @Override
        public void updateExtent(double minX, double minY, double maxX, double maxY) {
            extent = new OLExtent(new OLCoordinate(minX, minY), new OLCoordinate(maxX, maxY));
            fireExtentChanged();
        }
    }

    private void fireResolutionChanged(){
        for(ViewChangeListener listener : listeners){
            listener.resolutionChanged(this.resolution);
        }
    }

    private void fireRotationChanged(){
        for(ViewChangeListener listener : listeners){
            listener.rotationChanged(this.rotation);
        }
    }

    private void fireCenterChanged(){
        for(ViewChangeListener listener : listeners){
            listener.centerChanged(this.center);
        }
    }

    private void fireZoomChanged(){
        for(ViewChangeListener listener : listeners){
            listener.zoomChanged(this.zoom);
        }
    }

    private void fireExtentChanged(){
        for(ViewChangeListener listener : listeners){
            listener.extentChanged(this.extent);
        }
    }

    public interface ViewChangeListener {
        public void resolutionChanged(Double newResolution);
        public void rotationChanged(Double rotation);
        public void centerChanged(OLCoordinate centerPoint);
        public void zoomChanged(Integer zoom);
        public void extentChanged(OLExtent extent);
    }
}

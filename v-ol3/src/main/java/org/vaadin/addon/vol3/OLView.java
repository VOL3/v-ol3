package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponent;
import org.vaadin.addon.vol3.client.*;

/**
 * The view associated with a map. The view provides api for controlling things like zoom (resolution), rotation and extent
 */
public class OLView extends AbstractComponent {

	private OLCoordinate center;
	private Double rotation=0d;
	private Double resolution;
	private Integer zoom;

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
		center=new OLCoordinate(xCoord, yCoord);
        getRpcProxy(OLViewClientRpc.class).setCenter(center);
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

	/** Gets the last know zoom level of the view
	 *
	 * @return
	 */
	public Integer getZoom() {
		return zoom;
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

    public String getProjection() {
        return getState(false).projection;
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
        getState().projection=options.getProjection();
    }

	private void registerRpc(){
		registerRpc(new OLViewServerRpcImpl(), OLViewServerRpc.class);
	}

	private class OLViewServerRpcImpl implements OLViewServerRpc{

		@Override
		public void updateCenter(OLCoordinate coordinate) {
			OLView.this.center=coordinate;
		}

		@Override
		public void updateRotation(Double rotation) {
			OLView.this.rotation=rotation;
		}

		@Override
		public void updateResolution(Double resolution) {
			OLView.this.resolution=resolution;
		}

		@Override
		public void updateZoom(Double zoom) {
			OLView.this.zoom = zoom==null ? null : Integer.valueOf((int)zoom.doubleValue());
		}


	}
}

package org.vaadin.addon.vol3.client;

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.gwtol3.client.*;
import org.vaadin.gwtol3.client.view.StatusChangeListener;

import java.util.logging.Logger;

/**
 * Client-side connector for the view
 */
@Connect(OLView.class)
public class OLViewConnector extends AbstractComponentConnector{

	private static Logger logger= Logger.getLogger(OLViewConnector.class.getName());

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();
    private View view;
    private Map map;

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    public View getView() {
        if(view==null){
            view = createView();
        }
        return view;
    }

    @Override
    protected void init() {
        super.init();
        registerRpc(OLViewClientRpc.class, new OLViewClientRpcImpl());
    }

    @Override
    public OLViewState getState() {
        return (OLViewState) super.getState();
    }

// the setProjection method is not implemented in the js-api
//    @OnStateChange("projection")
//    void updateProjection(){
//        if(getState().projection!=null){
//            getView().setProjection(Projection.get(getState().projection));
//        }
//    }

    private View createView(){
        ViewOptions options=ViewOptions.create();
        if(getState().rotationConstraint!=null){
            if(getState().rotationConstraint.constrainTo!=null){
                options.setConstrainRotation(getState().rotationConstraint.constrainTo);
            } else{
                options.setConstrainRotation(getState().rotationConstraint.constrained);
            }
        }
        if(getState().enableRotation!=null){
            options.setEnableRotation(getState().enableRotation);
        }
        if(getState().extent!=null){
            OLExtent ext=getState().extent;
            Extent extent=Extent.create(ext.minX,ext.minY, ext.maxX, ext.maxY);
            options.setExtent(extent);
        }
        if(getState().maxResolution!=null){
            options.setMaxResolution(getState().maxResolution);
        }
        if(getState().minResolution!=null){
            options.setMinResolution(getState().minResolution);
        }
        if(getState().minZoom!=null){
            options.setMinZoom(getState().minZoom);
        }
        if(getState().maxZoom!=null){
            options.setMaxZoom(getState().maxZoom);
        }
        if(getState().zoomFactor!=null){
            options.setZoomFactor(getState().zoomFactor);
        }
        if(getState().mapProjection!=null){
            options.setProjection(getState().mapProjection);
        }
        if(getState().inputProjection!=null){
            options.setInputProjection(getState().inputProjection);
        }
        if(getState().resolutions!=null){
            JsArrayNumber jsResolutions=JsArrayNumber.createArray().cast();
            for(double res : getState().resolutions){
                jsResolutions.push(res);
                options.setResolutions(jsResolutions);
            }
        }
        View view=View.create(options);
		view.addStatusChangeListener(new StatusChangeListener() {
			@Override
			public void centerChanged() {
				Coordinate c=getView().getCenter();
				OLCoordinate olCoordinate=new OLCoordinate(c.getX(), c.getY());
				getRpcProxy(OLViewServerRpc.class).updateCenter(olCoordinate);
                updateExtent();
                resetSendTimer();
			}

			@Override
			public void resolutionChanged() {
				getRpcProxy(OLViewServerRpc.class).updateResolution(getView().getResolution());
				getRpcProxy(OLViewServerRpc.class).updateZoom(getView().getZoom());
                updateExtent();
                resetSendTimer();
			}

			@Override
			public void rotationChanged() {
				getRpcProxy(OLViewServerRpc.class).updateRotation(getView().getRotation());
                updateExtent();
                resetSendTimer();
            }
		});
        return view;
    }

    private void updateExtent() {
        if(getMap().getSize()!=null){
            Extent extent = getView().calculateExtent(getMap().getSize());
            if(extent!=null){
                getRpcProxy(OLViewServerRpc.class).updateExtent(extent.getMinX(), extent.getMinY(), extent.getMaxX(), extent.getMaxY());
            }
        }
    }

    private Timer sendTimer=new Timer(){
        @Override
        public void run() {
            getRpcProxy(OLViewServerRpc.class).flush();
        }
    };

    private void resetSendTimer(){
        sendTimer.schedule(200);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    private final class OLViewClientRpcImpl implements OLViewClientRpc{

        @Override
        public void setZoom(int zoom) {
            getView().setZoom(zoom);
        }

        @Override
        public void setCenter(OLCoordinate center) {
            getView().setCenter(Coordinate.create(center.x, center.y));
        }

        @Override
        public void setResolution(double resolution) {
            getView().setResolution(resolution);
        }

        @Override
        public void setRotation(double rotation) {
            getView().setRotation(rotation);
        }

		@Override
		public void fitExtent(final OLExtent extent) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                @Override
                public void execute() {
                    getView().fitExtent(Extent.create(extent.minX, extent.minY, extent.maxX, extent.maxY), getMap().getSize());
                }
            });
		}
    }
}

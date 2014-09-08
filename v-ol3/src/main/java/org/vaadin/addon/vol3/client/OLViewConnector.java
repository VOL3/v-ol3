package org.vaadin.addon.vol3.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.View;
import org.vaadin.gwtol3.client.ViewOptions;

/**
 * Client-side connector for the view
 */
@Connect(OLView.class)
public class OLViewConnector extends AbstractComponentConnector{

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();
    private View view;

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
        if(getState().projection!=null){
            options.setProjection(getState().projection);
        }
        View view=View.create(options);
        return view;
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
    }
}

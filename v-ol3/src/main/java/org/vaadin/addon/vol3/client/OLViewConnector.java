package org.vaadin.addon.vol3.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.View;
import org.vaadin.gwtol3.client.ViewOptions;

/**
 * Created by mjhosio on 30/06/14.
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
    public OLViewState getState() {
        return (OLViewState) super.getState();
    }

    @OnStateChange("zoom")
    void updateZoom(){
        if(getState().zoom!=null){
            getView().setZoom(getState().zoom);
        }
    }

    @OnStateChange("center")
    void updateCenter(){
        if(getState().center!=null){
            getView().setCenter(Coordinate.create(getState().center.x, getState().center.y));
        }
    }

    @OnStateChange("resolution")
    void updateResolution(){
        if(getState().resolution!=null){
            getView().setResolution(getState().resolution);
        }
    }

    @OnStateChange("rotation")
    void updateRotation(){
        if(getState().rotation!=null){
            getView().setRotation(getState().rotation);
        }
    }

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
}

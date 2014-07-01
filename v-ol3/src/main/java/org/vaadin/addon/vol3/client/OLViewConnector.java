package org.vaadin.addon.vol3.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.View;
import org.vaadin.gwtol3.client.proj.Projection;

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
            view= View.create();
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

    @OnStateChange("projection")
    void updateProjection(){
        if(getState().projection!=null){
            getView().setProjection(Projection.get(getState().projection));
        }
    }

}

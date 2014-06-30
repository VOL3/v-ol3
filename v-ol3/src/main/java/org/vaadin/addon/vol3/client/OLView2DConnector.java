package org.vaadin.addon.vol3.client;

import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLView2D;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.View2D;

import java.util.logging.Logger;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect(OLView2D.class)
public class OLView2DConnector extends OLViewConnector {

    private View2D view;
    private static final Logger logger= Logger.getLogger(OLView2DConnector.class.getName());

    @Override
    public View2D getView() {
        if(view==null){
            view=View2D.create();
        }
        return view;
    }

    @Override
    public OLView2DState getState() {
        return (OLView2DState) super.getState();
    }

    @OnStateChange("zoom")
    void updateZoom(){
        logger.info("Setting zoom");
        getView().setZoom(getState().zoom);
    }

    @OnStateChange("center")
    void updateCenter(){
        if(getState().center!=null){
            logger.info("Setting center point");
            getView().setCenter(Coordinate.create(getState().center.x, getState().center.y));
        }
    }
}

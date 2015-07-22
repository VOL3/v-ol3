package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.source.OLMapQuestSource;
import org.vaadin.addon.vol3.source.OLSource;

import java.util.logging.Logger;

/**
 * Basic map view
 */
public class BasicMap extends VerticalLayout implements View {

    protected OLMap map;
    private static final Logger logger= Logger.getLogger(BasicMap.class.getName());

    public BasicMap() {
        this.setSizeFull();
        map=createMap();

        this.addViewChangeListener();
        this.addComponent(map);
        this.setExpandRatio(this.iterator().next(),1.0f);
        this.addComponent(createControls());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    protected OLMap createMap(){
        OLMap map=new OLMap();
        OLLayer layer=createLayer(createSource());
        map.addLayer(layer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    private void addViewChangeListener() {
        map.getView().addViewChangeListener(new OLView.ViewChangeListener() {
            @Override
            public void resolutionChanged(Double newResolution) {
                logger.info("resolution changed "+newResolution);
            }

            @Override
            public void rotationChanged(Double rotation) {
                logger.info("rotation changed "+rotation);
            }

            @Override
            public void centerChanged(OLCoordinate centerPoint) {
                logger.info("center changed "+centerPoint.toText());
            }

            @Override
            public void zoomChanged(Integer zoom) {
                logger.info("zoom changed "+zoom);
            }

            @Override
            public void extentChanged(OLExtent extent) {
                logger.info("extent changed "+extent.minX+","+extent.minY+","+extent.maxX+","+extent.maxY);
            }
        });
    }

    protected OLSource createSource(){
        return new OLMapQuestSource(OLMapQuestLayerName.OSM);
    }

    protected OLLayer createLayer(OLSource source){
        return new OLTileLayer(source);
    }

    protected OLView createView(){
        OLView view=new OLView();
        view.setZoom(1);
        view.setCenter(0,0);
        return view;
    }

    protected void resetView(){
        map.getView().setCenter(0,0);
        map.getView().setZoom(1);
    }

    protected AbstractLayout createControls() {
        HorizontalLayout controls=new HorizontalLayout();
		controls.setSpacing(true);
		controls.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Button button=new Button("Reset view");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                resetView();
            }
        });
        controls.addComponent(button);
		button=new Button("Show view state");
		button.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				OLCoordinate center=map.getView().getCenter();
				StringBuilder message=new StringBuilder();
				message.append("center: ").append(center.toText()).append("\n");
				message.append("rotation: ").append(map.getView().getRotation()).append("\n");
				message.append("zoom: ").append(map.getView().getZoom()).append("\n");
				message.append("resolution: ").append(map.getView().getResolution()).append("\n");
				Notification.show(message.toString());
			}
		});
		controls.addComponent(button);
        button=new Button("Toggle map visibility");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                map.setVisible(!map.isVisible());
            }
        });
        controls.addComponent(button);
        return controls;
    }

}

package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The map demo UI. Contains a number of test maps as navigator views.
 */
public class MapTestUI extends UI {

    private Navigator navigator;
    private CssLayout buttonContainer;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout root=new VerticalLayout();
        root.setSizeFull();
        this.setContent(root);
        buttonContainer = new CssLayout();
        buttonContainer.setWidth("100%");
        root.addComponent(buttonContainer);
        VerticalLayout navigatorContainer=new VerticalLayout();
        navigatorContainer.setSizeFull();
        root.addComponent(navigatorContainer);
        root.setExpandRatio(navigatorContainer, 1.0f);
        navigator=new Navigator(this, navigatorContainer);
        addViews();
        if(Page.getCurrent().getUriFragment()==null || Page.getCurrent().getUriFragment().length()==0){
            navigator.navigateTo("Basic");
        }
    }

    private void addViews() {
        addView("Basic",BasicMap.class);
        addView("Constrained", ConstrainedMap.class);
        addView("Multilayer", MultiLayerMap.class);
        addView("OpenStreetMap", OSMMap.class);
        addView("ImageWMSMap",ImageWMSMap.class);
        addView("TileWMSMap", TileWMSMap.class);
        addView("VectorLayer", VectorLayerMap.class);
        addView("StyleTest", StyleTestMap.class);
        addView("ControlTest", ControlTestMap.class);
        addView("InteractionTest", InteractionMap.class);
        addView("ExtentTest", ExtentTestMap.class);
        addView("WMTSMap", WMTSMap.class);
    }

    private void addView(String label, Class<? extends View> implementation){
        navigator.addView(label, implementation);
        Button startView=new Button(label);
        startView.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo(event.getButton().getCaption());
            }
        });
        buttonContainer.addComponent(startView);
    }
}

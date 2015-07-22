package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.ui.*;
import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * Created by martin on 22.07.15.
 */
public class ViewPortMap extends BasicMap {

    @Override
    protected AbstractLayout createControls() {
        HorizontalLayout controls=new HorizontalLayout();
        controls.setSpacing(true);
        controls.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Button button=new Button("Show ViewPort info");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                StringBuilder message=new StringBuilder();
                message.append("ViewPort Coordinates: ").append(map.getView().getViewportExtent().toString()).append("\n");
                Notification.show(message.toString());
            }
        });
        controls.addComponent(button);
        return controls;
    }
}

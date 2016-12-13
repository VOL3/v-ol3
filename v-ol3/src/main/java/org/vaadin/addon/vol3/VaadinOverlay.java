package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractOrderedLayout;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLOverlay;
import org.vaadin.addon.vol3.client.popup.VaadinOverlayState;

import java.util.Random;

/**
 * Created by Mikael on 09/12/16.
 */
public class VaadinOverlay extends AbstractOrderedLayout {

    private final OLOverlay overlay;
    private final String id;

    public VaadinOverlay(OLCoordinate coordinate, String featureId) {
        id = featureId;
        this.overlay = createOverlay(coordinate,id);
        getState().ourOverlay = overlay;
    }

    public OLOverlay getOverlay() {
        return overlay;
    }

    public String getId() {
        return id;
    }

    private OLOverlay createOverlay(OLCoordinate coordinate, String featureId) {
        OLOverlay overlay=new OLOverlay();
        overlay.position=coordinate;
        overlay.htmlContent="<div class=\"ol-popup-content\" id=\""+featureId+"\"/>";
        overlay.id = featureId;
        overlay.classNames="ol-popup";
        return overlay;
    }

    @Override
    protected VaadinOverlayState getState() {
        return (VaadinOverlayState) super.getState();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof VaadinOverlay) {
            return id != null && ((VaadinOverlay)obj).id != null && id.equals(((VaadinOverlay)obj).id);
        }
        return false;
    }
}

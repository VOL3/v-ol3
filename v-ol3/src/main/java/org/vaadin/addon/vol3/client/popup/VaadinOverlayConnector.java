package org.vaadin.addon.vol3.client.popup;

import com.vaadin.client.ui.orderedlayout.AbstractOrderedLayoutConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.VaadinOverlay;

/**
 * Created by Mikael on 09/12/16.
 */
@Connect(value = VaadinOverlay.class, loadStyle = Connect.LoadStyle.EAGER)
public class VaadinOverlayConnector extends AbstractOrderedLayoutConnector {

    @Override
    public VaadinOverlayWidget getWidget() {
        return (VaadinOverlayWidget) super.getWidget();
    }

    @Override
    public VaadinOverlayState getState() {
        return (VaadinOverlayState) super.getState();
    }

    public void attach(boolean callOnAttach) {
        getWidget().setOverlay(getState().ourOverlay, callOnAttach);
    }

    public void detach() {
        getWidget().unlink();
    }
}

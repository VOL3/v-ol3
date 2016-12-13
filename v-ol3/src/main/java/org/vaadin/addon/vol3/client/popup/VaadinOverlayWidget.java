package org.vaadin.addon.vol3.client.popup;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.ui.VVerticalLayout;
import org.vaadin.addon.vol3.client.OLOverlay;

/**
 * Created by Mikael on 09/12/16.
 */
public class VaadinOverlayWidget extends VVerticalLayout {

    public void setOverlay(final OLOverlay overlay, final boolean callOnAttach) {
        Scheduler.get().scheduleFinally(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                Element element = Document.get().getElementById(overlay.id);
                if (element != null) {
                    element.appendChild(getElement());
                    if(callOnAttach)
                    VaadinOverlayWidget.this.onAttach();
                }
            }
        });
    }

    public void unlink() {
        onDetach();
    }
}

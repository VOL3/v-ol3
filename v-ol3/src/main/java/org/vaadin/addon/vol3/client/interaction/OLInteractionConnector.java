package org.vaadin.addon.vol3.client.interaction;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import org.vaadin.gwtol3.client.interaction.Interaction;

/**
 * Created by mjhosio on 25/08/14.
 */
public abstract class OLInteractionConnector extends AbstractComponentConnector {
    // we create a dummy widget since this connector is used
    // only to handle interaction state serialization
    private static final Widget dummyWidget=new Label();

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    public abstract Interaction getInteraction();

}

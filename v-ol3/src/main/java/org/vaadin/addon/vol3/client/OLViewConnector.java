package org.vaadin.addon.vol3.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import org.vaadin.gwtol3.client.View;

/**
 * Created by mjhosio on 30/06/14.
 */
public abstract class OLViewConnector extends AbstractComponentConnector{

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    public abstract View getView();
}

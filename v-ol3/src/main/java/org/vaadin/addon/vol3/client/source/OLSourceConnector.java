package org.vaadin.addon.vol3.client.source;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 27/06/14.
 */
public abstract class OLSourceConnector extends AbstractComponentConnector {

    protected Source source;

    // we create a dummy widget since this connector is used
    // only to communicate layer source related information
    private static final Widget dummyWidget = new Label();

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    /**
     * Returns the layer data source. Creates the source if not yet created.
     *
     * @return
     */
    public Source getSource() {
        if (source == null) {
            source = createSource();
        }
        return source;
    }

    /** Creates the layer data source
     *
     * @return the layer data source
     */
    protected abstract Source createSource();
}

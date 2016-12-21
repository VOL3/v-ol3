package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.interaction.OLDragBoxInteraction;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.interaction.DragBoxInteraction;
import org.vaadin.gwtol3.client.interaction.DragBoxInteractionEvent;
import org.vaadin.gwtol3.client.interaction.DragBoxInteractionOptions;
import org.vaadin.gwtol3.client.interaction.OnDragBoxInteractionListener;

/**
 * Created by Mikael on 21/12/16.
 */
@Connect(OLDragBoxInteraction.class)
public class OLDragBoxInteractionConnector extends OLInteractionConnector implements OnDragBoxInteractionListener {

    private DragBoxInteraction interaction;

    @Override
    public DragBoxInteraction getInteraction() {
        if (interaction == null) {
            interaction = createInteraction();
        }
        return interaction;
    }

    private DragBoxInteraction createInteraction() {
        DragBoxInteractionOptions opts = DragBoxInteractionOptions.create();
        if (getState().condition != null) {
            opts.setCondition(getState().condition.toString());
        }
        if(getState().featureStyle!=null){
            opts.setStyle(OLStyleConverter.convert(getState().featureStyle));
        }
        DragBoxInteraction interaction = DragBoxInteraction.create(opts);

        interaction.addDragBoxInteractionListener(this);
        return interaction;
    }

    @Override
    public OLDragBoxInteractionState getState() {
        return (OLDragBoxInteractionState) super.getState();
    }

    @Override
    public void onDragBoxInteraction(DragBoxInteractionEvent event) {
        Extent extent = event.getGeometry().getExtent();
        OLExtent olExtent = new OLExtent(new OLCoordinate(extent.getMinX(), extent.getMinY()), new OLCoordinate(extent.getMaxX(), extent.getMaxY()));
        getRpcProxy(OLDragBoxInteractionServerRpc.class).dragBoxEvent(event.getType().toString(), olExtent);
    }
}

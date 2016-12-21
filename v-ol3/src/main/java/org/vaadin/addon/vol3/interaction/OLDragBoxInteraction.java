package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.interaction.OLDragBoxInteractionServerRpc;
import org.vaadin.addon.vol3.client.interaction.OLDragBoxInteractionState;
import org.vaadin.addon.vol3.client.style.OLStrokeStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.gwtol3.client.interaction.DragBoxInteractionOptions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mikael on 21/12/16.
 */
public class OLDragBoxInteraction extends OLInteraction implements OLDragBoxInteractionServerRpc {
    private List<SelectionChangeListener> listeners = new LinkedList<SelectionChangeListener>();

    public OLDragBoxInteraction() {
        this(null);
    }

    public OLDragBoxInteraction(DragBoxInteractionOptions.Condition condition) {
        this(condition, new OLStyle(){{
            strokeStyle = new OLStrokeStyle() {{
                color = "rgba(0, 0, 255, 1)";
            }};
        }});
    }
    public OLDragBoxInteraction(DragBoxInteractionOptions.Condition condition, OLStyle style) {
        getState().condition = condition;
        getState().featureStyle = style;
        this.registerRpc(this, OLDragBoxInteractionServerRpc.class);
    }

    @Override
    protected OLDragBoxInteractionState getState() {
        return (OLDragBoxInteractionState) super.getState();
    }

    /**
     * Removes the specified selection change listener
     *
     * @param listener
     */
    public void removeSelectionChangeListener(SelectionChangeListener listener) {
        listeners.remove(listener);
    }

    /**
     * Add listener that will be notified when the selection changes
     *
     * @param listener
     */
    public void addSelectionChangeListener(SelectionChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void dragBoxEvent(String type, OLExtent extent) {
        for (SelectionChangeListener listener : this.listeners) {
            listener.selectionChanged(type, extent);
        }
    }

    /**
     * Listener for selection changes
     */
    public interface SelectionChangeListener {
        void selectionChanged(String type, OLExtent geometry);
    }
}

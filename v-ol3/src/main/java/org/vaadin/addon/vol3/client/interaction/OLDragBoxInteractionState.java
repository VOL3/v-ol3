package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.AbstractComponentState;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.gwtol3.client.interaction.DragBoxInteractionOptions;

import java.util.List;

/**
 * Created by Mikael on 21/12/16.
 */
public class OLDragBoxInteractionState extends AbstractComponentState {
    public DragBoxInteractionOptions.Condition condition;

    // the style for the sketch features
    public OLStyle featureStyle;
}

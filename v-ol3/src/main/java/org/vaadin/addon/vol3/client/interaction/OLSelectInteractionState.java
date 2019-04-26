package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;
import org.vaadin.addon.vol3.client.style.OLStyle;

import java.util.List;

/**
 * Shared state for the select interaction
 */
public class OLSelectInteractionState extends AbstractComponentState{
	// The selection condition 
	public String condition;
    // Style for selected features
    public List<OLStyle> featureStyles;
    // Layers where the selection is enabled. If not specified, all visible layers are available for selection.
    public List<Connector> layers;
}

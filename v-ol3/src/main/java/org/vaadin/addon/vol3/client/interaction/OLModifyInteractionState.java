package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;
import org.vaadin.addon.vol3.client.style.OLStyle;

import java.util.List;

/**
 * Created by mjhosio on 25/08/14.
 */
public class OLModifyInteractionState extends AbstractComponentState {
    // Pixel tolerance for considering the pointer close enough to a segment or vertex for editing. Default is 10 pixels.
    public Double pixelTolerance;
    // The FeatureOverlay style
    public List<OLStyle> featureStyles;
    // the layer the modify interaction works on
    public Connector layer;
}

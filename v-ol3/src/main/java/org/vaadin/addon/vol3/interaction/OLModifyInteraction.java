package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.interaction.OLModifyInteractionState;
import org.vaadin.addon.vol3.layer.OLVectorLayer;

/**
 * Interaction that allows modifying of the features on the layer
 * Created by mjhosio on 25/08/14.
 */
public class OLModifyInteraction extends OLInteraction{

    /** Creates a new instance of modify interaction
     * @param vectorLayer the layer the interaction operates on
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer){
        this(vectorLayer, null);
    }

    /** Creates a new instance of modify interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param options options for the layer
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer, OLModifyInteractionOptions options){
        if(options!=null){
            getState().pixelTolerance=options.getPixelTolerance();
            getState().featureStyles=options.getStyles();
        }
        getState().layer=vectorLayer;
    }

    @Override
    protected OLModifyInteractionState getState() {
        return (OLModifyInteractionState) super.getState();
    }
}

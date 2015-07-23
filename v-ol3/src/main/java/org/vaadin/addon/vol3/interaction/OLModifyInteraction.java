package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.interaction.OLModifyInteractionState;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.layer.OLVectorLayer;

/**
 * Interaction that allows modifying of the features on the layer
 */
public class OLModifyInteraction extends OLInteraction{

    /** Creates a new instance of modify interaction
     * @param vectorLayer the layer the interaction operates on
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer){
        this(vectorLayer, null, null);
    }

    /** Creates a new instance of modify interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param options options for the layer
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer, OLModifyInteractionOptions options){
        this(vectorLayer, null, options);
    }

    /** Creates a new instance of modify interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param olFeature the feature that can be edited
     * @param options options for the layer
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer, OLFeature olFeature, OLModifyInteractionOptions options){
        if(options!=null){
            getState().pixelTolerance=options.getPixelTolerance();
            getState().featureStyles=options.getStyles();
        }
        if(olFeature!=null){
            getState().featureId=olFeature.getId();
        }
        getState().layer=vectorLayer;
    }

    @Override
    protected OLModifyInteractionState getState() {
        return (OLModifyInteractionState) super.getState();
    }
}

package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.interaction.OLModifyInteractionState;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.layer.OLVectorLayer;

import java.util.ArrayList;

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
        this(vectorLayer, options, null);
    }

    /** Creates a new instance of modify interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param olFeatures the feature that can be edited
     * @param options options for the layer
     */
    public OLModifyInteraction(OLVectorLayer vectorLayer, OLModifyInteractionOptions options, OLFeature... olFeatures){
        if(options!=null){
            getState().pixelTolerance=options.getPixelTolerance();
            getState().featureStyles=options.getStyles();
        }
        if(olFeatures!=null){
            ArrayList<String> featureId = new ArrayList<String>();
            for (OLFeature olFeature : olFeatures) {
                featureId.add(olFeature.getId());
            }
            String[] featureArray = featureId.toArray(new String[featureId.size()]);
            getState().featureIds= featureArray;
        }
        getState().layer=vectorLayer;
    }

    @Override
    protected OLModifyInteractionState getState() {
        return (OLModifyInteractionState) super.getState();
    }
}

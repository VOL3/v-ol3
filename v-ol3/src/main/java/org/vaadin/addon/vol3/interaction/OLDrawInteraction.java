package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.interaction.OLDrawInteractionState;
import org.vaadin.addon.vol3.layer.OLVectorLayer;

/**
 * Created by mjhosio on 25/08/14.
 */
public class OLDrawInteraction extends OLInteraction {

    /** Creates a new instance of draw interaction
     *
     * @param vectorLayer the layer the interaction operates on
     */
    public OLDrawInteraction(OLVectorLayer vectorLayer){
        this(vectorLayer, null);
    }

    public OLDrawInteraction(OLVectorLayer vectorLayer, OLDrawInteractionOptions options){
        if(options!=null){
            getState().featureStyles=options.getStyles();
            getState().type=options.getTypeAsString();
            getState().snapTolerance=options.getSnapTolerance();
            getState().minPointsPerRing=options.getMinPointsPerRing();
            getState().geometryName=options.getGeometryName();
        }
        getState().layer=vectorLayer;
    }

    @Override
    protected OLDrawInteractionState getState() {
        return (OLDrawInteractionState) super.getState();
    }

}

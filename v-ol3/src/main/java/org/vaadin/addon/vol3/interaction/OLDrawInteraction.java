package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.interaction.OLDrawInteractionState;
import org.vaadin.addon.vol3.layer.OLVectorLayer;

/**
 * Interaction that allows drawing on the specified vector layer
 * Created by mjhosio on 25/08/14.
 */
public class OLDrawInteraction extends OLInteraction {

    /** Creates a new instance of draw interaction
     *
     * @param vectorLayer the layer the interaction operates on
     */
    public OLDrawInteraction(OLVectorLayer vectorLayer){
        this(vectorLayer, OLDrawInteractionOptions.DrawingType.POINT);
    }

    /** Creates a new instance of draw interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param drawingType the type of the markers user can create using the interaction
     */
    public OLDrawInteraction(OLVectorLayer vectorLayer, OLDrawInteractionOptions.DrawingType drawingType){
        OLDrawInteractionOptions opts=new OLDrawInteractionOptions();
        opts.setType(drawingType);
        init(vectorLayer, opts);
    }

    /** Creates a new instance of draw interaction
     *
     * @param vectorLayer the layer the interaction operates on
     * @param options the options for the interaction
     */
    public OLDrawInteraction(OLVectorLayer vectorLayer, OLDrawInteractionOptions options){
        init(vectorLayer, options);
    }


    private void init(OLVectorLayer vectorLayer, OLDrawInteractionOptions options){
        if(options!=null){
            getState().featureStyles=options.getStyles();
            getState().type=OLDrawInteractionOptions.getTypeAsString(options.getType());
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

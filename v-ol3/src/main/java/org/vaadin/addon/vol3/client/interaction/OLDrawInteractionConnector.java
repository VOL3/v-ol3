package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.layer.OLVectorLayerConnector;
import org.vaadin.addon.vol3.client.source.OLVectorSourceConnector;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.interaction.OLDrawInteraction;
import org.vaadin.gwtol3.client.interaction.DrawInteraction;
import org.vaadin.gwtol3.client.interaction.DrawInteractionOptions;

import java.util.logging.Logger;

/**
 * Client-side connector for draw interaction
 */
@Connect(OLDrawInteraction.class)
public class OLDrawInteractionConnector extends OLInteractionConnector {
    private static final Logger logger= Logger.getLogger(OLDrawInteractionConnector.class.getName());
    private DrawInteraction interaction;

    @Override
    public DrawInteraction getInteraction(){
        if(interaction==null){
            interaction=createInteraction();
        }
        return interaction;
    }

    @Override
    public OLDrawInteractionState getState() {
        return (OLDrawInteractionState) super.getState();
    }

    private DrawInteraction createInteraction(){
        DrawInteractionOptions opts=DrawInteractionOptions.create();
        if(getState().geometryName!=null){
            opts.setGeometryName(getState().geometryName);
        }
        if(getState().minPointsPerRing!=null){
            opts.setMinPointsPerRing(getState().minPointsPerRing);
        }
        if(getState().snapTolerance!=null){
            opts.setSnapTolerance(getState().snapTolerance);
        }
        if(getState().type!=null){
            opts.setType(getState().type);
        }
        if(getState().styles!=null){
            opts.setStyle(OLStyleConverter.convert(getState().featureStyles));
        }
        OLVectorSourceConnector vectorSource=getVectorSourceConnector();
        opts.setSource(vectorSource.getSource());
        DrawInteraction interaction = DrawInteraction.create(opts);
        return interaction;
    }

    private OLVectorSourceConnector getVectorSourceConnector(){
        OLVectorSourceConnector vectorSource=null;
        if(getState().layer!=null && getState().layer instanceof OLVectorLayerConnector){
            OLVectorLayerConnector layer= (OLVectorLayerConnector) getState().layer;
            vectorSource= (OLVectorSourceConnector) layer.getSourceConnector();
        }
        return vectorSource;
    }

}

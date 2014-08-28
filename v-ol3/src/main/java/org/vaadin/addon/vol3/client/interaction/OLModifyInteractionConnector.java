package org.vaadin.addon.vol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.layer.OLVectorLayerConnector;
import org.vaadin.addon.vol3.client.source.OLVectorSourceConnector;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.interaction.OLModifyInteraction;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.interaction.ModifyInteraction;
import org.vaadin.gwtol3.client.interaction.ModifyInteractionOptions;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener;

import java.util.logging.Logger;

/**
 * Created by mjhosio on 25/08/14.
 */
@Connect(OLModifyInteraction.class)
public class OLModifyInteractionConnector extends OLInteractionConnector implements FeatureSetChangeListener{
    private ModifyInteraction interaction;
    private Collection<Feature> targetFeatures;
    private JavaScriptObject listenerKey;

    private static final Logger logger= Logger.getLogger(OLModifyInteractionConnector.class.getName());

    @Override
    public ModifyInteraction getInteraction(){
        if(interaction==null){
            interaction=createInteraction();
        }
        return interaction;
    }

    @Override
    public OLModifyInteractionState getState() {
        return (OLModifyInteractionState) super.getState();
    }

    @Override
    public void onUnregister() {
        OLVectorSourceConnector vectorSourceConnector=getVectorSourceConnector();
        if(vectorSourceConnector!=null){
            vectorSourceConnector.getSource().removeFeatureSetChangeListener(listenerKey);
        }
    }

    private ModifyInteraction createInteraction(){
        ModifyInteractionOptions opts=ModifyInteractionOptions.create();
        opts.setStyles(OLStyleConverter.convert(getState().featureStyles));
        if(getState().pixelTolerance!=null){
            opts.setPixelTolerance(getState().pixelTolerance);
        }
        // add change listener to vector layer to get updates on feature changes
        OLVectorSourceConnector vectorSourceConnector=getVectorSourceConnector();
        VectorSource vectorSource=vectorSourceConnector.getSource();
        listenerKey=vectorSource.addFeatureSetChangeListener(this);
        // create collection of features that is updated when features are added
        // or removed from the associated vector layer
        targetFeatures=Collection.create(vectorSource.getFeatures());
        opts.setFeatures(targetFeatures);
        ModifyInteraction modify=ModifyInteraction.create(opts);
        return modify;
    }

    private OLVectorSourceConnector getVectorSourceConnector(){
        OLVectorSourceConnector vectorSource=null;
        if(getState().layer!=null && getState().layer instanceof OLVectorLayerConnector){
            OLVectorLayerConnector layer= (OLVectorLayerConnector) getState().layer;
            vectorSource= (OLVectorSourceConnector) layer.getSourceConnector();
        }
        return vectorSource;
    }

    @Override
    public void featureDeleted(Feature feature) {
        targetFeatures.remove(feature);
    }

    @Override
    public void featureAdded(Feature feature) {
        targetFeatures.push(feature);
    }
}

package org.vaadin.addon.vol3.client.interaction;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.layer.OLLayerConnector;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.interaction.OLSelectInteraction;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.interaction.SelectInteraction;
import org.vaadin.gwtol3.client.interaction.SelectInteractionOptions;
import org.vaadin.gwtol3.client.interaction.SelectionChangeListener;
import org.vaadin.gwtol3.client.layer.Layer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjhosio on 25/08/14.
 */
@Connect(OLSelectInteraction.class)
public class OLSelectInteractionConnector extends OLInteractionConnector implements SelectionChangeListener{

    private SelectInteraction interaction;
    private boolean selectionChanged=false;

    @Override
    public SelectInteraction getInteraction(){
        if(interaction==null){
            interaction=createInteraction();
        }
        return interaction;
    }

    @Override
    public OLSelectInteractionState getState() {
        return (OLSelectInteractionState) super.getState();
    }

    private SelectInteraction createInteraction(){
        SelectInteractionOptions opts=SelectInteractionOptions.create();
        opts.setStyles(OLStyleConverter.convert(getState().featureStyles));
        if(getState().layers!=null){
            JsArray<Layer> layers=JsArray.createArray().cast();
            for(Connector layerConnector : getState().layers){
                layers.push(((OLLayerConnector) layerConnector).getLayer());
            }
            opts.setLayers(layers);
        }
        SelectInteraction interaction=SelectInteraction.create(opts);
        interaction.addSelectionChangeListener(this);
        return interaction;
    }

    @Override
    public void selectionChanged() {
        selectionChanged=true;
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                if(selectionChanged){
                    updateSelectedFeatures();
                }
            }
        });
    }

    private void updateSelectedFeatures(){
        List<String> selectedFeatures=new ArrayList<String>();
        Collection collection=interaction.getFeatures();
        for(int i=0;i<collection.getLength();i++){
            Feature f=collection.item(i).cast();
            selectedFeatures.add(f.getId());
        }
        getRpcProxy(OLSelectInteractionSRPC.class).updateSelection(selectedFeatures);
        selectionChanged=false;
    }
}

package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.interaction.OLDrawInteraction;
import org.vaadin.addon.vol3.interaction.OLDrawInteractionOptions;
import org.vaadin.addon.vol3.interaction.OLInteraction;
import org.vaadin.addon.vol3.interaction.OLModifyInteraction;
import org.vaadin.addon.vol3.interaction.OLModifyInteractionOptions;
import org.vaadin.addon.vol3.interaction.OLSelectInteraction;
import org.vaadin.addon.vol3.source.OLVectorSource;

import java.util.List;
import java.util.logging.Logger;

/**
 * Map for testing interactions
 */
public class InteractionMap extends VectorLayerMap {

    private NativeSelect markerType;
    private static final Logger logger= Logger.getLogger(InteractionMap.class.getName());
    public List<String> selection;


    @Override
    protected OLMap createMap() {
        final OLMap map = super.createMap();
        // create select interaction for the vector layer
        map.addInteraction(createSelectInteraction());
//        map.addComponent(createModifyInteraction());
//        map.addComponent(createDrawInteraction());
        addFeatureChangeListeners();

        return map;

    }

    private void clearInteractions(){
        for(OLInteraction interaction : map.getInteractions()){
            map.removeInteraction(interaction);
        }
    }

    @Override
    protected AbstractLayout createControls() {
        AbstractLayout layout= super.createControls();
        Button selectButton=new Button("selectMode");
        selectButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearInteractions();
                map.addInteraction(createSelectInteraction());
            }
        });
        layout.addComponent(selectButton);

        Button modifyButton=new Button("modifyMode");
        modifyButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearInteractions();
                //logger.info(((OLVectorSource) vectorLayer.getSource()).getFeatures().toString());
                map.addInteraction(createModifyInteraction());
            }
        });
        layout.addComponent(modifyButton);

        Button modifyRectButton=new Button("modifyOnlyRectFeature");
        modifyRectButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearInteractions();
                map.addInteraction(createModifyRectInteraction());
            }
        });
        layout.addComponent(modifyRectButton);

        Button drawButton=new Button("drawMode");
        drawButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearInteractions();
                map.addInteraction(createDrawInteraction());
            }
        });
        layout.addComponent(drawButton);
        markerType=new NativeSelect();
        markerType.setItems(OLDrawInteractionOptions.DrawingType.POINT,
                OLDrawInteractionOptions.DrawingType.LINESTRING,
                OLDrawInteractionOptions.DrawingType.POLYGON);
        /*markerType.addItem(OLDrawInteractionOptions.DrawingType.POINT);
        markerType.addItem(OLDrawInteractionOptions.DrawingType.LINESTRING);
        markerType.addItem(OLDrawInteractionOptions.DrawingType.POLYGON);
        markerType.setNullSelectionAllowed(false);
        */

        markerType.setValue(OLDrawInteractionOptions.DrawingType.POINT);

        markerType.addValueChangeListener(event -> {
            clearInteractions();
            map.addInteraction(createDrawInteraction());
        });
        /*
        markerType.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                clearInteractions();
                map.addInteraction(createDrawInteraction());
            }
        });
        */
        layout.addComponent(markerType);
        Button deleteButton = new Button("delete selected");
        deleteButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(selection!=null){
                    OLVectorSource source = (OLVectorSource) vectorLayer.getSource();
                    for(String id : selection){
                        source.removeFeatureById(id);
                    }
                    selection.clear();
                }
            }
        });
        layout.addComponent(deleteButton);
        return layout;
    }

    private OLSelectInteraction createSelectInteraction(){
        final OLSelectInteraction select = new OLSelectInteraction();
        select.addSelectionChangeListener(new OLSelectInteraction.SelectionChangeListener() {

            @Override
            public void selectionChanged(List<String> selectedFeatures) {
                Notification.show("Feature(s) selected: "+selectedFeatures);
                selection=selectedFeatures;
            }
        });
        return select;
    }

    private OLDrawInteraction createDrawInteraction(){
        OLDrawInteractionOptions opts=new OLDrawInteractionOptions();
        opts.setType((OLDrawInteractionOptions.DrawingType) markerType.getValue());
        OLDrawInteraction draw=new OLDrawInteraction(vectorLayer, opts);
        return draw;
    }

    private OLModifyInteraction createModifyInteraction(){
        // create modify interaction
        OLModifyInteractionOptions modOpts=new OLModifyInteractionOptions();
        OLModifyInteraction modify=new OLModifyInteraction(vectorLayer,modOpts);
        return modify;
    }

    private OLModifyInteraction createModifyRectInteraction(){
        // create modify interaction
        OLModifyInteractionOptions modOpts=new OLModifyInteractionOptions();
        OLFeature rectFeature = ((OLVectorSource) vectorLayer.getSource()).getFeatureById("rect");
        //logger.info(rectFeature.toString());
        OLModifyInteraction modify=new OLModifyInteraction(vectorLayer, modOpts, rectFeature);
        return modify;
    }

    private void addFeatureChangeListeners(){
        OLVectorSource source= (OLVectorSource) vectorLayer.getSource();
        source.addFeatureSetChangeListener(new OLVectorSource.FeatureSetChangeListener() {
            @Override
            public void featureAdded(OLFeature feature) {
                Notification.show("Feature added "+feature.getId());
            }

            @Override
            public void featureDeleted(OLFeature feature) {
                Notification.show("Feature deleted "+feature.getId());
            }
        });
        source.addFeatureModificationListener(new OLVectorSource.FeatureModificationListener() {
            @Override
            public void featureModified(OLFeature feature) {
                Notification.show("Feature modified "+feature.getId());
            }
        });
    }
}

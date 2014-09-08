package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.data.Property;
import com.vaadin.ui.*;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.interaction.*;
import org.vaadin.addon.vol3.source.OLVectorSource;

import java.util.List;

/**
 * Map for testing interactions
 */
public class InteractionMap extends VectorLayerMap {

    private NativeSelect markerType;

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
    protected Component createControls() {
        CssLayout layout= (CssLayout) super.createControls();
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
                map.addInteraction(createModifyInteraction());
            }
        });
        layout.addComponent(modifyButton);

        Button drawButton=new Button("drawMode");
        drawButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearInteractions();
                map.addInteraction(createDrawInteraction());
            }
        });
        layout.addComponent(drawButton);
        markerType=new NativeSelect("choose marker");
        markerType.addItem(OLDrawInteractionOptions.DrawingType.POINT);
        markerType.addItem(OLDrawInteractionOptions.DrawingType.LINESTRING);
        markerType.addItem(OLDrawInteractionOptions.DrawingType.POLYGON);
        markerType.setNullSelectionAllowed(false);
        markerType.setValue(OLDrawInteractionOptions.DrawingType.POINT);
        markerType.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                clearInteractions();
                map.addInteraction(createDrawInteraction());
            }
        });
        layout.addComponent(markerType);
        return layout;
    }

    private OLSelectInteraction createSelectInteraction(){
        final OLSelectInteraction select = new OLSelectInteraction();
        select.addSelectionChangeListener(new OLSelectInteraction.SelectionChangeListener() {
            @Override
            public void selectionChanged(List<String> selectedFeatures) {
                Notification.show("Feature(s) selected: "+selectedFeatures);
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

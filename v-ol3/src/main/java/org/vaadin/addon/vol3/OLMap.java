package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.client.OLMapState;
import org.vaadin.addon.vol3.layer.OLLayer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mjhosio on 24/06/14.
 */
public class OLMap extends AbstractComponentContainer{

    private List<Component> components=new LinkedList<Component>();
    private OLView view;

    public OLMap(){
        this(new OLView2D());
    }

    public OLMap(OLView view){
        this.view=view;
    }

    /** Adds layer to the map
     *
     * @param layer the layer to be added
     */
    public void addLayer(OLLayer layer){
        addComponent(layer);
    }

    public void removeLayer(OLLayer layer){
        removeComponent(layer);
    }

    public void setView(OLView view){
        if(view==null){
            throw new IllegalArgumentException("The view instance can not be null");
        }
        doSetView(view);
    }

    public OLView getView(OLView view){
        return view;
    }

    @Override
    public int getComponentCount() {
        return components.size();
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }

    @Override
    protected OLMapState getState() {
        return (OLMapState) super.getState();
    }

    @Override
    public void addComponent(Component c) {
        if(c instanceof OLLayer){
            super.addComponent(c);
            components.add(c);
        } else{
            throw new UnsupportedOperationException("Only instances of OLLayer can be added");
        }
    }

    @Override
    public void removeComponent(Component c) {
        if(c instanceof OLLayer){
            components.remove(c);
            super.removeComponent(c);
        }
    }

    private void doSetView(OLView olView) {
        if(olView==this.view){
            return;
        }
        if(this.view!=null){
            // remove old view
            components.remove(this.view);
            super.removeComponent(this.view);
        }
        this.view=olView;
        components.add(olView);
        super.addComponent(olView);
    }

    @Override
    public void replaceComponent(Component component, Component component2) {
        throw new UnsupportedOperationException("Replace component not implemented");
    }
}

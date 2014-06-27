package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.client.OLMapState;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mjhosio on 24/06/14.
 */
public class OLMap extends AbstractComponentContainer{

    private List<Component> children=new LinkedList<Component>();

    @Override
    public void replaceComponent(Component component, Component component2) {
    }

    @Override
    public int getComponentCount() {
        return children.size();
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
    }

    @Override
    protected OLMapState getState() {
        return (OLMapState) super.getState();
    }
}

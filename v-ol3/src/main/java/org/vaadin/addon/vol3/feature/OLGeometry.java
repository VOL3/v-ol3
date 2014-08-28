package org.vaadin.addon.vol3.feature;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mjhosio on 27/08/14.
 */
public abstract class OLGeometry<T> {
    protected List<T> elements=new LinkedList<T>();

    public OLGeometry(T... elements){
        for(T element : elements){
            this.elements.add(element);
        }
    }

    public void add(T element){
        this.elements.add(element);
    }

    public List<T> getElements(){
        return elements;
    }

    public void setElements(List<T> elements){
        this.elements=elements;
    }
}

package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;

/**
 * Fill style for features
 */
public class OLFillStyle implements Serializable{

    public OLFillStyle(){
        super();
    }

    public OLFillStyle(String color){
        super();
        this.color=color;
    }

    public String color;

    @Override
    public String toString() {
        return "OLFillStyle{" +
                "color='" + color + '\'' +
                '}';
    }
}

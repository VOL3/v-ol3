package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;

/**
 * Created by mjhosio on 09/07/14.
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
}

package org.vaadin.gwtol3.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by mjhosio on 24/06/14.
 */
public class MapWidget extends Widget {

    private Map map;

    public MapWidget(){
        setElement(Document.get().createDivElement());
        setHeight("450px");
        setStylePrimaryName(getElement(), "ol3map");
        map = Map.create(getElement());
    }

    public Map getMap(){
        return map;
    }
}

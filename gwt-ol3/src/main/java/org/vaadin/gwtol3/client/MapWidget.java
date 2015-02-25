package org.vaadin.gwtol3.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * The GWT widget that shows the map
 */
public class MapWidget extends Widget {

    private Map map;

    public MapWidget(){
        setElement(Document.get().createDivElement());
        setStylePrimaryName(getElement(), "ol3map");
    }

    public void initMap(MapOptions options){
        map = Map.create(options);
        if(isAttached()){
            attachMapToWidget();
        }
    }

    public boolean isMapInitialized(){
        return map!=null;
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(map!=null && map.getTarget()!=getElement()){
            map.setTarget(getElement());
            map.updateSize();
        }
    }

    private void attachMapToWidget(){
        map.setTarget(getElement());
    }

    private void detachMapFromWidget(){
        map.setTarget(null);
        map=null;
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        if(map!=null){
            detachMapFromWidget();
        }
    }

    public Map getMap(){
        return map;
    }
}

package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.layer.OLVectorLayerState;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.source.OLSource;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by mjhosio on 30/06/14.
 */
public class OLVectorLayer extends OLLayer {
    public OLVectorLayer(OLSource source) {
        super(source, null);
    }

    public OLVectorLayer(OLSource source, OLLayerOptions options){
        super(source,options);
    }

    public void setStyle(OLStyle style){
        LinkedList<OLStyle> styles=new LinkedList<OLStyle>();
        styles.add(style);
        setStyles(styles);
    }

    public void setStyles(List<OLStyle> styles){
        getState().featureStyles=styles;
    }

    public List<OLStyle> getStyles(){
        return getState().featureStyles;
    }

    @Override
    protected OLVectorLayerState getState() {
        return (OLVectorLayerState) super.getState();
    }
}

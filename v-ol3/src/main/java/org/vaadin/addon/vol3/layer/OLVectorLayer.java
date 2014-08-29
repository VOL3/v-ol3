package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.layer.OLVectorLayerState;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.source.OLSource;

import java.util.LinkedList;
import java.util.List;

/**
 * Vector layer for drawing markers (features)
 * Created by mjhosio on 30/06/14.
 */
public class OLVectorLayer extends OLLayer {

    /** Creates a new instance of the layer
     * @param source the data source for the vector data
     */
    public OLVectorLayer(OLSource source) {
        super(source, null);
    }

    /** Creates a new instance of the layer
     *
     * @param source the data source for the vector data
     * @param options vector source options
     */
    public OLVectorLayer(OLSource source, OLLayerOptions options){
        super(source,options);
    }

    /** Sets the style that is applied to all features on the layer
     *
     * @param style the style that is applied to all features on the layer
     */
    public void setStyle(OLStyle style){
        LinkedList<OLStyle> styles=new LinkedList<OLStyle>();
        styles.add(style);
        setStyles(styles);
    }

    /** Sets the styles that are applied to all features on the layer
     *
     * @param styles the styles that are applied to all features on the layer
     */
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

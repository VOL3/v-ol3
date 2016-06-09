package org.vaadin.addon.vol3.client.layer;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.source.OLSourceConnector;
import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.source.Source;

import java.util.logging.Logger;

/**
 * Abstract base class for client-side connectors of the layers
 */
public abstract class OLLayerConnector extends AbstractSingleComponentContainerConnector {

    private static final Logger logger= Logger.getLogger(OLLayerConnector.class.getName());

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();

    protected Layer layer;

    public OLLayerConnector(){
        super();
    }

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    @Override
    public OLLayerState getState() {
        return (OLLayerState) super.getState();
    }

    /** Returns the underlying wrapped javascript source implementation
     *
     * @return the source implementation
     */
    public Source getSource(){
        if(super.getContent()!=null){
            return ((OLSourceConnector)super.getContent()).getSource();
        }
        return null;
    }

    /** Returns the connector for the layer data source
     *
     * @return
     */
    public OLSourceConnector getSourceConnector(){
        return (OLSourceConnector) super.getContent();
    }

    /** Returns the underlying wrapped javascript layer implementation
     *
     * @return layer implementation
     */
    public Layer getLayer(){
        if(layer==null){
            layer=createLayer(getSource());
        }
        return layer;
    }

    /** Creates the javascript layer implementation. To be implemented in super classes
     *
     * @param source the layer data source
     * @return the javascript layer implementation
     */
    protected abstract Layer createLayer(Source source);

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        // no-op
    }

    @OnStateChange("maxResolution")
    void updateMaxResolution(){
        if(getState().maxResolution!=null){
            getLayer().setMaxResolution(getState().maxResolution.doubleValue());
        }
    }

    @OnStateChange("minResolution")
    void updateMinResolution(){
        if(getState().minResolution!=null){
            getLayer().setMinResolution(getState().minResolution.doubleValue());
        }
    }

    @OnStateChange("opacity")
    void updateOpacity(){
        if(getState().opacity!=null){
            getLayer().setOpacity(getState().opacity.doubleValue());
        }
    }

    @OnStateChange("visible")
    void updateVisible(){
        if(getState().visible!=null){
            getLayer().setVisible(getState().visible.booleanValue());
        }
    }

    @OnStateChange("extent")
    void updateExtent(){
        if(getState().extent!=null){
            logger.info("Updating extent");
            OLExtent ext=getState().extent;
            Extent extent=Extent.create(ext.minX,ext.minY, ext.maxX, ext.maxY);
            if(getState().inputProjection!=null){
                String sourceProjection=getSource().getProjection().getCode();
                if(sourceProjection!=null && !sourceProjection.equals(getState().inputProjection)){
                    // we need to transform the extent
                    logger.info("Converting extent from "+getState().inputProjection+" to "+sourceProjection);
                    getLayer().setExtent(DataConversionUtils.transformExtent(getState().inputProjection, sourceProjection, extent));
                }
            } else{
                logger.info("No need to convert, just set the extent");
                getLayer().setExtent(extent);
            }
        }
    }

    @OnStateChange("title")
    void updateTitle(){
        if(getState().title!=null){
            getLayer().setTitle(getState().title);
        }
    }

    @OnStateChange("zIndex")
    void updateZIndex(){
        if(getState().zIndex!=null){
            getLayer().setZIndex(getState().zIndex);
        }
    }

}

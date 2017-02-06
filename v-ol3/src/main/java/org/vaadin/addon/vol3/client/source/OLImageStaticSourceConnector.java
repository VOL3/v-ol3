package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.source.OLImageStaticSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.source.ImageStaticSource;
import org.vaadin.gwtol3.client.source.ImageStaticSourceOptions;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Client-side connector for the ImageWMSSource
 */
@Connect(OLImageStaticSource.class)
public class OLImageStaticSourceConnector extends OLSourceConnector {

    @Override
    protected Source createSource() {
        ImageStaticSourceOptions options = ImageStaticSourceOptions.create();
        OLImageStaticSourceState state = getState();
        if (state.attributions != null && state.attributions.length > 0) {
            JsArray<Attribution> jsArray = JsArray.createArray().cast();
            for (String attribution : state.attributions) {
                jsArray.push(Attribution.create(attribution));
            }
            options.setAttributions(jsArray);
        }
        if (state.projection != null) {
            options.setProjection(state.projection);
        }
        if (state.imageExtent != null) {
            OLExtent ext = getState().imageExtent;
            options.setImageExtent(Extent.create(ext.minX, ext.minY, ext.maxX, ext.maxY));
        }
        if (state.url != null) {
            options.setUrl(state.url);
        }
        return ImageStaticSource.create(options);
    }

    @Override
    public OLImageStaticSourceState getState() {
        return (OLImageStaticSourceState) super.getState();
    }

    @Override
    public ImageStaticSource getSource() {
        return (ImageStaticSource) super.getSource();
    }


}

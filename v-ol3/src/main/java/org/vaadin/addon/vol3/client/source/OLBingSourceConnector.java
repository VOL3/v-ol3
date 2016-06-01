package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLBingSource;
import org.vaadin.gwtol3.client.source.BingSource;
import org.vaadin.gwtol3.client.source.BingSourceOptions;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Client-side connector for the OLBingSource
 * Created by Martin Stypinski 20/03/2016
 */
@Connect(OLBingSource.class)
public class OLBingSourceConnector extends OLXYZSourceConnector{
    @Override
    protected Source createSource() {
        BingSourceOptions options = BingSourceOptions.create();

        if(getState().key != null){
            options.setKey(getState().key);
        }
        if(getState().imagerySet != null){
            options.setImagerySet(getState().imagerySet);
        }
        if(getState().culture != null){
            options.setCulture(getState().culture);
        }

        return BingSource.create(options);
    }

    @Override
    public OLBingSourceState getState() {
        return (OLBingSourceState) super.getState();
    }
}
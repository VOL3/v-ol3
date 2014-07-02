package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLMapQuestSource;
import org.vaadin.gwtol3.client.source.MapQuestSource;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect (OLMapQuestSource.class)
public class OLMapQuestSourceConnector extends OLSourceConnector{

    MapQuestSource source;

    @Override
    public Source getSource() {
        if(source==null){
            source = MapQuestSource.create(getState().layer.name().toLowerCase());
        }
        return source;
    }

    @Override
    public OLMapQuestSourceState getState() {
        return (OLMapQuestSourceState) super.getState();
    }
}

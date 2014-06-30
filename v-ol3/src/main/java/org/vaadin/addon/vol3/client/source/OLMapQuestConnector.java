package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLMapQuest;
import org.vaadin.gwtol3.client.source.MapQuest;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect (OLMapQuest.class)
public class OLMapQuestConnector extends OLSourceConnector{

    MapQuest source;

    @Override
    public Source getSource() {
        if(source==null){
            source=MapQuest.create(getState().layer);
        }
        return source;
    }

    @Override
    public OLMapQuestState getState() {
        return (OLMapQuestState) super.getState();
    }
}

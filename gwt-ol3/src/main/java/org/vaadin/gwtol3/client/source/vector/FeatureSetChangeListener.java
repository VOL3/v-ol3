package org.vaadin.gwtol3.client.source.vector;

import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Created by mjhosio on 28/08/14.
 */
public interface FeatureSetChangeListener {
    public void featureDeleted(Feature feature);
    public void featureAdded(Feature feature);

}

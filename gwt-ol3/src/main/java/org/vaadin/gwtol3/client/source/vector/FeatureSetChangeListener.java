package org.vaadin.gwtol3.client.source.vector;

import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Listener for feature changes (add / remove) in a VectorSource
 */
public interface FeatureSetChangeListener {
    public void featureDeleted(Feature feature);
    public void featureAdded(Feature feature);

}

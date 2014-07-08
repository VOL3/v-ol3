package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.communication.ClientRpc;
import org.vaadin.addon.vol3.client.feature.SerializedFeature;

import java.util.List;

/**
 * Created by mjhosio on 08/07/14.
 */
public interface OLVectorSourceClientRpc extends ClientRpc {
    /** Creates or updates the features on the client side. The features are encoded as JSON
     *
     * @param featuresAsJSON
     */
    public void createOrUpdateFeatures(List<SerializedFeature> features);

    /** Removes a list of features from the source
     * @param featureIds list of feature ids to be removed
     */
    public void removeFeatures(List<String> featureIds);
}

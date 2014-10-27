package org.vaadin.addon.vol3.client;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Created by mjhosio on 27/10/14.
 */
public interface OLViewServerRpc extends ServerRpc {

	@Delayed (lastOnly = true)
	public void updateCenter(OLCoordinate coordinate);

	@Delayed (lastOnly = true)
	public void updateRotation(double rotation);

	@Delayed (lastOnly = true)
	public void updateResolution(double resolution);

	@Delayed (lastOnly = true)
	public void updateZoom(double zoom);

}

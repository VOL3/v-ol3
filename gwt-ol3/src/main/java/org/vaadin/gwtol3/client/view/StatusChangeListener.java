package org.vaadin.gwtol3.client.view;

/**
 * Created by mjhosio on 27/10/14.
 */
public interface StatusChangeListener {
	/** Invoked when the view center point changes
	 *
	 */
	public void centerChanged();

	/** Invoked when the view resolution changes (zoom action)
	 *
	 */
	public void resolutionChanged();

	/** Invoked when the view rotation changes
	 *
	 */
	public void rotationChanged();
}

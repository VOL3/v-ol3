package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Tile loading options
 */
public class DeviceOptions extends JavaScriptObject {
    protected DeviceOptions() {
    }

    /** Creates an instance of device options
     *
     * @param loadTilesWhileAnimating When set to false, no tiles will be loaded while animating, which improves responsiveness on devices with slow memory. Default is true.
     * @param loadTilesWhileInteracting When set to false, no tiles will be loaded while interacting, which improves responsiveness on devices with slow memory. Default is true.
     * @return
     */
    public static native DeviceOptions create(boolean loadTilesWhileAnimating, boolean loadTilesWhileInteracting)
    /*-{
        return {
            loadTilesWhileAnimating: loadTilesWhileAnimating,
            loadTilesWhileInteracting: loadTilesWhileInteracting
        };
    }-*/;

}

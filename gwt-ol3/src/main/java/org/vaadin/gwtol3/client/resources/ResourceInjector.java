package org.vaadin.gwtol3.client.resources;

import com.google.gwt.core.client.GWT;

/**
 * Injector for the JavaScript library and associated CSS files
 */
public class ResourceInjector {
    protected static OL3ClientBundle bundle;

    public static void ensureInjected() {
        if (bundle == null) {
            bundle = GWT.create(OL3ClientBundle.class);
            ResourceInjector injector = GWT
                    .create(ResourceInjector.class);
            injector.injectResources();
        }
    }

    /**
     * Override this with deferred binding to customize injected stuff
     */
    protected void injectResources() {
        bundle.css().ensureInjected();
        injectScript(bundle.javaScript().getText());
    }

    private static native void injectScript(String script)
	/*-{
        $wnd.eval(script);
    }-*/;
}

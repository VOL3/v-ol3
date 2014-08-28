package org.vaadin.gwtol3.client.interaction;

/**
 * Interaction that allows drawing of geometries
 * Created by mjhosio on 25/08/14.
 */
public class DrawInteraction extends Interaction{
    protected DrawInteraction() {
    }

    public static final native DrawInteraction create()/*-{
        return new $wnd.ol.interaction.Draw();
    }-*/;

    public static final native DrawInteraction create(DrawInteractionOptions options)/*-{
        return new $wnd.ol.interaction.Draw(options);
    }-*/;
}

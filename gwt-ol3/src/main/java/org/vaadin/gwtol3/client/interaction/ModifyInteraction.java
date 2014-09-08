package org.vaadin.gwtol3.client.interaction;

/**
 * Interaction for modifying vector data
 */
public class ModifyInteraction extends PointerInteraction {
    protected ModifyInteraction() {
    }

    public static final native ModifyInteraction create()/*-{
        return new $wnd.ol.interaction.Modify();
    }-*/;

    public static final native ModifyInteraction create(ModifyInteractionOptions options)/*-{
        var modifyInteraction=new $wnd.ol.interaction.Modify(options);
        return modifyInteraction;
    }-*/;
}

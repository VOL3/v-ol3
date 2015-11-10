/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

/**
 *
 * @author iserge
 */
public class TranslateInteraction extends PointerInteraction {
    protected TranslateInteraction() {
        //
    }
    
    public static final native TranslateInteraction create(TranslateInteractionOptions options) /*-{
        return new $wnd.ol.interaction.Translate(options);
    }-*/;
}

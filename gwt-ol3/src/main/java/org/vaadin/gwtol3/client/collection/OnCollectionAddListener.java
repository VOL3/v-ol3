/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.collection;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author iserge
 */
public interface OnCollectionAddListener {
    /**
     * 
     * @param element - object which will be added
     */
    public void onCollectionAdd(JavaScriptObject element);
}

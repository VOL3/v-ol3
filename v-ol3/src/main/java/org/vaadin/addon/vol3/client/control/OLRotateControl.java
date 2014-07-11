package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A button control to reset rotation to 0. To style this control use css selector .ol-rotate.
 * Created by mjhosio on 11/07/14.
 */
public class OLRotateControl implements Serializable {
    //the css class name of the control. Default is ol-rotate
    public String className;
    // text label for the rotate button
    public String label;
    // text label for the rotate tip. Default is 'Reset rotation'
    public String tipLabel;
    // animation duration in milliseconds. Default is 250 ms
    public Integer duration;
    // Hide the control when rotation is 0. Default is true
    public Boolean autoHide;
}

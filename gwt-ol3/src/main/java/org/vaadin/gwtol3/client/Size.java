package org.vaadin.gwtol3.client;

/**
 * Created by mjhosio on 25/06/14.
 */
public class Size {

    protected Size(){
    }

    public static native Size create(double width, double height)/*-{
        return [width, height];
    }-*/;
}

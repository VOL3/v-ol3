package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Created by Mikael on 12/12/16.
 */
public class OLProjection implements Serializable {

    public String code;
    public String units;
    public double[] extent;

    public OLProjection(){}

    public OLProjection(String code, String units, double[] extent) {
        this.code = code;
        this.units = units;
        this.extent = extent;
    }

}

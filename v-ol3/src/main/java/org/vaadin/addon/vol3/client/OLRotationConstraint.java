package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Created by mjhosio on 01/07/14.
 */
public class OLRotationConstraint implements Serializable {
    // Rotation constraint. false means no constraint. true means no constraint, but snap to zero near zero.
    public boolean constrained;
    // the number of available rotations e.g. 4 = (0, 90, 180, 270 degrees)
    public Integer constrainTo;
}

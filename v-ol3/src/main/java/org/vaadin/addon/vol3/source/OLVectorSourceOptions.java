package org.vaadin.addon.vol3.source;

/**
 * Options passed to OLVectorSource on creation
 */
public class OLVectorSourceOptions extends OLSourceOptions {

    /** Sets the destination projection. If provided, features will be transformed to this projection.
     *
     * @param projection
     */
    @Override
    public void setProjection(String projection) {
        super.setProjection(projection);
    }
}

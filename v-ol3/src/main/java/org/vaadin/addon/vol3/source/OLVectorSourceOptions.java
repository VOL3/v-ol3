package org.vaadin.addon.vol3.source;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OLVectorSourceOptions extends OLSourceOptions {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /** Sets the destination projection. If provided, features will be transformed to this projection.
     *
     * @param projection
     */
    @Override
    public void setProjection(String projection) {
        super.setProjection(projection);
    }
}

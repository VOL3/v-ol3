package org.vaadin.addon.vol3.layer;

/**
 * Options that can be passed to OLTileLayer on construction time
 */
public class OLTileLayerOptions extends OLLayerOptions{
    private Integer preload;
    private Boolean useInterimTilesOnError;

    /** Gets the level to preload tiles up to
     *
     * @return
     */
    public Integer getPreload() {
        return preload;
    }

    /** Gets the level to preload tiles up to
     *
     * @param preload
     */
    public void setPreload(Integer preload) {
        this.preload = preload;
    }

    /** Returns true if interim tiles are used on error
     *
     * @return true if interim tiles are used on error
     */
    public Boolean getUseInterimTilesOnError() {
        return useInterimTilesOnError;
    }

    /** Enables / disables the usage of interim tiles on error. The default is true.
     *
     * @param useInterimTilesOnError
     */
    public void setUseInterimTilesOnError(Boolean useInterimTilesOnError) {
        this.useInterimTilesOnError = useInterimTilesOnError;
    }
}

package org.vaadin.gwtol3.client.source;

/**
 * A vector source in one of the supported formats, where the data is divided into tiles in a fixed grid pattern
 * Created by mjhosio on 07/07/14.
 */
public class TileVectorSource extends FormatVectorSource{
    protected TileVectorSource() {
    }

    public static final native TileVectorSource create() /*-{
        return new $wnd.ol.source.TileVector();
    }-*/;

    public static final native TileWMSSource create(TileVectorSourceOptions options) /*-{
        return new $wnd.ol.source.TileVector(options);
    }-*/;


}

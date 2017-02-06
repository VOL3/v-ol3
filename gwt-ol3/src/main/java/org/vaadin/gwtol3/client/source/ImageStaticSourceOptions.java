package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Extent;

/**
 * @author Mikael Grankvist - Vaadin Ltd
 */
public class ImageStaticSourceOptions extends JavaScriptObject {
  protected ImageStaticSourceOptions() {
  }

  public static native final ImageStaticSourceOptions create()/*-{
      return {};
  }-*/;

  /**
   * Sets the attributions
   *
   * @param attributions attributions
   */
  public final native void setAttributions(JsArray<Attribution> attributions)/*-{
      this.attributions = attributions;
  }-*/;

  public final native void setImageExtent(Extent imageExtent)/*-{
      this.imageExtent = imageExtent;
  }-*/;


  public native final void setProjection(String projection)/*-{
      this.projection = projection;
  }-*/;

  /**
   * Set Image URL
   *
   * @param url
   */
  public native final void setUrl(String url)/*-{
      this.url = url;
  }-*/;

}

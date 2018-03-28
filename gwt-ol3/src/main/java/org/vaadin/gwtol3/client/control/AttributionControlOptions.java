package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

public class AttributionControlOptions extends JavaScriptObject {
    protected AttributionControlOptions() {
    }

    public static final native AttributionControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-attribution
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /**
     * Specify if attributions can be collapsed. When using an OSM source,
     * should be set to false — see
     * <a href="http://www.openstreetmap.org/copyright">OSM Copyright</a> —
     * Default is true.
     *
     * @param collapsible
     *            Boolean
     */
    public final native void setCollapsible(Boolean collapsible)/*-{
       this.collapsible=collapsible;
    }-*/;

    /** Specify if attributions should be collapsed at startup. Default is true.
     *
     * @param collapsible 
     *          Boolean
     */
    public final native void setCollapsed(Boolean collapsed)/*-{
          this.collapsed=collapsed;
    }-*/;
    
    /** 
     * Text label to use for the button tip. Default is Attributions
     * @param tipLabel 
     *          String
     */
   public final native void setTipLabel(String tipLabel)/*-{
         this.tipLabel=tipLabel;
   }-*/;
   
   /** 
    * Text label to use for the collapsed attributions button. Default is i
    * @param label 
    *          String
    */
   public final native void setLabel(String label)/*-{
        this.label=label;
    }-*/;
   
   /** 
    * Text label to use for the expanded attributions button. Default is »
    * @param collapseLabel 
    *          String
    */
   public final native void setCollapseLabel(String collapseLabel)/*-{
        this.collapseLabel=collapseLabel;
    }-*/;
}

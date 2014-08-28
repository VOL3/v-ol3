package org.vaadin.addon.vol3.interaction;

import com.vaadin.shared.Connector;
import org.vaadin.addon.vol3.client.interaction.OLSelectInteractionSRPC;
import org.vaadin.addon.vol3.client.interaction.OLSelectInteractionState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mjhosio on 25/08/14.
 */
public class OLSelectInteraction extends OLInteraction {

    private List<String> selectedFeatures=new ArrayList<String>();
    private List<SelectionChangeListener> listeners=new LinkedList<SelectionChangeListener>();

    public OLSelectInteraction(){
        this(null);
    }

    public OLSelectInteraction(OLSelectInteractionOptions options){
        if(options!=null){
            if(options.getLayers()!=null){
                getState().layers=new ArrayList<Connector>();
                getState().layers.addAll(options.getLayers());
            }
            getState().featureStyles=options.getStyles();
        }
        this.registerRpc(new OLSelectInteractionSRPCImpl(),OLSelectInteractionSRPC.class);
    }

    /** Returns the ids of the currently selected features
     *
     * @return ids of the currently selected features
     */
    public List<String> getSelectedFeatures(){
        return selectedFeatures;
    }

    @Override
    protected OLSelectInteractionState getState() {
        return (OLSelectInteractionState) super.getState();
    }

    /** Removes the specified selection change listener
     *
     * @param listener
     */
    public void removeSelectionChangeListener(SelectionChangeListener listener){
        listeners.remove(listener);
    }

    /** Add listener that will be notified when the selection changes
     *
     * @param listener
     */
    public void addSelectionChangeListener(SelectionChangeListener listener){
        listeners.add(listener);
    }

    private void fireSelectionChange(){
        for(SelectionChangeListener listener : this.listeners){
            listener.selectionChanged(selectedFeatures);
        }
    }

    private final class OLSelectInteractionSRPCImpl implements OLSelectInteractionSRPC{
        @Override
        public void updateSelection(List<String> selection) {
            selectedFeatures=selection;
            fireSelectionChange();
        }
    };

    /** Listener for selection changes
     *
     */
    public interface SelectionChangeListener{
        public void selectionChanged(List<String> selectedFeatures);
    }
}

package org.vaadin.addon.vol3.util;

import com.vaadin.contextmenu.ContextMenu;
import com.vaadin.server.Resource;
import com.vaadin.ui.MenuBar;
import org.vaadin.addon.vol3.OLMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Baseclass to make context menu implementations for the map easier. Utilizes the Contextmenu add-on written by Peter Lehto.
 *
 */
public abstract class AbstractContextMenu implements OLMap.ClickListener{

	protected ContextMenu menu;
	protected OLMap map;

	private Map<MenuItem, MenuBar.MenuItem> items = new HashMap<>();

	public AbstractContextMenu(OLMap map){
		this.map=map;
		menu = new ContextMenu(map, true);

		menu.setHtmlContentAllowed(true);
		//menu.setOpenAutomatically(false);
		menu.setAsContextMenuOf(map);

		map.addClickListener(this);

	}

	protected abstract List<MenuItem> getItems(OLMap.OLClickEvent event);

	private void handleClick(MenuItem source) {
		source.getCommand().execute();
	}

	@Override
	public void onClick(OLMap.OLClickEvent clickEvent) {
		if(clickEvent.isRightClick()){
			updateItemMap(clickEvent);
			menu.open(clickEvent.getDetails().getClientX(), clickEvent.getDetails().getClientY());
		} else{
			//menu.hide();
		}
	}

	private void updateItemMap(OLMap.OLClickEvent event) {
		items.clear();
		menu.removeItems();
		for(MenuItem item : getItems(event)){
			items.put(item, menu.addItem(item.getCaption(), item.getIcon(), menuItem -> {
				item.getCommand().execute();
			}));
		}
	}

	public void detachFromMap(){
		this.map.removeExtension(menu);
		this.map.removeClickListener(this);
	}

	public interface Command {
		void execute();
	}

	public interface MenuItem {
		String getCaption();
		Resource getIcon();
		Command getCommand();
	}
}

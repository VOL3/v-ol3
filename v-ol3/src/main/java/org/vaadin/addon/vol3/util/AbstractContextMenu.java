package org.vaadin.addon.vol3.util;

import com.vaadin.server.Resource;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.peter.contextmenu.ContextMenu;

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

	private Map<MenuItem, ContextMenu.ContextMenuItem> items = new HashMap<MenuItem, ContextMenu.ContextMenuItem>();

	public AbstractContextMenu(OLMap map){
		this.map=map;
		menu=new ContextMenu();
		menu.setOpenAutomatically(false);
		menu.setAsContextMenuOf(map);
		menu.addItemClickListener(new ContextMenu.ContextMenuItemClickListener() {
			@Override
			public void contextMenuItemClicked(ContextMenu.ContextMenuItemClickEvent contextMenuItemClickEvent) {
				handleClick((ContextMenu.ContextMenuItem) contextMenuItemClickEvent.getSource());
			}
		});
		map.addClickListener(this);

	}

	protected abstract List<MenuItem> getItems(OLMap.OLClickEvent event);

	private void handleClick(ContextMenu.ContextMenuItem source) {
		for(Map.Entry<MenuItem, ContextMenu.ContextMenuItem> entry : items.entrySet()){
			if(entry.getValue().equals(source)){
				entry.getKey().getCommand().execute();
				break;
			}
		}
	}

	@Override
	public void onClick(OLMap.OLClickEvent clickEvent) {
		if(clickEvent.isRightClick()){
			updateItemMap(clickEvent);
			menu.open(clickEvent.getDetails().getClientX(), clickEvent.getDetails().getClientY());
		} else{
			menu.hide();
		}
	}

	private void updateItemMap(OLMap.OLClickEvent event) {
		items.clear();
		menu.removeAllItems();
		for(MenuItem item : getItems(event)){
			items.put(item, menu.addItem(item.getCaption(), item.getIcon()));
		}
	}

	public void detachFromMap(){
		this.map.removeExtension(menu);
		this.map.removeClickListener(this);
	}

	public interface Command {
		public void execute();
	}

	public interface MenuItem {
		public String getCaption();
		public Resource getIcon();
		public Command getCommand();
	}
}

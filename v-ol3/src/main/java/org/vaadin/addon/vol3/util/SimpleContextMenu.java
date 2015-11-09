package org.vaadin.addon.vol3.util;

import com.vaadin.server.Resource;
import org.vaadin.addon.vol3.OLMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Simple static context menu implementation
 *
 */
public class SimpleContextMenu extends AbstractContextMenu {


	private List<MenuItem> items=new ArrayList<MenuItem>();

	public SimpleContextMenu(OLMap map) {
		super(map);
	}

	@Override
	protected List<MenuItem> getItems(OLMap.OLClickEvent event) {
		return Collections.unmodifiableList(items);
	}

	public MenuItem addItem(final String caption, final Command command) {
		return addItem(caption, null, command);
	}

	public MenuItem addItem(final String caption, final Resource icon, final Command command) {
		MenuItem item = new MenuItem() {
			@Override
			public String getCaption() {
				return caption;
			}

			@Override
			public Resource getIcon() {
				return icon;
			}

			public Command getCommand() {
				return command;
			}
		};
		addItem(item);
		return item;
	}

	public void addItem(MenuItem item) {
		items.add(item);
	}

	public void removeItem(MenuItem item) {
		items.remove(item);
	}

	public void clear() {
		items.clear();
	}
}

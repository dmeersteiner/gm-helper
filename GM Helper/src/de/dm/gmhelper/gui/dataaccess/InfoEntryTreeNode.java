package de.dm.gmhelper.gui.dataaccess;

import javax.swing.tree.DefaultMutableTreeNode;

import de.dm.gmhelper.data.entry.InfoEntry;

public class InfoEntryTreeNode extends DefaultMutableTreeNode {

	public InfoEntryTreeNode(InfoEntry entry) {
		super(entry, true);
	}
}

package de.dm.gmhelper.gui.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class PopTabbedPaneRenamer {
	public static List<JMenuItem> addActionsToJPopUpMenu(JPopupMenu menu, JTabbedPane pane) {
		LinkedList<JMenuItem> list = new LinkedList<JMenuItem>();
		JMenuItem mntmRename = new JMenuItem("Rename");
		mntmRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiUtils.renameTabbedPane(pane, pane.getSelectedIndex());
			}
		});
		menu.add(mntmRename);
		list.add(mntmRename);
		
		return list;
	}
}

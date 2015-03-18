package de.dm.gmhelper.gui.util;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopTabbedPaneCloser extends JPopupMenu {
	public PopTabbedPaneCloser(JTabbedPane pane) {
		addActionsToJPopUpMenu(this, pane);
	}
	
	public static void addActionsToJPopUpMenu(JPopupMenu menu, JTabbedPane pane) {
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.remove(pane.getSelectedIndex());
			}
		});
		menu.add(mntmClose);
		
		JMenuItem mntmCloseOther = new JMenuItem("Close other");
		mntmCloseOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pane.getSelectedIndex();
				int tabCount = pane.getTabCount();
		        while (tabCount-- > 0) {
		        	if (tabCount != index) {
		        		pane.removeTabAt(tabCount);
		        	}
		        }
			}
		});
		menu.add(mntmCloseOther);
		JMenuItem mntmCloseAll = new JMenuItem("Close all");
		mntmCloseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.removeAll();
			}
		});
		menu.add(mntmCloseAll);
	}

}

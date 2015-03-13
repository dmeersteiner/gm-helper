package de.dm.gmhelper.gui.notes;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopFastNotesPane extends JPopupMenu {
	public PopFastNotesPane(JTabbedPane pane) {
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.remove(pane.getSelectedIndex());
			}
		});
		add(mntmClose);
		
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
		add(mntmCloseOther);
		JMenuItem mntmCloseAll = new JMenuItem("Close all");
		mntmCloseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.removeAll();
			}
		});
		add(mntmCloseAll);
	}

}

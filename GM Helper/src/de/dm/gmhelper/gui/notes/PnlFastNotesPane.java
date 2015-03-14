package de.dm.gmhelper.gui.notes;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.border.EmptyBorder;

import de.dm.gmhelper.data.entry.Notepad;
import de.dm.gmhelper.data.entry.NoteEntry;
import de.dm.gmhelper.gui.util.GuiUtils;
import de.dm.gmhelper.gui.util.PopTabbedPaneCloser;
import de.dm.gmhelper.gui.util.PopTabbedPaneRenamer;

public class PnlFastNotesPane extends JPanel {
	private static final long serialVersionUID = 7767440083860263676L;
	
	private JTabbedPane tbpFastNotes;
	
	/**
	 * Create the panel.
	 */
	public PnlFastNotesPane() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		tbpFastNotes = new JTabbedPane(JTabbedPane.TOP) {
			private static final long serialVersionUID = 6964156271667411537L;
			@Override
			public void removeTabAt(int index) {
				super.removeTabAt(index);
				if (getTabCount() == 0) {
					addFastNotes();
				}
			}
		};
		addFastNotes();
		tbpFastNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() > 1) {
					int index = tbpFastNotes.indexAtLocation(e.getX(), e.getY());
					e.consume();
					if (index >= 0) {
						GuiUtils.renameTabbedPane(tbpFastNotes, index);
					} else {
						addFastNotes();
					}
				}
			}
		});
		add(tbpFastNotes);
		tbpFastNotes.setComponentPopupMenu(new PopFastNotesPane());
	}
	
	public void setFastNotes(Notepad notepad) {
		tbpFastNotes.removeAll();
		for (NoteEntry entry : notepad.getNoteEntries()) {
			addFastNotes(entry);
		}
		tbpFastNotes.remove(0);
	}

	public void addFastNotes(NoteEntry entry) {
		insertFastNotesTab(entry.getTitle(), new PnlFastNotes(entry.getText()));
	}
	
	public void addFastNotes() {
		PnlFastNotes c = new PnlFastNotes();
		int counter = 1;
		while (tbpFastNotes.indexOfTab("Notes #"+counter) >= 0) {
			counter++;
		}
		insertFastNotesTab("Notes #"+counter, c);
		tbpFastNotes.setSelectedComponent(c);
		c.requestFocusInWindow();
	}
	
	private void insertFastNotesTab(String title, PnlFastNotes panel) {
		tbpFastNotes.insertTab(title, null,
				panel,
				"A notepad to take notes during the game",
				tbpFastNotes.getTabCount());
	}
	
	private class PopFastNotesPane extends JPopupMenu {
		public PopFastNotesPane() {
			JMenuItem mntmAdd = new JMenuItem("Add New Notes");
			mntmAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addFastNotes();
				}
			});
			add(mntmAdd);
			
			PopTabbedPaneRenamer.addActionsToJPopUpMenu(this, tbpFastNotes);
			
			addSeparator();
			PopTabbedPaneCloser.addActionsToJPopUpMenu(this, tbpFastNotes);
		}
	}
	
}

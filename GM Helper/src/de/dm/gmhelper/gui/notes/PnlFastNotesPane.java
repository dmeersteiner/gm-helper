package de.dm.gmhelper.gui.notes;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;

public class PnlFastNotesPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlFastNotesPane() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tbpFastNotes = new JTabbedPane(JTabbedPane.TOP) {
			@Override
			public void removeTabAt(int index) {
				super.removeTabAt(index);
				if (getTabCount() == 0) {
					addFastNotes(this);
				}
			}
		};
		addFastNotes(tbpFastNotes);
		tbpFastNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() > 1) {
					e.consume();
					addFastNotes(tbpFastNotes);
				}
			}
		});
		add(tbpFastNotes);
		tbpFastNotes.setComponentPopupMenu(new PopFastNotesPane(tbpFastNotes));
	}

	
	public static void addFastNotes(JTabbedPane pane) {
		PnlFastNotes c = new PnlFastNotes();
		pane.insertTab("Notes", null, c, "A notepad to take notes during the game", pane.getTabCount());
		pane.setSelectedComponent(c);
	}
}

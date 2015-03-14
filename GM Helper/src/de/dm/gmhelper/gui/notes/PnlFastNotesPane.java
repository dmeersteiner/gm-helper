package de.dm.gmhelper.gui.notes;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;

import de.dm.gmhelper.gui.util.PopTabbedPaneCloser;

public class PnlFastNotesPane extends JPanel {
	private static final long serialVersionUID = 7767440083860263676L;
	
	private int notesCounter = 0;
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
					notesCounter = 0;
					addFastNotes(this, notesCounter++);
				}
			}
		};
		addFastNotes(tbpFastNotes, notesCounter++);
		tbpFastNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() > 1) {
					e.consume();
					addFastNotes(tbpFastNotes, notesCounter++);
				}
			}
		});
		add(tbpFastNotes);
		tbpFastNotes.setComponentPopupMenu(new PopTabbedPaneCloser(tbpFastNotes));
	}

	
	public static void addFastNotes(JTabbedPane pane, int count) {
		PnlFastNotes c = new PnlFastNotes();
		pane.insertTab("Notes #"+(count+1), null, c, "A notepad to take notes during the game", pane.getTabCount());
		pane.setSelectedComponent(c);
		c.requestFocusInWindow();
	}
}

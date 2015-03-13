package de.dm.gmhelper.gui.notes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class PnlFastNotes extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlFastNotes() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);

	}

}

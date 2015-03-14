package de.dm.gmhelper.gui.notes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PnlFastNotes extends JPanel {
	
	private static final long serialVersionUID = -8643539965987452532L;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	public PnlFastNotes() {
		setInheritsPopupMenu(true);
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textPane.requestFocusInWindow();
			}
		});
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		textPane.setInheritsPopupMenu(true);
		scrollPane.setViewportView(textPane);
	}
	
	public PnlFastNotes(String text) {
		this();
		textPane.setText(text);
	}

}

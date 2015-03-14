package de.dm.gmhelper.gui.util;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class GuiUtils {

	public static boolean renameTabbedPane(JTabbedPane pane, int index) {
		String newTitle = JOptionPane.showInputDialog(pane, "New title:", "Rename", JOptionPane.QUESTION_MESSAGE);
		if (newTitle != null && !newTitle.trim().isEmpty()) {
			pane.setTitleAt(index, newTitle);
			return true;
		}
		return false;
	}
}

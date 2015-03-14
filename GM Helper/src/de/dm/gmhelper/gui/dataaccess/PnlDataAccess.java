package de.dm.gmhelper.gui.dataaccess;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

public class PnlDataAccess extends JPanel {

	public PnlDataAccess() {
		setLayout(new BorderLayout(0, 0));
		JSplitPane splEntries = new JSplitPane();
		splEntries.setResizeWeight(0.25);
		splEntries.setDividerSize(5);
		splEntries.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splEntries);
		
		JLabel lblTodoSearch = new JLabel("TODO: Search");
		splEntries.setLeftComponent(lblTodoSearch);
		
		JLabel lblTodoTree = new JLabel("TODO: Tree");
		splEntries.setRightComponent(lblTodoTree);
	}
}

package de.dm.gmhelper.data.info;

import java.util.List;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

class GroupPanel extends InfoPanel {
	
	private static final long serialVersionUID = 3129160916777387721L;

	private List<InfoPanel> children;

	/**
	 * gui ini 
	 * @wbp.parser.constructor
	 */
	private GroupPanel(String label) {
		setBorder(new TitledBorder(null, label, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	GroupPanel(GroupData data) {
		this(data.getLabel());
		int i = 0;
		for (InfoData child : data.getChildren()) {
			InfoPanel childPanel = child.createPanel();
			children.add(childPanel);
			
			//gui adding
			GridBagConstraints gbc_child = new GridBagConstraints();
			gbc_child.anchor = GridBagConstraints.NORTHWEST;
			gbc_child.gridx = 0;
			gbc_child.gridy = i;
			add(childPanel, gbc_child);
			i++;
		}
	}
	
	@Override
	public void save() {
		for (InfoPanel pnl : children) {
			pnl.save();
		}
	}

}

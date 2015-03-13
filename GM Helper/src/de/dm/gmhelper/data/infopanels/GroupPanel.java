package de.dm.gmhelper.data.infopanels;

import java.util.List;

public class GroupPanel extends InfoPanel {

	private List<InfoPanel> children;
	
	@Override
	public void save() {
		for (InfoPanel pnl : children) {
			pnl.save();
		}
	}

}

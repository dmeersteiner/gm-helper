package de.dm.gmhelper.data.info;

import java.util.List;

class GroupData extends InfoData {

	private static final long serialVersionUID = -559116708021808386L;
	
	private List<InfoData> children;
	
	@Override
	public InfoPanel createPanel() {
		return new GroupPanel(this);
	}

	/**
	 * @return the children {@code InfoData} elements this group holds
	 */
	public List<InfoData> getChildren() {
		return children;
	}
	
	
}

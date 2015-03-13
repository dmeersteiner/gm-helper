package de.dm.gmhelper.data.infodata;

public abstract class InfoData {

	protected String label;
	
	public InfoData() {
		this("");
	}
	
	public InfoData(String label) {
		this.label = label;
	}
}

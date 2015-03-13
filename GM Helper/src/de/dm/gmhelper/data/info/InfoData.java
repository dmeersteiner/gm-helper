package de.dm.gmhelper.data.info;

import java.io.Serializable;

public abstract class InfoData implements Serializable {

	private static final long serialVersionUID = -4049571496887332286L;
	
	private String label;
	
	public InfoData() {
		this("");
	}
	
	public InfoData(String label) {
		this.label = label;
	}
	
	public abstract InfoPanel createPanel();

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

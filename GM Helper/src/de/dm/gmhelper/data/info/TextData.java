package de.dm.gmhelper.data.info;

public abstract class TextData extends InfoData {

	private static final long serialVersionUID = 3676033185699758516L;
	
	private String text;
	private int columnlength;
	
	public TextData() {}
	
	public TextData(String label) {
		super(label);
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the columnlength
	 */
	public int getColumnlength() {
		return columnlength;
	}

	/**
	 * @param columnlength the columnlength to set
	 */
	public void setColumnlength(int columnlength) {
		this.columnlength = columnlength;
	}
}

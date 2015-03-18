package de.dm.gmhelper.data.info;

public class TextAreaData extends TextData {
	
	private int rowlength;
	
	public TextAreaData() {
		rowlength = 0;
	}
	
	public int getRowlength() {
		return rowlength;
	}

	public void setRowlength(int rowlength) {
		this.rowlength = rowlength;
	}

	@Override
	public InfoPanel createPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

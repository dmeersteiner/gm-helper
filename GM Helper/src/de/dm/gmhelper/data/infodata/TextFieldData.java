package de.dm.gmhelper.data.infodata;

public class TextFieldData extends InfoData {

	private String text;
	
	public enum Size {
		SMALL(5), MEDIUM(20), BIG(50);
		private int columlength;
		private Size(int columnlength) {
			this.columlength = columnlength;
		}
	}
}

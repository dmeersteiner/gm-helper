package de.dm.gmhelper.data.preset;

enum PanelSizeRow {
	TINY(3), SMALL(5), LARGE(15), BIG(25);
	private int size;
	private String toString;
	private PanelSizeRow(int size) {
		this.size = size;
		toString = this.name().toLowerCase()+" ("+size+")";
	}
	/**
	 * @return the columlength
	 */
	public int getSize() {
		return size;
	} 
	@Override
	public String toString() {
		return toString;
	}
}

package de.dm.gmhelper.data.preset;

enum PanelSizeColumn {
	TINY(5), SMALL(10), LARGE(20), BIG(40);
	private int size;
	private String toString;
	private PanelSizeColumn(int size) {
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

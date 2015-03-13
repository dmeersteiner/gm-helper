package de.dm.gmhelper.data.info;

public class TextFieldData extends TextData {
	
	private static final long serialVersionUID = -7874532416847564325L;

	@Override
	public InfoPanel createPanel() {
		return new TextFieldPanel(this);
	}
	
}

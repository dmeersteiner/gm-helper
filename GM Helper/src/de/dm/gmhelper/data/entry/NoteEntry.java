package de.dm.gmhelper.data.entry;

import java.io.Serializable;

public class NoteEntry implements Serializable {
	
	private String title;
	private String text;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}

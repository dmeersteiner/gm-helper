package de.dm.gmhelper.data.entry;

import java.util.LinkedList;
import java.util.List;

public class Notepad {
	
	private List<NoteEntry> noteEntries;
	
	public Notepad() {
		noteEntries = new LinkedList<NoteEntry>();
	}

	public List<NoteEntry> getNoteEntries() {
		return noteEntries;
	}

	public void setNoteEntries(List<NoteEntry> noteEntries) {
		this.noteEntries = noteEntries;
	}
	
}
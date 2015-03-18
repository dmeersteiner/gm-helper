package de.dm.gmhelper.data.entry;

import java.util.LinkedList;
import java.util.List;

public class InfoList extends InfoEntry {

	private List<InfoEntry> infoEntries;
	
	public InfoList() {
		infoEntries = new LinkedList<InfoEntry>();
	}
	
	public List<InfoEntry> getList() {
		return infoEntries;
	}
}

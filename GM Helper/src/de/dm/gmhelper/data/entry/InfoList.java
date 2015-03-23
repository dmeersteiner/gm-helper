package de.dm.gmhelper.data.entry;

import java.util.ArrayList;
import java.util.List;

public class InfoList {

	private List<InfoEntry> infoEntries;
	
	public InfoList() {
		infoEntries = new ArrayList<InfoEntry>();
	}
	
	public List<InfoEntry> getEntries() {
		return infoEntries;
	}
}

package de.dm.gmhelper.data.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.dm.gmhelper.data.info.InfoData;

public class InfoEntry implements Serializable {

	private List<InfoData> data;
	private List<KeywordEntry> keywords;
	private String label;

	public InfoEntry() {
		data = new ArrayList<InfoData>();
		keywords = new ArrayList<KeywordEntry>();
	}
	
	public List<InfoData> getData() {
		return data;
	}

	public List<KeywordEntry> getKeywords() {
		return keywords;
	}
	
	public boolean isSearched(String toMatch) {
		for (KeywordEntry keyword : keywords) {
			if (keyword.isSearched(toMatch)) return true;
		}
		return false;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

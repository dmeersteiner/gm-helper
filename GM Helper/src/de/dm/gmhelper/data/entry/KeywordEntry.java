package de.dm.gmhelper.data.entry;

import java.util.ArrayList;
import java.util.List;

public class KeywordEntry {

	private String label;
	private List<String> synonyms;
	
	public KeywordEntry() {
		synonyms = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param toMatch
	 * @return true if the keyword or any of its synonyms equals ignore case {@code toMatch}
	 */
	public boolean isSearched(String toMatch) {
		toMatch = toMatch.toLowerCase();
		if (label.toLowerCase().contains(toMatch)) return true;
		for (String s : synonyms) {
			if (s.toLowerCase().contains(toMatch)) return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((synonyms == null) ? 0 : synonyms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeywordEntry other = (KeywordEntry) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (synonyms == null) {
			if (other.synonyms != null)
				return false;
		} else if (!synonyms.equals(other.synonyms))
			return false;
		return true;
	}
	
	
}

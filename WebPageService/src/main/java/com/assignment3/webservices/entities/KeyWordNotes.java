package com.assignment3.webservices.entities;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("KeyWordNotes")
public class KeyWordNotes {
	private String keyword;
	private ArrayList<String> notes;
	/**
	 * 
	 */
	public KeyWordNotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param keyword
	 * @param notes
	 */
	public KeyWordNotes(String keyword, ArrayList<String> notes) {
		super();
		this.keyword = keyword;
		this.notes = notes;
	}
	
	
	/**
	 * @param keyword
	 */
	public KeyWordNotes(String keyword) {
		super();
		this.keyword = keyword;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "KeyWordNotes [keyword=" + keyword + ", notes=" + notes + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		KeyWordNotes other = (KeyWordNotes) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equalsIgnoreCase(other.keyword))
			return false;
		return true;
	}
	
	
}

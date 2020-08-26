package com.assignment3.searchlog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class KeyWord {

	private String keyword;
	private List<Date> searchTimeList=new ArrayList<Date>();
	private int frequency;
	
	/**
	 * @param keyword
	 * @param searchTimeList
	 * @param frequency
	 */
	public KeyWord(String keyword, List<Date> searchTimeList, int frequency) {
		super();
		this.keyword = keyword;
		this.searchTimeList = searchTimeList;
		this.frequency = frequency;
	}

	/**
	 * 
	 */
	public KeyWord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param keyword
	 */
	public KeyWord(String keyword) {
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
	 * @return the searchTimeList
	 */
	public List<Date> getSearchTimeList() {
		return searchTimeList;
	}

	/**
	 * @param searchTimeList the searchTimeList to set
	 */
	public void setSearchTimeList(List<Date> searchTimeList) {
		this.searchTimeList = searchTimeList;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "KeyWord [keyword=" + keyword + ", searchTimeList=" + searchTimeList + ", frequency=" + frequency + "]";
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
		KeyWord other = (KeyWord) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equalsIgnoreCase(other.keyword))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}

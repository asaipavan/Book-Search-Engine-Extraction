/**
 * 
 */
package com.assignment3.catalogue.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author Sai Pavan Akuralapu
 *
 */
@Component
@Document(collection = "TitleAndAuthorCollection")
public class TitleAndAuthor implements Comparable<TitleAndAuthor>{
	
	@Id
	private String id;
	private String source;
	private String year;
	private String title;
	private String author;
	private String processingstarttime;
	private String processingendtime;
	

	/**
	 * 
	 */
	public TitleAndAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param id
	 * @param source
	 * @param year
	 * @param title
	 * @param author
	 * @param processingstarttime
	 * @param processingendtime
	 */
	public TitleAndAuthor(String id, String source, String year, String title, String author,
			String processingstarttime, String processingendtime) {
		super();
		this.id = id;
		this.source = source;
		this.year = year;
		this.title = title;
		this.author = author;
		this.processingstarttime = processingstarttime;
		this.processingendtime = processingendtime;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}


	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}



	/**
	 * @return the processingstarttime
	 */
	public String getProcessingstarttime() {
		return processingstarttime;
	}



	/**
	 * @param processingstarttime the processingstarttime to set
	 */
	public void setProcessingstarttime(String processingstarttime) {
		this.processingstarttime = processingstarttime;
	}



	/**
	 * @return the processingendtime
	 */
	public String getProcessingendtime() {
		return processingendtime;
	}



	/**
	 * @param processingendtime the processingendtime to set
	 */
	public void setProcessingendtime(String processingendtime) {
		this.processingendtime = processingendtime;
	}
	
	



	@Override
	public String toString() {
		return "TitleAndAuthor [id=" + id + ", source=" + source + ", year=" + year + ", title=" + title + ", author="
				+ author + ", processingstarttime=" + processingstarttime + ", processingendtime=" + processingendtime
				+ "]";
	}



	@Override
	public int compareTo(TitleAndAuthor o) {
		// TODO Auto-generated method stub
		if (this.title.equalsIgnoreCase(o.title) && this.author.equalsIgnoreCase(o.author)) {
			return 0;
		} /*
			 * else if (this.empid < o.empid) { return 1; }
			 */ else {
			return 1;
		}
	}


	
	
	
	

}

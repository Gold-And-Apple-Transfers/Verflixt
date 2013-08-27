package org.oark.verflixt.core.search.provider;

public class SearchResult {
	
	private String title;
	private String description;
	
	public SearchResult(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//other meta data to identify result to follow

}

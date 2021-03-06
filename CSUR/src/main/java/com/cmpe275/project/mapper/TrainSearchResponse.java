package com.cmpe275.project.mapper;

import java.util.List;

public class TrainSearchResponse extends GenericResponse {

	private List<SearchResults> searchResults;
	
	private List<SearchResults> returnSearchResults;

	public List<SearchResults> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchResults> searchResults) {
		this.searchResults = searchResults;
	}

	public List<SearchResults> getReturnSearchResults() {
		return returnSearchResults;
	}

	public void setReturnSearchResults(List<SearchResults> returnSearchResults) {
		this.returnSearchResults = returnSearchResults;
	}	
}

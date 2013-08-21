package org.oark.verflixt.core.search.provider;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApifyPirateBaySourceSearch extends SourceSearchProvider {

	Logger log = LoggerFactory.getLogger(ApifyPirateBaySourceSearch.class);
	
	@Value("#{ systemProperties['apify.key'] }")
	private String apikey = "SET PROPERTY apify.key";
	
	
	@PostConstruct
	public void init() {
		log.info(ApifyPirateBaySourceSearch.class + " initialized with API KEY: " + apikey);
	}
	
	@Override
	void search(String query) {
		
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	
}

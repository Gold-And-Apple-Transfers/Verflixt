package org.oark.verflixt.core.search.provider;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class Trakt extends ContentSearchProvider {
	
	private Logger log = LoggerFactory.getLogger(Trakt.class);
	
	public static String URL_ENCODING_CHARSET = StandardCharsets.UTF_8.name();
	
	@Value("#{ systemProperties['trakt.key'] }")
	private String apikey = "SET PROPERTY trakt.key";

	private String traktBaseAPI = "http://api.trakt.tv/";
	
	private static final String FORMAT = "json";
	
	public enum SearchCategory {
		episodes("episodes"), 
		movies("movies"),
		people("people"),
		users("users"), 
		shows("shows");
		
		private String key;
		
		SearchCategory(String key) {
			this.key = key;
		}
		
		String getKey() {
			return this.key;
		}

		@Override
		public String toString() {
			return getKey();
		}
		
	}
	
	public void search(SearchCategory category, String query) {
		
	}
	
	protected String buildURI(String method, String category, String query) {
		try {
			
			query = URLEncoder.encode(query, URL_ENCODING_CHARSET);
			return traktBaseAPI + method + "/" + category + "." + FORMAT + "/" + apikey + "/" + query;
			
		} catch (UnsupportedEncodingException e) {
			// should not happen
			log.error("could not encode " + query + " in charset", e);
		}
		
		return null;
	}
	
	

}

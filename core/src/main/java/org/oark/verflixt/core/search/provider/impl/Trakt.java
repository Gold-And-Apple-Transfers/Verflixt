package org.oark.verflixt.core.search.provider.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.oark.verflixt.core.JSONReader;
import org.oark.verflixt.core.search.provider.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Trakt {
	
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
	
	public List<SearchResult> search(SearchCategory category, String query) throws IOException {
		
		String uri = buildURI("search", category.toString(), query);
		
		List<SearchResult> result = new ArrayList<SearchResult>();
		
		try {
			JSONArray jsonResult;
			jsonResult = JSONReader.readJsonFromUrl(uri);

			for (int i = 0; i < jsonResult.length(); i++) {
				JSONObject item = jsonResult.getJSONObject(i);
				SearchResult src = new SearchResult(item.getString("title"),item.getString("tagline"));
				
				this.log.debug("found : " + src.getTitle());
				
				result.add(src);
			}
			
		} catch (JSONException e) {
			throw new IOException(e);
		}
		
		return result;
	}
	
	protected String buildURI(String method, String category, String query) {
		try {
			
			query = URLEncoder.encode(query, URL_ENCODING_CHARSET);
			return getTraktBaseAPI() + method + "/" + category + "." + FORMAT + "/" + getApikey() + "/" + query;
			
		} catch (UnsupportedEncodingException e) {
			// should not happen
			log.error("could not encode " + query + " in charset", e);
		}
		
		return null;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getTraktBaseAPI() {
		return traktBaseAPI;
	}

	public void setTraktBaseAPI(String traktBaseAPI) {
		this.traktBaseAPI = traktBaseAPI;
	}
	
}

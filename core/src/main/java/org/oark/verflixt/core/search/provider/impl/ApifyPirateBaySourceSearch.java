package org.oark.verflixt.core.search.provider.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.oark.verflixt.core.JSONReader;
import org.oark.verflixt.core.search.provider.ContentSource;
import org.oark.verflixt.core.search.provider.SourceSearchProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApifyPirateBaySourceSearch extends SourceSearchProvider {

	private Logger log = LoggerFactory.getLogger(ApifyPirateBaySourceSearch.class);
	
	public static String URL_ENCODING_CHARSET = StandardCharsets.UTF_8.name();
	
	@Value("#{ systemProperties['apify.key'] }")
	private String apikey = "SET PROPERTY apify.key";

	private String tpbServiceBase = "http://apify.ifc0nfig.com/tpb/";

	@PostConstruct
	public void init() {
		log.info(ApifyPirateBaySourceSearch.class
				+ " initialized with API KEY: " + apikey);
	}

	@Override
	public List<ContentSource> search(String query) throws IOException {
		
		List<ContentSource> result = new ArrayList<ContentSource>();
		
		try {
			JSONArray jsonResult;
			jsonResult = JSONReader.readJsonFromUrl(buildURI(query));

			for (int i = 0; i < jsonResult.length(); i++) {
				JSONObject item = jsonResult.getJSONObject(i);
				TorrentSource src = new TorrentSource(new Date(),
						item.getString("name"), item.getString("magnet"),
						item.getInt("seeders"), item.getInt("leechers"));
				
				this.log.debug("found : " + src.getName() + "(" + src.getURI() + ")");
				
				result.add(src);
			}
			
		} catch (JSONException e) {
			throw new IOException(e);
		}
		
		return result;

	}

	protected String buildURI(String query) {
		
		try {
			query = URLEncoder.encode(query, URL_ENCODING_CHARSET);
			return getTpbServiceBase() + "search?id=" + query + "&key=" + apikey;
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

	public String getTpbServiceBase() {
		return tpbServiceBase;
	}

	public void setTpbServiceBase(String tpbServiceBase) {
		this.tpbServiceBase = tpbServiceBase;
	}
}

package org.oark.verflixt.core.search.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApifyPirateBaySourceSearch extends SourceSearchProvider {

	private Logger log = LoggerFactory.getLogger(ApifyPirateBaySourceSearch.class);

	@Value("#{ systemProperties['apify.key'] }")
	private String apikey = "SET PROPERTY apify.key";

	private String tpbService = "http://apify.ifc0nfig.com/tpb/";

	@PostConstruct
	public void init() {
		log.info(ApifyPirateBaySourceSearch.class
				+ " initialized with API KEY: " + apikey);
	}

	@Override
	List<ContentSource> search(String query) throws IOException {
		
		List<ContentSource> result = new ArrayList<ContentSource>();
		
		try {
			JSONArray jsonResult;
			jsonResult = readJsonFromUrl(buildURI(query));

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
		return tpbService + "search?id=" + query + "&key=" + apikey;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONArray readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

}

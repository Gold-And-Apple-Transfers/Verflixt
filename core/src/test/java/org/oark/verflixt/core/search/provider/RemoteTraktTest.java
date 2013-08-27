package org.oark.verflixt.core.search.provider;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.oark.verflixt.core.search.provider.impl.Trakt;
import org.oark.verflixt.core.search.provider.impl.Trakt.SearchCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml"})
public class RemoteTraktTest {

	private static String TEST_BASE = "http://api.trakt.tv/";
	
	@Autowired
	private Trakt trakt;
	
	@Before
	public void setBaseURI() {
		getTrakt().setTraktBaseAPI(TEST_BASE);
	}
	
	@Ignore
	public void searchTest() throws IOException {
		List<SearchResult> result = trakt.search(SearchCategory.movies, "Godfather");
		assertFalse(result.isEmpty());
	}

	public Trakt getTrakt() {
		return trakt;
	}

	public void setTrakt(Trakt trakt) {
		this.trakt = trakt;
	}
	
}

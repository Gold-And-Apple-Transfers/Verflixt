package org.oark.verflixt.core.search.provider;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml"})
public class TraktTest {

	@Autowired
	public Trakt trakt;
	
	private static String TEST_KEY = "deadbeefdeadbeefdeadbeefdeadbeef";
	private static String TEST_BASE = "http://api.trakt.tv/";
	
	@Before
	public void setBaseURI() {
		trakt.setTraktBaseAPI(TEST_BASE);
	}
	
	@Before 
	public void setTestkey() {
		trakt.setApikey(TEST_KEY);
	}
	
	@Test
	public void apiKey() {
		assertEquals(TEST_KEY, trakt.getApikey());
	}
	
	@Test				
	public void buildURITest() {
		
		String testURL;
		
		testURL = trakt.buildURI("search", Trakt.SearchCategory.movies.toString(), "Se7en");
		assertEquals(TEST_BASE + "search/movies.json/" + TEST_KEY + "/" + "Se7en", testURL);
		
		//TODO add more tests see ApifyPirateBaySourceSearchTest for examples
	}
	
	

}

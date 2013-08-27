package org.oark.verflixt.core.search.provider.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oark.verflixt.core.search.provider.impl.ApifyPirateBaySourceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml"})
public class ApifyPirateBaySourceSearchTest {

	@Autowired
	public ApifyPirateBaySourceSearch apifyPirateBaySourceSearch;
	
	private static String TEST_KEY = "deadbeefdeadbeefdeadbeefdeadbeef";
	private static String TEST_BASE = "http://apify.ifc0nfig.com/tpb/";
	
	@Before
	public void setBaseURI() {
		apifyPirateBaySourceSearch.setTpbServiceBase(TEST_BASE);
	}
	
	@Before 
	public void setTestkey() {
		apifyPirateBaySourceSearch.setApikey(TEST_KEY);
	}
	
	@Test
	public void apiKey() {
		assertEquals(TEST_KEY, apifyPirateBaySourceSearch.getApikey());
	}
	
	@Test				
	public void buildURITest() {
		
		String testURL;
		
		testURL = apifyPirateBaySourceSearch.buildURI("Se7en");
		assertEquals(TEST_BASE + "search?id=Se7en&key="+TEST_KEY, testURL);
		
		testURL = apifyPirateBaySourceSearch.buildURI("The Godfather");
		assertEquals(TEST_BASE + "search?id=The+Godfather&key="+TEST_KEY, testURL);
		
		testURL = apifyPirateBaySourceSearch.buildURI("Rear Window (1954)");
		assertEquals(TEST_BASE + "search?id=Rear+Window+%281954%29&key="+TEST_KEY, testURL);
		
		testURL = apifyPirateBaySourceSearch.buildURI("Léon: The Professional");
		assertEquals(TEST_BASE + "search?id=L%C3%A9on%3A+The+Professional&key="+TEST_KEY, testURL);
	}
}

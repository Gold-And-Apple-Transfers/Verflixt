package org.oark.verflixt.core.search.provider;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.oark.verflixt.core.storage.provider.DirectoryListing;
import org.oark.verflixt.core.storage.provider.SimpleStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml"})

public class SimpleStorageTest {
	@Autowired
	private SimpleStorage simpleStorage;
	
	@Test
	public void search() {
	}
	
	@Test
	public void write() {
	}
	
	@Test
	public void read() {
	}
}

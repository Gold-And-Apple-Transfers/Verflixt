package org.oark.verflixt.core.content.provider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.oark.verflixt.core.search.provider.ContentSource;

public class PutIO implements ContentProvider {

	private final Set<String> supportedTypes = new HashSet<String>(Arrays.asList(new String[] { "1", "2", "5" }));
	
	@Override
	public Set<String> supportedTypes() {
		return supportedTypes;
	}

	@Override
	public boolean getContent(ContentSource src, ContentCallback cb) {
		// TODO Auto-generated method stub
		return false;
	}

}

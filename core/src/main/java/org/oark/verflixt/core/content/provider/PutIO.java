package org.oark.verflixt.core.content.provider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.oark.verflixt.core.content.provider.exceptions.ContentTypeNotSupportedException;
import org.oark.verflixt.core.search.provider.ContentSource;

public class PutIO implements ContentProvider {

	private final Set<String> supportedTypes = new HashSet<String>(Arrays.asList(new String[] { "torrent" }));
	
	@Override
	public Set<String> supportedTypes() {
		return supportedTypes;
	}

	@Override
	public void getContent(ContentSource src, ContentCallback cb) throws ContentTypeNotSupportedException {
		// TODO Auto-generated method stub
	}

}

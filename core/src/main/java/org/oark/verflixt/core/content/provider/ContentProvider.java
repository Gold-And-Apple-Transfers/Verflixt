package org.oark.verflixt.core.content.provider;

import java.util.Set;

import org.oark.verflixt.core.search.provider.ContentSource;

public interface ContentProvider {

	Set<String> supportedTypes();
	
	boolean getContent(ContentSource src, ContentCallback cb);
		
}

package org.oark.verflixt.core.content.provider;

import org.oark.verflixt.core.search.provider.ContentSource;

public interface ContentCallback {

	public void finished(ContentSource src);
	public void failed(ContentSource src);
}

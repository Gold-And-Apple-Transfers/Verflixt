package org.oark.verflixt.core.storage.provider;

import java.io.InputStream;

import javax.naming.directory.SearchResult;

public interface StorageProvider {
	public boolean write(InputStream input, Origin origin);
	public boolean read(SimpleStorageEntity entity);
	public SearchResult search(SearchTerm term);
}

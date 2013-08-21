package org.oark.verflixt.core.storage.provider;

import java.io.InputStream;

public interface StorageProvider {
	public boolean write(InputStream input, String target);
	public boolean delete(String target);
	public boolean read(String source);
	public DirectoryListing ls(String root);
}

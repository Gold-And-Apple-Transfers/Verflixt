package org.oark.verflixt.core.storage.provider;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleStorage implements StorageProvider {
	@Autowired
	private File storagePath;

	public boolean write(InputStream input, String target) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean read(String source) {
		// TODO Auto-generated method stub
		return false;
	}

	public DirectoryListing ls(String root) {
		File absoluteRoot = new File(storagePath, root);
		
		return null;
	}

	public File getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(File storagePath) {
		this.storagePath = storagePath;
	}
}

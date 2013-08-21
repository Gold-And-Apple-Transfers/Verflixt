package org.oark.verflixt.core.storage.provider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleStorage implements StorageProvider {
	
	private static Logger log = LoggerFactory.getLogger(SimpleStorage.class);

	private String storagePath;
	private File storage;
	
	@PostConstruct
	public void init() throws FileNotFoundException {
		this.storage = new File(storagePath);
		if (! storage.exists())
			throw new FileNotFoundException();
		log.info("initialized with path " + storagePath);
	}
	
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

	public DirectoryListing ls(String root) throws FileNotFoundException {
		File absoluteRoot = new File(storagePath, root);
		if (! absoluteRoot.exists())
			throw new FileNotFoundException();
		return new DirectoryListing(storagePath, absoluteRoot.list());
	}

	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
}

package org.oark.verflixt.core.storage.provider;

import java.util.ArrayList;

public class DirectoryListing {
	private ArrayList<String> listing;

	public DirectoryListing(String root, String[] list) {
		for (String file : list)
			listing.add(file.replace(root, "/"));
	}

	public ArrayList<String> getContent() {
		return listing;
	}

}

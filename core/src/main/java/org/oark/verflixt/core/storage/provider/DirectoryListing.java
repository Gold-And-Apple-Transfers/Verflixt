package org.oark.verflixt.core.storage.provider;

import java.util.ArrayList;

public class DirectoryListing {
	private ArrayList<String> listing;

	public DirectoryListing(String root, String[] list) {
		listing = new ArrayList<String>(list.length);
		for (String file : list)
			listing.add(file.replace(root, "/"));
	}

	public ArrayList<String> getContents() {
		return listing;
	}

}

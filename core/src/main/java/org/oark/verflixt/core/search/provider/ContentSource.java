package org.oark.verflixt.core.search.provider;

import java.net.URI;
import java.net.URISyntaxException;

public interface ContentSource {

	public abstract String getType();

	public abstract URI getURI();

	public abstract String getName();

}
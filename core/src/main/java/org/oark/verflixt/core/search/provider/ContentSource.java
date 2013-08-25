package org.oark.verflixt.core.search.provider;

import java.net.URI;

public interface ContentSource {

	public abstract String getType();

	public abstract URI getURI();

	public abstract String getName();

}
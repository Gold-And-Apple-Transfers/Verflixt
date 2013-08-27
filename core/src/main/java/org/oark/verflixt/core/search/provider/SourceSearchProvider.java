package org.oark.verflixt.core.search.provider;

import java.io.IOException;
import java.util.List;

abstract public class SourceSearchProvider extends SearchProvider{

	abstract public List<ContentSource> search(String query) throws IOException;

}

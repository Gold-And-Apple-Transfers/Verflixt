package org.oark.verflixt.core.search.provider;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TorrentSource implements ContentSource {
	
	Logger log = LoggerFactory.getLogger(TorrentSource.class);
	
	private Date timestamp;
	
	private String name;
	private String magnet;
	
	private int seeder;
	private int leecher;

	public static final String TYPE = "torrent";
	
	/* (non-Javadoc)
	 * @see org.oark.verflixt.core.search.provider.ContentSource#getType()
	 */
	@Override
	public String getType() {
		return TorrentSource.TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.oark.verflixt.core.search.provider.ContentSource#getURI()
	 */
	@Override
	public URI getURI() {
		try {
			return new URI(magnet);
		} catch (URISyntaxException e) {
			log.warn("could not create URI for source " + this.name );
			return null;
		}
	}
	
	public TorrentSource(Date timestamp, String name, String magnet,
			int seeder, int leecher) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.magnet = magnet;
		this.seeder = seeder;
		this.leecher = leecher;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see org.oark.verflixt.core.search.provider.ContentSource#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMagnet() {
		return magnet;
	}
	public void setMagnet(String magnet) {
		this.magnet = magnet;
	}
	public int getSeeder() {
		return seeder;
	}
	public void setSeeder(int seeder) {
		this.seeder = seeder;
	}
	public int getLeecher() {
		return leecher;
	}
	public void setLeecher(int leecher) {
		this.leecher = leecher;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}

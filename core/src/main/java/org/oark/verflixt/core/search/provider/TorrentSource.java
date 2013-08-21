package org.oark.verflixt.core.search.provider;

import java.util.Date;

public class TorrentSource {
	
	private Date timestamp;
	
	private String name;
	private String magnet;
	
	private int seeder;
	private int leecher;
	
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
}

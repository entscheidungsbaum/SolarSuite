package com.entscheidungsbaum.android.solarMonitor.utilities;

import java.util.Map;

public class MapStoredEntity {

	private long timestamp=0L;
	
	private Map<String,String> m;
	
	public MapStoredEntity(Map<String,String> map) {
		m = map;
		timestamp = System.currentTimeMillis();
	}
	
	public String get(String key) {
		return m.get(key);
	}
	
	protected void put(String key,String value) {
		m.put(key,value);
	}
	
	public int getAgeSeconds() {
		return (int) ((System.currentTimeMillis() - timestamp)/1000);
	}
	
}

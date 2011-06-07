package com.entscheidungsbaum.android.solarMonitor.datasource;

/**
 * @author mschlech
 *
 * DBConstants
 */

public interface DBConstants {
	 
	static final int DATABASE_VERSION = 2;
    
	static final String SOLAR_TABLE_NAME = "dictionary";
    
	static final String INSERT = "insert into " + DBConstants.SOLAR_TABLE_NAME + "(name) values (?)";
     
     
}

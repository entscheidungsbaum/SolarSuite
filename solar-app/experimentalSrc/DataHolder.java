package com.entscheidungsbaum.android.solarMonitor.services;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author mschlech
 *
 * DataHolder
 */

public class DataHolder {

	@XStreamAsAttribute
	private String data ;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}

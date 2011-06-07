package com.entscheidungsbaum.android.solarMonitor.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author mschlech
 * 
 *         XmlApiReply
 */

@XStreamAlias("xml_api_reply")
public class XmlApiReply {

	public XmlApiReply() {
		
	}
	
	@XStreamAlias("xml_api_reply")
	private List<Weather> xml_api_reply;

	public List<Weather> getXml_api_reply() {
		return xml_api_reply;
	}

	public void setWeather(ArrayList<Weather> xml_api_reply) {
		this.xml_api_reply = xml_api_reply;
	}

	public XmlApiReply(Weather xml_api_reply, Weather ... xmlApiReply) {
		this.xml_api_reply = Arrays.asList(xml_api_reply);
	}
}

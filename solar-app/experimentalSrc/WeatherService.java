package com.entscheidungsbaum.android.solarMonitor.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;

import android.util.Log;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.mapper.AnnotationMapper;

/**
 * @author mschlech
 * 
 *         WeatherService
 */

public class WeatherService {

	private String weatherApiUrl = "http://www.google.com/ig/api?weather=";

	private String defaultCity = "Duisburg";

	public void getActualWeatherSimple() {
		Map<String, String> m = getWeatherInfo(defaultCity);
		Log.d("m weather = ", m.toString());
	}

	
	
	
	private Map<String, String> getWeatherInfo(String city) {

		Log.d("GET WEATHER INFO for = ", city);

		Map<String, String> weatherInfo = new HashMap<String, String>();

		HttpParams hp = new BasicHttpParams();
		hp.setParameter(CoreConnectionPNames.SO_TIMEOUT, "1000");
		HttpClient hc = new DefaultHttpClient();

		if (city == "") {
			city = defaultCity;
			Log.d("city = ", city + " URL ");
		}

		try {
			String httpAdrToInvoke = weatherApiUrl + city;
			Log.d("the Concatenated url ", httpAdrToInvoke);
			
			String url = httpAdrToInvoke.replace(" ", "%20");
			Log.d("start to fetch ", " url " + url);
			XStream xs = initXstrem();
			HttpResponse hresponse = hc.execute(new HttpGet(url));
			FileInputStream fis = new FileInputStream("/sdcard/api.xml");
			
			InputStream in = (hresponse.getEntity().getContent());
			xs.processAnnotations(XmlApiReply.class);
			xs.processAnnotations(Weather.class);
			xs.processAnnotations(DataHolder.class);
	//		xs.addImplicitCollection(ForecastConditions.class, "condition");
			
			xs.alias("city", DataHolder.class);
			
			xs.alias("postal_code", DataHolder.class);
			
			xs.alias("latitude_e6", DataHolder.class);
			
			xs.alias("longitude_e6", DataHolder.class);

			xs.alias("forecast_date", DataHolder.class);

			xs.alias("latitude_e6", DataHolder.class);

			xs.alias("current_date_time", DataHolder.class);
	
			xs.alias("unit_system", DataHolder.class);
		
			xs.alias("icon", DataHolder.class);
			
			xs.alias("aCondition", DataHolder.class);
			
			xs.alias("temp_f", DataHolder.class);
			
			xs.alias("temp_c", DataHolder.class);
			
			xs.alias("humidity", DataHolder.class);
			
			xs.alias("wind_condition",DataHolder.class);
			
			xs.alias("day_of_week", DataHolder.class);
			
			xs.alias("low", DataHolder.class);
			
			xs.alias("high", DataHolder.class);
			
			
			Log.d(" WEATHER -> ", xs.toString());
			Log.d("xs ", " WEATHER " + xs.getMapper().toString());

			//Log.d("xs ", " XML WEATHER " + xs.fromXML(in).toString());
			
			// Weather weather = (Weather) xs.fromXML(in);
			 XmlApiReply xmlApiReply = (XmlApiReply)xs.fromXML(fis);
			 xmlApiReply.toString();

			 Log.d("xs ", " XML WEATHER " + xmlApiReply.toString());

			 BufferedReader rd = new BufferedReader(new InputStreamReader(fis));
			String line = "";
			while ((line = rd.readLine()) != null) {
				Log.d("Buffered Reader ", line);
			}
			// Log.d("WEATHER", weather.toString());
			// weatherInfo.put("city", weather.toString());

			// Log.d("the httpResponse ", in.toString());

			// Log.d("the httpResponse ",
			// hresponse.getEntity().getContent().toString());
		} catch (Exception ioe) {
			Log.e("WeatherService ", " exception=>", ioe);
		}

		return weatherInfo;
	}

	/**
	 * 
	 * @return Xstream instance
	 */
	private XStream initXstrem() {
		Dom4JDriver jdomDriver = new Dom4JDriver();
		XStream xstream = new XStream(jdomDriver);
		JVM jvm = new JVM();
		AnnotationMapper am = new AnnotationMapper(xstream.getMapper(),
				(ConverterRegistry) xstream.getConverterLookup(), xstream.getClassLoader(),
				xstream.getReflectionProvider(), jvm);
		xstream = new XStream(xstream.getReflectionProvider(), jdomDriver, xstream.getClassLoader(), am);
		return xstream;
	}
}

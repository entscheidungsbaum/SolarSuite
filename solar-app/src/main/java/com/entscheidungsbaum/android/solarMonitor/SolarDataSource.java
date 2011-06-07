package com.entscheidungsbaum.android.solarMonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mschlech fetches data from the datasource for prototyping purposes
 *         static fields
 * 
 *         Datasource must be static stateless SolarDataSource
 */

public class SolarDataSource {

	/**
	 * the temperature sensor section in celsius
	 */
	static final double tempSensor1 = 23.9;

	static final double tempSensor2 = 13.9;

	static final double tempSensor3 = 24.9;

	static final double tempSensor4 = 23.121;

	static final double tempSensor5 = 20.19;

	static final double tempSensor6 = 12.9;

	/**
	 * volume stream m^3/h
	 */
	static final double volStream = 54.4;

	/**
	 * insulation W/qm
	 */
	static final double insulation = 5;

	/**
	 * rpm m/s
	 */
	static final double rpm = 10;

	/**
	 * operating hours h
	 */
	static final long operatingHours = 1234556677;

	public static Map<String, Number> getData() {

		Map<String, Number> DATA = new HashMap<String, Number>();

		DATA.put("tempSensor1", tempSensor1);
		DATA.put("tempSensor2", tempSensor2);
		DATA.put("tempSensor3", tempSensor3);
		DATA.put("tempSensor4", tempSensor4);
		DATA.put("tempSensor5", tempSensor5);
		DATA.put("tempSensor6", tempSensor6);
		DATA.put("volStream", volStream);
		DATA.put("insulation", insulation);
		DATA.put("rpm", rpm);
		DATA.put("operatingHours", operatingHours);
		return DATA;

	}

	public static ArrayList<String> getDataArray() {
		ArrayList<String> DATA = new ArrayList<String>();
		DATA.add(1, String.valueOf(tempSensor1));
		DATA.add(2, String.valueOf(tempSensor2));
		DATA.add(3, String.valueOf(tempSensor3));
		DATA.add(4, String.valueOf(tempSensor4));
		DATA.add(5, String.valueOf(tempSensor5));
		DATA.add(6, String.valueOf(tempSensor6));
		DATA.add(7, String.valueOf(volStream));
		DATA.add(8, String.valueOf(insulation));
		DATA.add(9, String.valueOf(rpm));
		DATA.add(10, String.valueOf(operatingHours));
		return DATA;
	}
}

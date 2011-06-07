package com.entscheidungsbaum.android.solarMonitor.utilities;

import java.sql.Date;
import java.util.Map;

/**
 * @author mschlech
 * 
 *         SensorMapper like Team class
 */

public class SensorMapper extends MapStoredEntity implements CsvDeserializable {

	public SensorMapper(Map<String, String> map) {
		super(map);
	}

	//@Override
	public String[] getSerializationKeys() {
		return new String[] { "datum", "temperaturSensor1", "temperaturSensor2", "temperaturSensor1",
				"temperaturSensor5", "temperaturSensor7", "temperaturSensor8", "volumenstrom", "einstrahlung",
				"drehzahl1", "drehzahl2", "drehzahl3", "relais4", "relais5", "relais6", "systemzeit",
				"kollektorkuehlung", "kollektorkuehlung", "kollektorminimalbegrenzung", "roehrenkollektorfunktion",
				"rueckkuehlung", "waermemengenzaehlung", "betriebsstunden1", "betriebsstunden2", "betriebsstunden3",
				"betriebsstunden4", "betriebsstunden5", "betriebsstunden6", "waermemenge" };
	}

	public int getId() {
		return Integer.parseInt(get("id"));
	}

	public String getDatum() {
		return get("datum");
		
	}

    
	public double getTemperaturSensor1() {
		return Double.valueOf("temperaturSensor1");
	}

	public double getTemperaturSensor2() {
		return Double.valueOf("temperaturSensor2");
	}


}

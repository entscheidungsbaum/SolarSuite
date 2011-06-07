package com.entscheidungsbaum.android.solarMonitor.utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import android.text.TextUtils;

public class CsvDeserializer {

	private char separator = '\t';

	public CsvDeserializer(char _separator) {
		separator = _separator;
	}

	/**
	 * @param what
	 *            the separator-separated string
	 * @param object
	 *            dummy object of the deserializable class, i.e. new Player()
	 * @return a map with the found values
	 */
	public Map<String, String> deserialize(String what, CsvDeserializable object) {
		Map<String, String> result = new HashMap<String, String>();

		// get the keys from the deserializable object
		String[] keys = object.getSerializationKeys();

		// split the input string by the separators
		TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(separator);
		splitter.setString(what);
		int i = 0;
		// }
		// String line = "";
		// while(line) {
		//
		// }

		while (splitter.hasNext()) {
			// get the next value from the input
			String value = splitter.next();
			if (value != null) {
				if ("null".equals(value)) {
					result.put(keys[i], null);
				} else {
					result.put(keys[i], value.trim());
				}
			}
			i++;
			if (i >= keys.length) {
				// we must stop here, because we have no more keys.
				break;
			}
		}
		return result;
	}
}

// }

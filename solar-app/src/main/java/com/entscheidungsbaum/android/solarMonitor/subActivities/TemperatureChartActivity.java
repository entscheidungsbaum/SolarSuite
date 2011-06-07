package com.entscheidungsbaum.android.solarMonitor.subActivities;

import android.app.Activity;
import android.os.Bundle;

import com.entscheidungsbaum.android.solarMonitor.view.TemperatureChart;
import com.entscheidungsbaum.android.solarMonitor.view.XYLineChart;


/**
 * @author mschlech
 *
 * TemperatureChartActivity
 */

public class TemperatureChartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(new TemperatureChart(this));
	}

	
	
}

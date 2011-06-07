package com.entscheidungsbaum.android.solarMonitor.subActivities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.entscheidungsbaum.android.solarMonitor.R;
import com.entscheidungsbaum.android.solarMonitor.SolarButton;
import com.entscheidungsbaum.android.solarMonitor.SolarLauncher;

/**
 * @author mschlech
 * 
 *         SolarOperatingHours
 */

public class SolarOperatingHours extends Activity implements SolarLauncher {


	private static final int[] icon_mapping = { -1, R.id.icon_1, R.id.icon_2, R.id.icon_3};

	private static final int[] innerIcon_mapping = { -1, R.drawable.temperature_icon, R.drawable.volumestream_icon,
			R.drawable.back_icon };

	private static final String[] text_mapping = { "", "Sensor selection", "Diagram", "Back" };
	View mView;

	int index = icon_mapping.length-1;

	@Override
	public void onClick(SolarButton launcherButton,Bundle bundle) {
		Log.d("Activity", "SolarOperatingHours");
	}


	@Override
	public boolean onLongClick(SolarButton launcherButton, Bundle bundle) {
		// TODO Auto-generated method stub
		return false;
	}

}

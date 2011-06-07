package com.entscheidungsbaum.android.solarMonitor;

import android.os.Bundle;

/**
 * @author mschlech
 *
 * SolarLauncher provides two gestures for all activities 
 */

public interface SolarLauncher {

	public void onClick(SolarButton launcherButton, Bundle bundle);

	public boolean onLongClick(SolarButton launcherButton,  Bundle bundle);

	
}

package com.entscheidungsbaum.android.solarMonitor.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author mschlech
 * 
 *         HttpSolarDataFetcherService fetches a requested dataset from the
 *         server to be persisted in internal SQLite
 */

public class HttpSolarDataFetcherService extends Service {
	private HttpSolarDataFetcherService httpInstance;
	boolean hasStarted = false;

	private HttpSolarDataFetcherService(Context context) {
	}

	/**
	 * singelton not to be implemented but implement it as a service
	 * 
	 * @param context
	 * @return
	 */
	// public static HttpSolarDataFetcherService getInstance(Context context) {
	// if (httpInstance == null) {
	// httpInstance = new HttpSolarDataFetcherService(context);
	// }
	//
	// return httpInstance;
	// }

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		if (httpInstance != null)
		{
			
			hasStarted = true;
			hasStarted(hasStarted);
		}
			
	}

	public boolean hasStarted(boolean started) {
		return started;
	}
	
}

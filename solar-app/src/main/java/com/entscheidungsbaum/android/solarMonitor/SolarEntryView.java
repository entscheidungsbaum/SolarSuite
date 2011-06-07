package com.entscheidungsbaum.android.solarMonitor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author mschlech
 * 
 *         SolarEntryView
 */

public class SolarEntryView extends LinearLayout {

	private TextView mSensor1, mSensor2, mSensor3, mSensor4, mSensor5, mSensor6, mRpm, mInsulation, mVolstream,
			mOperatingHours;

	public SolarEntryView(Context context, SensorBean sensorBean) {
		super(context);

		this.setOrientation(VERTICAL);
		mSensor1 = new TextView(context);
		mSensor2 = new TextView(context);
		mSensor3 = new TextView(context);
		mSensor4 = new TextView(context);
		mSensor5 = new TextView(context);
		mSensor6 = new TextView(context);
		mRpm = new TextView(context);
		mInsulation = new TextView(context);
		mVolstream = new TextView(context);
		mOperatingHours = new TextView(context);

		String sensor1 = String.valueOf(sensorBean.getTempSensor1());
		mSensor1.setText(sensor1);
		setTextView(mSensor1);

		String sensor2 = String.valueOf(sensorBean.getTempSensor2());
		mSensor2.setText(sensor2);
		setTextView(mSensor2);

		String sensor3 = String.valueOf(sensorBean.getTempSensor3());
		mSensor3.setText(sensor3);
		setTextView(mSensor3);

		String sensor4 = String.valueOf(sensorBean.getTempSensor4());
		mSensor4.setText(sensor4);
		setTextView(mSensor4);

		String sensor5 = String.valueOf(sensorBean.getTempSensor5());
		mSensor5.setText(sensor5);
		setTextView(mSensor5);

		String sensor6 = String.valueOf(sensorBean.getTempSensor6());
		mSensor6.setText(sensor6);
		setTextView(mSensor6);

		String rpm = String.valueOf(sensorBean.getTempSensor2());
		mRpm.setText(rpm);
		setTextView(mRpm);

		String insulation = String.valueOf(sensorBean.getTempSensor2());
		mRpm.setText(insulation);
		setTextView(mInsulation);

		String operatingHours = String.valueOf(sensorBean.getTempSensor2());
		mRpm.setText(operatingHours);
		setTextView(mOperatingHours);

		addView(mSensor1, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mSensor2, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mSensor3, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mSensor4, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mSensor5, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mSensor6, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		addView(mRpm, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mInsulation, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mOperatingHours, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

	}

	public String getmSensor1() {
		return mSensor1.getText().toString();
	}


	public void setmSensor1(String mSensor1) {
		this.mSensor1.setText(mSensor1);
	}


	public String getmSensor2() {
		return mSensor2.getText().toString();
	}


	public void setmSensor2(String mSensor2) {
		this.mSensor2.setText(mSensor2);
	}


	public String getmSensor3() {
		return mSensor3.getText().toString();
	}


	public void setmSensor3(String mSensor3) {
		this.mSensor3.setText(mSensor3);
	}


	public String getmSensor4() {
		return mSensor4.getText().toString();
	}


	public void setmSensor4(String mSensor4) {
		this.mSensor4.setText(mSensor4);
	}


	public String getmSensor5() {
		return mSensor5.getText().toString();
	}


	public void setmSensor5(String mSensor5) {
		this.mSensor5.setText(mSensor5);
	}


	public String getmSensor6() {
		return mSensor6.getText().toString();
	}


	public void setmSensor6(String mSensor6) {
		this.mSensor6.setText(mSensor6);
	}


	public String getmRpm() {
		return mRpm.getText().toString();
	}


	public void setmRpm(String mRpm) {
		this.mRpm.setText(mRpm);
	}


	public String getmInsulation() {
		return mInsulation.getText().toString();
	}


	public void setmInsulation(String mInsulation) {
		this.mInsulation.setText(mInsulation);
	}


	public String getmVolstream() {
		return mVolstream.getText().toString();
	}



	public void setmVolstream(String mVolstream) {
		this.mVolstream.setText(mVolstream);
	}



	public String getmOperatingHours() {
		return mOperatingHours.getText().toString();
	}



	public void setmOperatingHours(String mOperatingHours) {
		this.mOperatingHours.setText(mOperatingHours);
	}



	/**
	 * 
	 */
	private void setTextView(TextView aTextView) {
		aTextView.setTextSize(19);
		aTextView.setTextColor(Color.BLACK);
		aTextView.setTypeface(Typeface.SANS_SERIF);
	}

}

package com.entscheidungsbaum.android.solarMonitor;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author mschlech
 * 
 *         SolarButton
 */

public class SolarButton implements OnClickListener, OnLongClickListener {
	private View fView;
	private int fPosition;

	private SolarLauncher fListener;

	public SolarButton(View v, int position) {
		fView = v;
		fPosition = position;
		fView.setEnabled(false);

	}
	
	/**
	 * the position of the button
	 * @return Integer representation of the position of the button
	 */
	public int getPosition() {
		return fPosition;
	}

	/**
	 * the text which the button describes
	 * @param text
	 */
	public void setText(String text) {
		((TextView)fView.findViewById(R.id.label)).setText(text);
	}
	
	/**
	 * sets the icon of the button
	 * @param d
	 */
	public void setIcon(Drawable d) {
		((ImageView)fView.findViewById(R.id.image)).setImageDrawable(d);
		fView.setEnabled(true);
	}
	
	/**
	 * set the icon of the button
	 * @param resID
	 */
	public void setIcon(int resID) {
		((ImageView)fView.findViewById(R.id.image)).setImageResource(resID);
		fView.setEnabled(true);
	}
	
	/**
	 * receiving click and long click events
	 * @param l
	 */
	public void setButtonListener(SolarLauncher l) {
		fView.setOnClickListener(this);
		fView.setOnLongClickListener(this);
		fListener = l;
	}

	/**
	 * changes the state 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		fView.setEnabled(enabled);
	}
	
	
	
	@Override
	public boolean onLongClick(View aView) {
		if (fListener != null) {
			
			return fListener.onLongClick(null, null);
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		if (fListener != null) {
			fListener.onClick(this,null);
		}
	}

}

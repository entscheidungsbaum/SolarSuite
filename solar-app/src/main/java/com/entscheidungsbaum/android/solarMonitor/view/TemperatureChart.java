package com.entscheidungsbaum.android.solarMonitor.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import net.droidsolutions.droidcharts.awt.Rectangle2D;
import net.droidsolutions.droidcharts.core.ChartFactory;
import net.droidsolutions.droidcharts.core.JFreeChart;
import net.droidsolutions.droidcharts.core.axis.CategoryAxis;
import net.droidsolutions.droidcharts.core.axis.CategoryLabelPositions;
import net.droidsolutions.droidcharts.core.axis.NumberAxis;
import net.droidsolutions.droidcharts.core.data.CategoryDataset;
import net.droidsolutions.droidcharts.core.data.DefaultCategoryDataset;
import net.droidsolutions.droidcharts.core.data.XYDataset;
import net.droidsolutions.droidcharts.core.data.general.Dataset;
import net.droidsolutions.droidcharts.core.data.xy.XYSeries;
import net.droidsolutions.droidcharts.core.data.xy.XYSeriesCollection;
import net.droidsolutions.droidcharts.core.plot.CategoryPlot;
import net.droidsolutions.droidcharts.core.plot.PlotOrientation;
import net.droidsolutions.droidcharts.core.plot.XYPlot;
import net.droidsolutions.droidcharts.core.renderer.category.LineAndShapeRenderer;
import net.droidsolutions.droidcharts.core.renderer.xy.XYLineAndShapeRenderer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.entscheidungsbaum.android.solarMonitor.SensorBean;
import com.entscheidungsbaum.android.solarMonitor.utilities.CsvDeserializer;
import com.entscheidungsbaum.android.solarMonitor.utilities.SensorMapper;

/**
 * @author mschlech
 * 
 *         TemperatureChart
 */

public class TemperatureChart extends View {

	String file = "/sdcard/TextData_20110329.log.csv";

	private final Rect mRect = new Rect();

	private final Handler mHandler;

	public TemperatureChart(Context context) {
		super(context);

		mHandler = new Handler();
		/**
		 * for development purposes
		 */
		this.doSerialize();
	}

	public TemperatureChart(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mHandler = new Handler();
		// register our interest in hearing about changes to our surface
		this.doSerialize();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.getClipBounds(mRect);

		final XYDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		chart.draw(canvas, new Rectangle2D.Double(0, 0, mRect.width(), mRect.height()));
		Paint p = new Paint();
		p.setColor(Color.RED);
	}

	/**
	 * Schedule a user interface repaint.
	 */
	public void repaint() {
		mHandler.post(new Runnable() {
			public void run() {
				invalidate();
			}
		});
	}

	/**
	 * 
	 * @return
	 */
	private XYDataset createDataset() {

		final XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries xySeries = new XYSeries("tempSensor");
		List<SensorMapper> sst = this.startSerialization();
		double dTest = 1.0;
		for (SensorMapper sstl : sst) {
			xySeries.add(Double.valueOf(dTest), Double.valueOf(sstl.get("temperaturSensor1")));
			dTest += 1.0;
		}

		dataset.addSeries(xySeries);
		return dataset;
	}

	/**
	 * 
	 * @param dataset
	 * @return JFreeChart object
	 */
	private JFreeChart createChart(final XYDataset dataset) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createXYLineChart("Temperature1", // chart
				// title
				"Hour", // x axis label
				"Temp", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
				);

		Paint white = new Paint(Paint.ANTI_ALIAS_FLAG);
		white.setColor(Color.WHITE);

		Paint dkGray = new Paint(Paint.ANTI_ALIAS_FLAG);
		dkGray.setColor(Color.DKGRAY);

		Paint lightGray = new Paint(Paint.ANTI_ALIAS_FLAG);
		lightGray.setColor(Color.LTGRAY);
		lightGray.setStrokeWidth(10);

		chart.setBackgroundPaint(white);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(dkGray);
		plot.setDomainGridlinePaint(lightGray);
		plot.setRangeGridlinePaint(lightGray);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

	/**
	 * development purposes
	 */
	private void doSerialize() {
		List<SensorMapper> sst = this.startSerialization();

		for (SensorMapper ssts : sst) {
			Log.d("ssts ", " {" + ssts.get("temperaturSensor1") + " }");
		}

	}

	/**
	 * 
	 * @return List of SerializerTest
	 * 
	 */

	private List<SensorMapper> startSerialization() {

		char seperator = '\t';
		CsvDeserializer cd = new CsvDeserializer(seperator);
		List<SensorMapper> ls = new ArrayList<SensorMapper>();
		BufferedReader br = null;
		Map<String, String> m = null;

		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			int i = 0;
			while ((line = br.readLine()) != null) {

				m = cd.deserialize(line, new SensorMapper(null));
				if (i++ > 0)
					ls.add(new SensorMapper(m));
			}
		} catch (FileNotFoundException ex) {
			Log.e("FileNotFoundException", ex.getMessage());
		} catch (IOException ex) {
			Log.e("IOException", ex.getMessage());
		}
		return ls;

	}

}
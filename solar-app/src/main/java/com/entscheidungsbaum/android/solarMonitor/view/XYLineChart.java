package com.entscheidungsbaum.android.solarMonitor.view;

import net.droidsolutions.droidcharts.awt.Rectangle2D;
import net.droidsolutions.droidcharts.core.ChartFactory;
import net.droidsolutions.droidcharts.core.JFreeChart;
import net.droidsolutions.droidcharts.core.axis.NumberAxis;
import net.droidsolutions.droidcharts.core.data.XYDataset;
import net.droidsolutions.droidcharts.core.data.xy.XYSeries;
import net.droidsolutions.droidcharts.core.data.xy.XYSeriesCollection;
import net.droidsolutions.droidcharts.core.plot.PlotOrientation;
import net.droidsolutions.droidcharts.core.plot.XYPlot;
import net.droidsolutions.droidcharts.core.renderer.xy.XYLineAndShapeRenderer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;

public class XYLineChart extends View {
	/** The view bounds. */
	private final Rect mRect = new Rect();
	/** The user interface thread handler. */
	private final Handler mHandler;

	/**
	 * Creates a new graphical view.
	 * 
	 * @param context
	 *            the context
	 * @param chart
	 *            the chart to be drawn
	 */
	public XYLineChart(Context context) {
		super(context);
		mHandler = new Handler();
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

	private XYDataset createDataset() {
		final XYSeries series1 = new XYSeries("Rain");
		series1.add(1.0, 1.0);
		series1.add(2.0, 4.0);
		series1.add(3.0, 3.0);
		series1.add(4.0, 5.0);
		series1.add(5.0, 5.0);
		series1.add(6.0, 7.0);
		series1.add(7.0, 7.0);
		series1.add(8.0, 8.0);

		final XYSeries series2 = new XYSeries("Sunshine");
		series2.add(1.0, 5.0);
		series2.add(2.0, 7.0);
		series2.add(3.0, 6.0);
		series2.add(4.0, 8.0);
		series2.add(5.0, 4.0);
		series2.add(6.0, 4.0);
		series2.add(7.0, 2.0);
		series2.add(8.0, 1.0);

		final XYSeries series3 = new XYSeries("Apples");
		series3.add(3.0, 4.0);
		series3.add(4.0, 3.0);
		series3.add(5.0, 2.0);
		series3.add(6.0, 3.0);
		series3.add(7.0, 6.0);
		series3.add(8.0, 3.0);
		series3.add(9.0, 4.0);
		series3.add(10.0, 3.0);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		return dataset;
	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final XYDataset dataset) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createXYLineChart("Apple Yield", // chart
				// title
				"Days", // x axis label
				"Growth", // y axis label
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
}

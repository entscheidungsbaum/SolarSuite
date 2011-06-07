package com.entscheidungsbaum.android.solarMonitor.view;

/**
 * @author mschlech
 *
 * LineChartExampleView
 */

import net.droidsolutions.droidcharts.awt.Rectangle2D;
import net.droidsolutions.droidcharts.core.ChartFactory;
import net.droidsolutions.droidcharts.core.JFreeChart;
import net.droidsolutions.droidcharts.core.axis.CategoryAxis;
import net.droidsolutions.droidcharts.core.axis.CategoryLabelPositions;
import net.droidsolutions.droidcharts.core.axis.NumberAxis;
import net.droidsolutions.droidcharts.core.data.CategoryDataset;
import net.droidsolutions.droidcharts.core.data.DefaultCategoryDataset;
import net.droidsolutions.droidcharts.core.plot.CategoryPlot;
import net.droidsolutions.droidcharts.core.plot.PlotOrientation;
import net.droidsolutions.droidcharts.core.renderer.category.LineAndShapeRenderer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;

public class LineChartExampleView extends View {
	/** The view bounds. */
	private Rect mRect = new Rect();
	/** The user interface thread handler. */
	private Handler mHandler;

	/**
	 * Creates a new graphical view.
	 * 
	 * @param context
	 *            the context
	 * @param chart
	 *            the chart to be drawn
	 */
	public LineChartExampleView(Context context) {
		super(context);
		mHandler = new Handler();
	}

	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);
		canvas.getClipBounds(mRect);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		chart.draw(canvas, new Rectangle2D.Double(0, 0, mRect.width(), mRect
				.height()));
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
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private CategoryDataset createDataset() {

		// row keys...
		final String series1 = "First";
		final String series2 = "Second";
		final String series3 = "Third";

		// column keys...
		final String type1 = "Type 1";
		final String type2 = "Type 2";
		final String type3 = "Type 3";
		final String type4 = "Type 4";
		final String type5 = "Type 5";
		final String type6 = "Type 6";
		final String type7 = "Type 7";
		final String type8 = "Type 8";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, series1, type1);
		dataset.addValue(4.0, series1, type2);
		dataset.addValue(3.0, series1, type3);
		dataset.addValue(5.0, series1, type4);
		dataset.addValue(5.0, series1, type5);
		dataset.addValue(7.0, series1, type6);
		dataset.addValue(7.0, series1, type7);
		dataset.addValue(8.0, series1, type8);

		dataset.addValue(5.0, series2, type1);
		dataset.addValue(7.0, series2, type2);
		dataset.addValue(6.0, series2, type3);
		dataset.addValue(8.0, series2, type4);
		dataset.addValue(4.0, series2, type5);
		dataset.addValue(4.0, series2, type6);
		dataset.addValue(2.0, series2, type7);
		dataset.addValue(1.0, series2, type8);

		dataset.addValue(4.0, series3, type1);
		dataset.addValue(3.0, series3, type2);
		dataset.addValue(2.0, series3, type3);
		dataset.addValue(3.0, series3, type4);
		dataset.addValue(6.0, series3, type5);
		dataset.addValue(3.0, series3, type6);
		dataset.addValue(4.0, series3, type7);
		dataset.addValue(3.0, series3, type8);

		return dataset;

	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createLineChart(
				"Line Chart Demo 5", // chart title
				"Type", // domain axis label
				"Value", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
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

		final CategoryPlot plot = chart.getCategoryPlot();

		plot.setBackgroundPaint(dkGray);
		plot.setDomainGridlinePaint(lightGray);
		plot.setRangeGridlinePaint(lightGray);
		plot.setDomainGridlinesVisible(true);

		chart.setBackgroundPaint(white);

		// set the stroke for each series...


		Paint blue = new Paint(Paint.ANTI_ALIAS_FLAG);
		blue.setColor(Color.rgb(125, 138, 46));
		// blue.set
		blue.setAlpha(200);
		blue.setStrokeWidth(10);
		Paint green = new Paint(Paint.ANTI_ALIAS_FLAG);
		green.setColor(Color.rgb(255, 240, 165));
		green.setAlpha(200);

		Paint red = new Paint(Paint.ANTI_ALIAS_FLAG);
		red.setColor(Color.rgb(182, 73, 38));
		red.setAlpha(200);

		plot.getRenderer().setSeriesPaint(0, blue);
		plot.getRenderer().setSeriesPaint(1, green);
		plot.getRenderer().setSeriesPaint(2, red);

		// customise the renderer...
		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();
		renderer.setItemLabelsVisible(true);
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesShapesVisible(2, true);

		// customise the range axis...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		rangeAxis.setUpperMargin(0.12);
		rangeAxis.setLabelAngle(90);

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		return chart;

	}

}

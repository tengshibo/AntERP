package com.anterp.tm.chart;

import java.awt.Color;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.springframework.stereotype.Service;

@Service
public class ChartTestService {

	public XYDataset createDataset_Eg2() {
		TimeSeries ts = new TimeSeries("A's Temperature");
		ts.add(new Day(1, 6, 2012), 36.5);
		ts.add(new Day(2, 6, 2012), 36.35);
		ts.add(new Day(3, 6, 2012), 36.58);
		ts.add(new Day(4, 6, 2012), 36.4);
		ts.add(new Day(5, 6, 2012), 36.5);
		ts.add(new Day(6, 6, 2012), 36.35);
		ts.add(new Day(7, 6, 2012), 36.58);
		ts.add(new Day(8, 6, 2012), 36.4);

		TimeSeriesCollection tsc = new TimeSeriesCollection();
		tsc.addSeries(ts);
		return tsc;
	}

	public JFreeChart createJFreeChart_Eg2(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Base Body Temperature", "Date", "Temperature", dataset, true,
				true, false);
		chart.setBackgroundPaint(Color.WHITE);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
		}
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));
		return chart;
	}

}

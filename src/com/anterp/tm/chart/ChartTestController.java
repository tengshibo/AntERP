package com.anterp.tm.chart;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/chart")
public class ChartTestController {

	@Autowired
	private ChartTestService chartTestService;

	@RequestMapping("/eg1")
	public void showEg1(HttpServletRequest request, HttpServletResponse response) {
		OutputStream ous = null;
		try {
			ous = response.getOutputStream();
			DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
			dataSet.addValue(10.0, "S1", "C1");
			dataSet.addValue(12.0, "S2", "C1");

			JFreeChart chart = ChartFactory.createBarChart("Bar Chart",
					"Category", "Value", dataSet, PlotOrientation.VERTICAL,
					true, false, true);
			response.setContentType("image/png");
			ChartUtilities.writeChartAsPNG(ous, chart, 400, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/eg2")
	public void showEg2(HttpServletRequest request, HttpServletResponse response) {
		OutputStream ous = null;
		try {
			ous = response.getOutputStream();
			
			XYDataset dataset = this.chartTestService.createDataset_Eg2();
			JFreeChart chart = this.chartTestService
					.createJFreeChart_Eg2(dataset);
			
			response.setContentType("image/png");
			ChartUtilities.writeChartAsPNG(ous, chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

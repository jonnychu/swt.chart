package cn.nextop.chart.model.builder;

import org.eclipse.swt.graphics.Color;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.config.theme.TraceTheme;
import cn.nextop.chart.model.render.axis.Axis;
import cn.nextop.chart.model.render.axis.XAxis;
import cn.nextop.chart.model.render.axis.YAxis;
import cn.nextop.chart.model.render.trace.Trace;

public class LightChartBuilder {
	//
	protected Trace trace;
	protected LightChart chart;
	
	/**
	 * 
	 */
	public LightChartBuilder(LightChart chart) {
		this.chart = chart;
	}
	
	/**
	 * 
	 */
	public Trace build() { return trace; }
	
	public LightChartBuilder trace() { trace(null, null); return this; }
	
	public LightChartBuilder trace(String xPartten, String yPartten) {
		Axis x = new XAxis(xPartten); chart.addAxis(x); 
		Axis y = new YAxis(yPartten); chart.addAxis(y);
		x.setMajor(chart.getMajorAxis(true) == null);
		y.setMajor(chart.getMajorAxis(false) == null);
		this.trace = new Trace(x, y); chart.addTrace(trace); return this;
	}
	
	/**
	 * Trace
	 */
	public LightChartBuilder name(String name) {
		TraceTheme theme = this.trace.getTheme(); theme.setName(name); return this;
	}
	
	public LightChartBuilder width(int width) {
		TraceTheme theme = this.trace.getTheme(); theme.setLineWidth(width); return this;
	}
	
	public LightChartBuilder color(Color color) {
		TraceTheme theme = this.trace.getTheme(); theme.setLineColor(color); return this;
	}
}

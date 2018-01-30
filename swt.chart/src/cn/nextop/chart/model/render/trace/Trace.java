package cn.nextop.chart.model.render.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.config.theme.TraceTheme;
import cn.nextop.chart.model.render.axis.Axis;

public class Trace extends Figure {
	//
	protected final Axis xAxis;
	protected final Axis yAxis;
	protected LightChart chart;
	protected TraceTheme theme;
	protected List<TraceData> hotTrace;
	
	/**
	 * 
	 */
	public Trace(Axis xAxis,Axis yAxis) {
		this.theme = new TraceTheme();
		this.hotTrace = new ArrayList<>();
		this.xAxis = xAxis; this.yAxis = yAxis;
		this.xAxis.setTrace(this); this.yAxis.setTrace(this);
	}
	
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g); hotTrace.clear();
		LightChartModel model = this.chart.getModel();
		final List<TraceData> datas = model.getDatas(this);
		//
		final PointList ps = new PointList();
		for (TraceData data : datas) {
			int x1 = xAxis.getPositionByValue(data.getX());
			int y1 = yAxis.getPositionByValue(data.getY());
			ps.addPoint(x1, y1); hotTrace.add(data);
		}
		g.pushState(); g.setForegroundColor(theme.getLineColor());
		g.setLineWidth(theme.getLineWidth()); g.drawPolyline(ps); g.popState();
	}

	/**
	 * 
	 */
	public Axis getXAxis() {
		return xAxis;
	}

	public Axis getYAxis() {
		return yAxis;
	}
	
	public LightChart getChart() {
		return chart;
	}

	public void setChart(LightChart chart) {
		this.chart = chart;
	}

	public TraceTheme getTheme() {
		return theme;
	}

	public void setTheme(TraceTheme theme) {
		this.theme = theme;
	}
}

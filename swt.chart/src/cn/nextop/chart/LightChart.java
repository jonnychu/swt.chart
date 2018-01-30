package cn.nextop.chart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.swt.widgets.Display;

import cn.nextop.chart.action.IReactor;
import cn.nextop.chart.action.actor.DefaultRector;
import cn.nextop.chart.action.impl.FeedAction;
import cn.nextop.chart.action.impl.FeedExAction;
import cn.nextop.chart.action.impl.LayoutAction;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.render.axis.Axis;
import cn.nextop.chart.model.render.grid.Grid;
import cn.nextop.chart.model.render.plot.PoltArea;
import cn.nextop.chart.model.render.trace.Trace;

public class LightChart extends Figure {
	//
	protected PoltArea polt;
	protected Display display;
	protected IReactor reactor;
	protected LightChartModel model;
	protected final List<Axis> xAxes = new ArrayList<>();
	protected final List<Axis> yAxes = new ArrayList<>();
	
	/**
	 * 
	 */
	public LightChart(Display display) {
		this.display = display;
		this.model = new LightChartModel();
		add(this.polt = new PoltArea(this));
		this.reactor = new DefaultRector(this);
	}
	
	/**
	 * 
	 */
	@Override
	protected void layout() {
		super.layout(); reactor.submit(new LayoutAction());
	}
	
	/**
	 * 
	 */
	public void add(Trace trace, TraceData data) {
		reactor.submit(new FeedExAction(trace, data));
	}
	
	public void feed(Trace trace, List<TraceData> datas) {
		reactor.submit(new FeedAction(trace, datas));
	}
	
	/**
	 * 
	 */
	public void addTrace(Trace trace) {
		if(trace == null) return; trace.setChart(this);
		this.polt.addTrace(trace); revalidate(); repaint();
	}
	
	public void addAxis(Axis axis) {
		if(axis == null) return;
		if (axis.isVertical()) yAxes.add(axis);
		else xAxes.add(axis); axis.setChart(this); add(axis);
		this.polt.addGrid(new Grid(axis)); revalidate();
	}
	
	public Axis getMajorAxis(boolean isXAxis) {
		final List<Axis> axes = new ArrayList<>();
		if(isXAxis) axes.addAll(this.xAxes); else axes.addAll(this.yAxes);
		for (Axis axis : axes) { if (axis.isMajor()) return axis; } return null;
	}
	
	/**
	 * 
	 */
	public PoltArea getPolt() {
		return polt;
	}

	public List<Axis> getxAxes() {
		return xAxes;
	}

	public List<Axis> getyAxes() {
		return yAxes;
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
	
	public LightChartModel getModel() {
		return model;
	}

	public void setModel(LightChartModel model) {
		this.model = model;
	}
}

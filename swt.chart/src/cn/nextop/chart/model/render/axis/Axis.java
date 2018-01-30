package cn.nextop.chart.model.render.axis;

import static cn.nextop.chart.support.glossary.Orientation.HORIZONTAL;
import static cn.nextop.chart.support.util.ChartUtils.getAbsMax;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.render.trace.Trace;
import cn.nextop.chart.support.Range;
import cn.nextop.chart.support.glossary.Orientation;
import cn.nextop.chart.support.glossary.TimeLine;
import cn.nextop.chart.support.util.GUtils;
import cn.nextop.chart.support.util.TimeUtils;

/**
 * 
 */
public abstract class Axis extends Figure {
	//
	protected int length;
	protected Range range;
	protected Trace trace;
	protected boolean major;
	protected String pattern;
	protected Format formater;
	protected LightChart chart;
	protected Orientation orientation;
	//
	protected final static int MARGIN = 20;
	protected final static int TICK_LENGTH = 10;
	
	/**
	 * 
	 */
	public Axis(Orientation orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * 
	 */
	public Trace getTrace() {
		return trace;
	}

	public void setTrace(Trace trace) {
		this.trace = trace;
	}
	
	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public LightChart getChart() {
		return chart;
	}

	public void setChart(LightChart chart) {
		this.chart = chart;
	}
	
	/**
	 * 
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
	}
	
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		if(!isVertical()) length = rect.width; else length = rect.height;
	}
	
	/**
	 * 
	 */
	public boolean isMajor() { return major; }

	public void setMajor(boolean major) { this.major = major; }
	
	public String format(Object obj) { return this.formater.format(obj); }
	
	public boolean isVertical() {
		if(this.orientation == HORIZONTAL) return false; else return true;
	}
	
	/**
	 * 
	 */
	public double getValueByPosition(int position) {
		return getPreciseValueByPosition((int)position);
	}
	
	public double getPreciseValueByPosition(double position) {
		double pixelsToStart;
		double min = range.getLower(), max = range.getUpper();
		if (!isVertical()) pixelsToStart = position - bounds.x;
		else pixelsToStart = length + bounds.y - position;
		double f = getAbsMax(min, max);	max /= f; min /= f;	double t = max - min;
		return ((pixelsToStart - MARGIN) / (length - 2d * MARGIN) * t + min) * f;
	}
	
//	public List<Integer> getMarkPosition(List<TraceData> datas) {
//		final List<Integer> r = new ArrayList<>();
//		final int dh = 30; int maxPosition = 0, minPosition = this.length;
//		for (TraceData data : datas) {
//			final int next = getPositionByValue(data.getY());
//			if(maxPosition < next) { maxPosition = next; }
//			if(minPosition > next) { minPosition = next; }
//		}
//		do {
//			r.add(maxPosition);
//		} while (minPosition < (maxPosition -= dh)); return r;
//	}
	
	public List<Integer> getMarkPosition(List<TraceData> datas) {
		final List<Integer> r = new ArrayList<>();
		final int dh = 30; int maxPosition = 0, minPosition = this.length;
		for (TraceData data : datas) {
			final int next = getPositionByValue(data.getY());
			if(maxPosition < next) { maxPosition = next; }
			if(minPosition > next) { minPosition = next; }
		} System.out.println(this.length +", "+minPosition+","+maxPosition);
		do {
			r.add(maxPosition);
		} while (minPosition < (maxPosition -= dh));
		
		//
		if(r.size() == 0) return r; int lp = r.get(r.size() - 1); if(lp > dh) r.add(lp - dh); return r;
	}
	
	/**
	 * 
	 */
	public int getPositionByValue(double value) {
		return (int)Math.round(getPrecisePositionByValue(value));
	}
	
	protected double getPrecisePositionByValue(double value) {
		double min = range.getLower(), max = range.getUpper();
		double f = getAbsMax(min, max); max /= f; min /= f; double t = max - min; 
		double pixelsToStart = ((value / f - min) / t * ((double) length - MARGIN * 2d) + MARGIN);
		//
		if (!isVertical()) return pixelsToStart + bounds.x;
		else return length - pixelsToStart + bounds.y;
	}
	
	public List<Double> getMarkValue(List<TraceData> datas) {
		final List<Double> r = new ArrayList<>();
		Dimension dw = GUtils.getDateExtents(); int width; TimeLine timeLine = TimeLine.SEC10;
		do {
			width = 0; timeLine = timeLine.next(timeLine);
			for (TraceData data : datas) {
				if(TimeUtils.isMark((long)data.getX(), timeLine)) { width += dw.width; }
			}
		} while (width > this.length);
		// get all position
		for (TraceData data : datas) {
			if(TimeUtils.isMark((long)data.getX(), timeLine)) {	r.add(data.getX());	}
		}
		return r;
	}
}

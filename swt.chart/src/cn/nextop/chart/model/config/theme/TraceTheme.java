package cn.nextop.chart.model.config.theme;

import org.eclipse.swt.graphics.Color;

import cn.nextop.chart.support.util.Colors;

public class TraceTheme {
	//
	protected String name;
	protected int lineWidth;
	protected Color lineColor;
	
	/**
	 * 
	 */
	public TraceTheme() {
		this.lineWidth = 1;
		this.name = "TraceName";
		this.lineColor = Colors.COLOR_BLACK;
	}
	
	/**
	 * 
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
}

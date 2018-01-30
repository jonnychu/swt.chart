package cn.nextop.chart.model.config.theme;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import cn.nextop.chart.support.util.Colors;

public class GridTheme {
	//
	protected int lineWidth;
	protected int lineStyle;
	protected Color lineColor;
	
	/**
	 * 
	 */
	public GridTheme() {
		this.lineWidth = 1;
		this.lineStyle = SWT.LINE_DASH;
		this.lineColor = Colors.getColor(200, 200, 200);
	}
	
	/**
	 * 
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public int getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
}

package cn.nextop.chart.model.config.theme;

import org.eclipse.swt.graphics.Color;

import cn.nextop.chart.support.util.Colors;

public class PoltAreaTheme {
	//
	protected boolean drawRect;
	protected Color backgroundColor;
	
	/**
	 * 
	 */
	public PoltAreaTheme() {
		this.drawRect = false;
		this.backgroundColor = Colors.COLOR_WHITE;
	}
	
	/**
	 * 
	 */
	public boolean isDrawRect() {
		return drawRect;
	}

	public void setDrawRect(boolean drawRect) {
		this.drawRect = drawRect;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}

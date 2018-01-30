package cn.nextop.chart.action;

import cn.nextop.chart.LightChart;

/**
 * 
 */
public interface IAction {
	
	/**
	 * 
	 */
	Type getType();
	
	Object apply(LightChart table);
	
	/**
	 * 
	 */
	enum Type { FEED, LAYOUT; }
}

package cn.nextop.chart.model.config;

import cn.nextop.chart.model.config.layout.DefaultLayout;

public class LightChartConfig {
	//
	protected DefaultLayout layout;
	
	/**
	 * 
	 */
	public LightChartConfig() {
		layout = new DefaultLayout();
	}

	/**
	 * 
	 */
	public DefaultLayout getLayout() {
		return layout;
	}

	public void setLayout(DefaultLayout layout) {
		this.layout = layout;
	}
}

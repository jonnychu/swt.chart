package cn.nextop.chart.action.impl;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.config.LightChartConfig;
import cn.nextop.chart.model.config.layout.DefaultLayout;

/**
 * @author jonny
 */
public class LayoutAction extends AbstractAction {

	public LayoutAction() {
		super(Type.LAYOUT);
	}

	@Override
	public Boolean apply(LightChart chart) {
		LightChartModel model = chart.getModel();
		LightChartConfig config = model.getConfig();
		final DefaultLayout layout = config.getLayout(); 
		layout.layout(chart); chart.repaint(); return true;
	}
}

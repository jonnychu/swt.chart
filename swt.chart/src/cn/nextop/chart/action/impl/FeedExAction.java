package cn.nextop.chart.action.impl;

import static cn.nextop.chart.support.util.ChartUtils.getDataRange;

import java.util.List;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.render.trace.Trace;
import cn.nextop.chart.support.Range;

/**
 * @author jonny
 */
public class FeedExAction extends AbstractAction {
	//
	private Trace trace;
	private TraceData data;
	
	/**
	 * 
	 */
	public FeedExAction(Trace trace, TraceData data) {
		super(Type.FEED); this.data = data; this.trace = trace;
	}

	@Override
	public Boolean apply(LightChart chart) {
		if(this.data == null) return false;
		
		//
		final LightChartModel model = chart.getModel();
		model.addData(trace, data); List<TraceData> datas = model.getDatas(trace);
		Range[] range = getDataRange(datas); this.trace.getXAxis().setRange(range[0]);
		this.trace.getYAxis().setRange(range[1]); chart.repaint(); return true;
	}
}

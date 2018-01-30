package cn.nextop.chart.action.impl;

import static cn.nextop.chart.support.util.ChartUtils.getDataRange;

import java.util.ArrayList;
import java.util.List;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.render.trace.Trace;
import cn.nextop.chart.support.Range;

/**
 * @author jonny
 */
public class FeedAction extends AbstractAction {
	//
	private Trace trace;
	private List<TraceData> datas;
	
	/**
	 * 
	 */
	public FeedAction(Trace trace, List<TraceData> datas) {
		super(Type.FEED); this.datas = datas; this.trace = trace;
	}

	@Override
	public Boolean apply(LightChart chart) {
		if(this.datas == null || this.datas.isEmpty()) return false;
		
		//
		final LightChartModel model = chart.getModel();
		final List<TraceData> r = new ArrayList<>(this.datas);
		Range[] range = getDataRange(this.datas); this.trace.getXAxis().setRange(range[0]);
		this.trace.getYAxis().setRange(range[1]); model.setDatas(trace, r); chart.repaint(); return true;
	}
}

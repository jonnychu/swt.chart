package cn.nextop.chart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.config.LightChartConfig;
import cn.nextop.chart.model.render.trace.Trace;

public class LightChartModel {
	//
	protected LightChartConfig config;
	protected Map<Trace, List<TraceData>> datas;
	
	/**
	 * 
	 */
	public LightChartModel() {
		this.datas = new HashMap<>(0);
		this.config = new LightChartConfig();
	}
	
	/**
	 * 
	 */
	public LightChartConfig getConfig() {
		return config;
	}

	public void setConfig(LightChartConfig config) {
		this.config = config;
	}

	/**
	 * 
	 */
	public List<TraceData> getDatas(Trace key) {
		List<TraceData> r = this.datas.get(key); if(r == null) 
		{ r = new ArrayList<>(); this.datas.put(key, r); } return r;
	}
	
	public void addData(Trace key, TraceData data) {
		List<TraceData> r = this.datas.get(key); if(r == null) 
		{ r = new ArrayList<>(); this.datas.put(key, r); } r.add(data);
	}
	
	public void addDatas(Trace key, List<TraceData> datas) {
		List<TraceData> r = this.datas.get(key); if(r == null) 
		{ r = new ArrayList<>(); this.datas.put(key, r); } r.addAll(datas);
	}
	
	public void setDatas(Trace key, List<TraceData> datas) {
		List<TraceData> r = new ArrayList<>(); r.addAll(datas); this.datas.put(key, r);
	}
}

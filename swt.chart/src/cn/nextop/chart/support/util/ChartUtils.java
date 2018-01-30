package cn.nextop.chart.support.util;

import java.util.Collection;

import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.support.Range;

public class ChartUtils {
	
	/**
	 * 
	 */
	public static double getAbsMax(double v1, double v2) {
		return Math.max(Math.abs(v1), Math.abs(v2));
	}
	
	/**
	 * 
	 */
	public static Range[] getDataRange(Collection<TraceData> datas) {
		if(datas.size() == 0) return null;
		double minX = Double.POSITIVE_INFINITY, minY = Double.POSITIVE_INFINITY;
		double maxX = Double.NEGATIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY;
		for (TraceData data : datas) {
			double x = data.getX(), y = data.getY();
			if(minX > x) minX = x; if(maxX < x) maxX = x;
			if(minY > y) minY = y; if(maxY < y) maxY = y; 
		}
		return new Range[] {new Range(minX, maxX), new Range(minY, maxY)};
	}
}

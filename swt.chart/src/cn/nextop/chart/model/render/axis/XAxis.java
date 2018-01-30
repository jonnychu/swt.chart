package cn.nextop.chart.model.render.axis;

import java.text.SimpleDateFormat;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.support.glossary.Orientation;
import cn.nextop.chart.support.util.GUtils;

@SuppressWarnings("unused")
public class XAxis extends Axis {
	/**
	 * 
	 */
	public XAxis(String partten) { 
		super(Orientation.HORIZONTAL);
		if(partten == null) this.pattern = "HH:mm"; 
		else this.pattern = partten; formater = new SimpleDateFormat(this.pattern);
	}
	
	/**
	 * 
	 */
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g); Rectangle rect = getClientArea();
		final LightChartModel model = this.chart.getModel();
		final List<TraceData> datas = model.getDatas(this.getTrace());
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		if(!isMajor() || datas == null || datas.size() == 0) return; g.drawLine(x + MARGIN, y, x + w - MARGIN, y);
		//
		final List<Double> values = getMarkValue(datas);
		for (Double v : values) {
			final int next = getPositionByValue(v);	g.drawLine(next, y, next, y + TICK_LENGTH);
			GUtils.drawXAxisText(g, formater.format(v.longValue()), next, y + TICK_LENGTH, null);
		}
	}
}

package cn.nextop.chart.model.render.axis;

import java.text.DecimalFormat;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.support.glossary.Orientation;
import cn.nextop.chart.support.util.GUtils;

@SuppressWarnings("unused")
public class YAxis extends Axis {
	/**
	 * 
	 */
	public YAxis(String partten) {
		super(Orientation.VERTICAL);
		if(partten == null) this.pattern = "#0"; 
		else this.pattern = partten; formater = new DecimalFormat(this.pattern);
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
		g.drawLine(x, y, x, h); if(!isMajor() || datas == null || datas.size() == 0) return;
		
		//
		final List<Integer> positions = getMarkPosition(datas);
		for (Integer p : positions) { g.drawLine(x, p, x + TICK_LENGTH , p);
			GUtils.drawYAxisText(g, this.formater.format(getValueByPosition(p)), x + TICK_LENGTH, p, null);
		}
	}
}

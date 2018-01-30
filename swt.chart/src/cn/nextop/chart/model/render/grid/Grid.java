package cn.nextop.chart.model.render.grid;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.LightChartModel;
import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.config.theme.GridTheme;
import cn.nextop.chart.model.render.axis.Axis;

public class Grid extends Figure {
	//
	protected Axis axis;
	protected GridTheme theme;
	/**
	 * 
	 */
	public Grid(Axis axis) { 
		this.axis = axis;
		this.theme = new GridTheme();
	}
	
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g); Rectangle r = getClientArea();
		final LightChart chart = axis.getChart();
		LightChartModel model = chart.getModel();
		final int x = r.x, y = r.y, h = r.height, w = r.width;
		final List<TraceData> datas = model.getDatas(this.axis.getTrace());
		if(!this.axis.isMajor() || datas == null || datas.size() == 0) return;
		
		//
		g.setForegroundColor(theme.getLineColor());
		g.setLineWidth(theme.getLineWidth()); g.setLineStyle(theme.getLineStyle()); 
		if(this.axis.isVertical()) {
			List<Integer> positions = this.axis.getMarkPosition(datas);
			for (Integer p : positions) {
				g.drawLine(x, p, x + w, p);
			}
		} else {
			List<Double> values = this.axis.getMarkValue(datas);
			for (Double v : values) {
				int next = this.axis.getPositionByValue(v);
				g.drawLine(next, y, next, y + h);
			}
		}
	}

	/**
	 * 
	 */
	public GridTheme getTheme() {
		return theme;
	}

	public void setTheme(GridTheme theme) {
		this.theme = theme;
	}
}

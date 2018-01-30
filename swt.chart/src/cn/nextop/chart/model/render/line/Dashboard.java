package cn.nextop.chart.model.render.line;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import cn.nextop.chart.model.config.theme.TraceTheme;
import cn.nextop.chart.model.render.axis.Axis;
import cn.nextop.chart.model.render.trace.Trace;

@SuppressWarnings("unused")
public class Dashboard extends Figure {
	//
	protected List<DashboardInfo> infos;
	
	/**
	 * 
	 */
	public Dashboard() {
		setVisible(false); this.infos = new ArrayList<>();
	}
	
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(120, 50);
	}
	
	@Override
	protected void paintClientArea(Graphics g) {
		super.paintClientArea(g); Rectangle rect = getClientArea();
		g.drawRoundRectangle(new Rectangle(rect.x, rect.y, rect.width - 1, rect.height - 1), 6, 6);
	}
	
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g); Rectangle rect = getClientArea();
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		
		//
		for (DashboardInfo info : infos) {
			g.drawString("Time:"+info.time, x + 5, y + 5);
			g.setForegroundColor(info.color); g.drawString(info.name + ":"+info.value, x + 5, info.y + 5);
		}
	}
	
	/**
	 * 
	 */
	public void paintValue(List<Trace> traces, int x, int y) {
		if(!isVisible()) return; int ly = 0; infos.clear(); for (Trace trace : traces) {
			final TraceTheme theme = trace.getTheme();
			final Axis ay = trace.getYAxis(); final Axis ax = trace.getXAxis();
			DashboardInfo r = new DashboardInfo(theme.getName(), theme.getLineColor());
			String sy = ay.format(ay.getValueByPosition(y)), sx = ax.format(ax.getValueByPosition(x));
			//
			r.value = sy; ly += 20; r.y = ly; r.time = sx; infos.add(r);
		}
		this.repaint();
	}
	
	protected class DashboardInfo {
		protected int x, y;
		protected Color color;
		protected String name, value, time;
		public DashboardInfo(String name, Color color) { this.name = name; this.color = color; }
	}
}

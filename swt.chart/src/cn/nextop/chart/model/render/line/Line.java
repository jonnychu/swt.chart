package cn.nextop.chart.model.render.line;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class Line extends Figure {
	//
	private boolean xAxis;
	
	public Line(boolean xAxis) { this.xAxis = xAxis; setVisible(false); }
	
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g); Rectangle rect = getClientArea();
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		//
		if(xAxis) { g.setLineStyle(SWT.LINE_DOT); g.drawLine(x, y, x, y + h); }
		else { g.setLineStyle(SWT.LINE_DOT); g.drawLine(x, y, x + w, y); }
	}
}
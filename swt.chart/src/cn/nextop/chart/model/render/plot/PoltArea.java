package cn.nextop.chart.model.render.plot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.config.theme.PoltAreaTheme;
import cn.nextop.chart.model.render.grid.Grid;
import cn.nextop.chart.model.render.line.Dashboard;
import cn.nextop.chart.model.render.line.Line;
import cn.nextop.chart.model.render.trace.Trace;

public class PoltArea extends Figure {
	//
	protected Dashboard board;
	protected LightChart chart;
	protected List<Grid> grids;
	protected Line xLine, yLine;
	protected List<Trace> traces;
	protected PoltAreaTheme theme;
	
	/**
	 * 
	 */
	public PoltArea(LightChart chart) {
		this.chart = chart;
		this.theme = new PoltAreaTheme();
		this.grids = new ArrayList<Grid>();
		this.traces = new ArrayList<Trace>();
		this.xLine = new Line(true); add(this.xLine);
		this.yLine = new Line(false); add(this.yLine);
		this.board = new Dashboard(); add(this.board);
		//
		addListener();
	}
	
	/**
	 * 
	 */
	@Override
	protected void paintClientArea(Graphics g) {
		super.paintClientArea(g); 
		if(theme.isDrawRect()) g.drawRectangle(getClientArea());
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		setOpaque(true); setBackgroundColor(theme.getBackgroundColor());
	}
	
	@Override
	protected void layout() {
		super.layout(); Rectangle rect = getClientArea();
		for (Grid grid : grids) { grid.setBounds(rect); } 
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		Point xp = this.xLine.getLocation(), yp = this.yLine.getLocation();
		//
		this.xLine.setBounds(new Rectangle(xp.x, xp.y, 1, h)); 
		this.yLine.setBounds(new Rectangle(yp.x, yp.y, w, 1));
		//
		Dimension d = this.board.getPreferredSize(0, 0);
		this.board.setBounds(new Rectangle(x, y, d.width, d.height));
	}
	
	/**
	 * 
	 */
	protected void addListener() {
		addMouseListener(new MouseListener.Stub() {
			@Override public void mouseDoubleClicked(MouseEvent me) {
				board.setVisible(!board.isVisible()); board.paintValue(traces, me.x, me.y);
				xLine.setVisible(!xLine.isVisible()); yLine.setVisible(!yLine.isVisible());
			}
		});
		addMouseMotionListener(new MouseMotionListener.Stub() {
			@Override public void mouseMoved(MouseEvent me) {
				Point p1 = me.getLocation(), p2 = xLine.getLocation(), p3 = yLine.getLocation();
				xLine.setLocation(new Point(p1.x, p2.y)); yLine.setLocation(new Point(p3.x, p1.y));
				board.paintValue(traces, me.x, me.y);
			}
		});
	}
	
	/**
	 * 
	 */
	public PoltAreaTheme getTheme() {
		return theme;
	}

	public void setTheme(PoltAreaTheme theme) {
		this.theme = theme;
	}
	
	public List<Grid> getGrids() {
		return this.grids;
	}
	
	public void addGrid(Grid grid) {
		this.grids.add(grid); this.add(grid); revalidate();
	}
	
	public List<Trace> getTraces() {
		return this.traces;
	}
	
	public void addTrace(Trace trace) {
		this.traces.add(trace); this.add(trace); revalidate();
	}
}

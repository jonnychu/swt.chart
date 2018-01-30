package cn.nextop.chart.model.config.layout;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.model.render.axis.Axis;
import cn.nextop.chart.model.render.plot.PoltArea;
import cn.nextop.chart.model.render.trace.Trace;

public class DefaultLayout {
	//
	protected final static int AW = 60;
	
	/**
	 * 
	 */
	public void layout(LightChart chart) {
		final PoltArea polt = chart.getPolt();
		final List<Axis> xAxes = chart.getxAxes(); 
		final List<Axis> yAxes = chart.getyAxes();
		final Rectangle rect = chart.getClientArea();
		int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		
		// left
		Rectangle left = new Rectangle(0, 0, 20, h);
		
		// right
		for (Axis axis : yAxes) {
			axis.setBounds(new Rectangle(w - AW, y, AW, h - AW));
		}
		
		// bottom
		for (Axis axis : xAxes) {
			axis.setBounds(new Rectangle(x, h - AW, w - 2 * left.width, AW));
		}
		
		//
		final Rectangle poltRect = new Rectangle(x + left.width, y, w - AW - left.width, h - AW);
		polt.setBounds(poltRect); for (Trace t : polt.getTraces()) t.setBounds(poltRect);
	}
}

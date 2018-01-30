package cn.nextop.chart.action.actor;

import org.eclipse.swt.widgets.Display;

import cn.nextop.chart.LightChart;
import cn.nextop.chart.action.IAction;
import cn.nextop.chart.action.IReactor;

/**
 * @author jonny
 */
public class DefaultRector implements IReactor {
	//
	protected final LightChart chart;
	
	/**
	 * 
	 */
	public DefaultRector(LightChart chart) {
		this.chart = chart;
	}
	
	/**
	 * 
	 */
	@Override 
	public void submit(IAction action) { 
		//
		final Display display = this.chart.getDisplay();
		if(display.getThread() == Thread.currentThread()) {
			action.apply(this.chart);
		} else {
			display.syncExec(() -> { action.apply(this.chart); });
		}
	}
}

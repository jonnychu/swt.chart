package cn.nextop.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.joda.time.DateTime;

import cn.nextop.chart.model.bean.TraceData;
import cn.nextop.chart.model.builder.LightChartBuilder;
import cn.nextop.chart.model.render.trace.Trace;
import cn.nextop.chart.support.util.Colors;
import net.miginfocom.swt.MigLayout;

public class ChartTest {
	public static void main(String args[]) {
		ChartTest m = new ChartTest(); m.init();
	}
	
	protected void init() {
		Shell shell = new Shell();
		shell.setLayout(new MigLayout("insets 0","[fill,grow]","[fill,grow]"));
		FigureCanvas c = new FigureCanvas(shell); c.setLayoutData("cell 0 0");
		LightweightSystem lws = new LightweightSystem(c);
		LightChart chart = new LightChart(shell.getDisplay()); lws.setContents(chart);
		LightChartBuilder builder = new LightChartBuilder(chart);
		Trace trace1 = builder.trace("HH:mm", "#0").color(Colors.COLOR_BLUE).name("A").build();
		Trace trace2 = builder.trace("HH:mm", "#0").color(Colors.COLOR_RED).name("B").build();
		
		//Test1
		{
			chart.feed(trace1, getData(300, 20, 10, 1));
			chart.feed(trace2, getData(300, 20, 10, -1));
		}
		
		//Test2
		{
//			Trace trace2 = builder.trace().width(2).name("B").color(Colors.COLOR_BLUE).build();
//			
//			Display.getCurrent().timerExec(1000, new Runnable() {
//				int in = 60 * 1000;
//				int step = 1 * 1000;
//				private boolean running = true;
//				int max=500; int min=10; Random random = new Random();
//				DateTime start = new DateTime(System.currentTimeMillis());
//				
//				//
//				public void run() {
//					chart.add(trace1, new TraceData(start.getMillis(), random.nextInt(max) % (max - min + 1) + min));
//					chart.add(trace2, new TraceData(start.getMillis(), random.nextInt(max) % (max - min + 1) + min));
//					if (running) {
//						start = start.plus(in);
//						Display.getCurrent().timerExec(step, this);
//					}
//				}
//			});
		}

		
		//
		shell.setSize(1000, 600); shell.open();
		Display display = Display.getDefault();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	protected List<TraceData> getData(int size, int max, int min, int positive) {
		//
		Random random = new Random();
		DateTime start = new DateTime(2017, 12, 28, 06, 9, 0, 0);
		List<TraceData> r = new ArrayList<>();
		for (int i = 0; i < size + 1; i++) {
			start = start.plusMinutes(1);
			r.add(new TraceData(start.getMillis(), positive * (i + random.nextInt(max) % (max - min + 1) + min))); //+ random.nextInt(max) % (max - min + 1) + min)
		}
		return r;
	}
	
	protected void onSelected(IFigure f) {
		System.out.println("click" + f);
	}
}
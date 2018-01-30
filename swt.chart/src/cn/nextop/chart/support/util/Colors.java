package cn.nextop.chart.support.util;

import static org.eclipse.swt.widgets.Display.getDefault;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * 
 */
public final class Colors {
	//
	protected static final Map<String, Color> COLORS = new HashMap<>();
	
	//
	public static final Color COLOR_RED = Display.getDefault().getSystemColor(SWT.COLOR_RED);
	public static final Color COLOR_BLUE = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
	public static final Color COLOR_BLACK = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
	public static final Color COLOR_GREEN = Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
	public static final Color COLOR_WHITE = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
	public static final Color COLOR_DARK_RED = Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED);
	public static final Color COLOR_DARK_GRAY = Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY);
	public static final Color COLOR_LIST_BACKGROUND = getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
	public static final Color COLOR_WIDGET_FOREGROUND = getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND);
	public static final Color COLOR_WIDGET_BACKGROUND = getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
	public static final Color COLOR_WIDGET_NORMAL_SHADOW = getDefault().getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);
	
	/**
	 * Color
	 */
	public static final Color getColor(int r, int g, int b) {
		final String key = new StringBuilder(12).append(r).append(":").append(g).append(":").append(b).toString();
		Color c = COLORS.get(key); if (c == null) COLORS.put(key, c = new Color(getDefault(), r, g, b)); return c;
	}
}

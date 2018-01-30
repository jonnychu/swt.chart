package cn.nextop.chart.support.util;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * 
 * @author jonny
 */
public final class GUtils {
	
	/**
	 * 
	 */
	public static final Dimension getDateExtents() {
		return FigureUtilities.getTextExtents("hh:mm", null);
	}
	
	
	public static final void drawYAxisText(Graphics graphics, String text, int x, int y, Font font) {
		graphics.pushState(); graphics.translate(x, y);
		Font f = font == null ? graphics.getFont() : font;
		Dimension d = FigureUtilities.getTextExtents(text, f);
		graphics.drawText(text, 5, - d.height / 2); graphics.popState();
	}
	
	public static final void drawXAxisText(Graphics graphics, String text, int x, int y, Font font) {
		graphics.pushState(); graphics.translate(x, y);
		Font f = font == null ? graphics.getFont() : font;
		Dimension d = FigureUtilities.getTextExtents(text, f);
		graphics.drawText(text, - d.width / 2, 0); graphics.popState();
	}
	
	public static final void drawGridLine(Graphics graphics, Color fg, int x1, int y1, int x2, int y2) {
		graphics.pushState(); graphics.setLineWidth(1); graphics.setLineStyle(SWT.LINE_DASH);
		graphics.setForegroundColor(fg); graphics.drawLine(x1, y1, x2, y2); graphics.popState();
	}
}

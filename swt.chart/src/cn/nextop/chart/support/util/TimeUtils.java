package cn.nextop.chart.support.util;

import java.util.List;

import cn.nextop.chart.support.Range;
import cn.nextop.chart.support.glossary.TimeLine;

public class TimeUtils {
	
	/**
	 * 
	 */
	protected static long roundSeconds(long time) {
		return time / ( 60 * 1000 );
	}
	
	protected static long roundMillSeconds(long time) {
		return time / 1000;
	}
	
	public static boolean isMark(long time, TimeLine type) {
		boolean r = false; switch (type) {
		case MINS1: r = roundSeconds(time) % 1 == 0; break;
		case MINS5: r = roundSeconds(time) % 5 == 0; break;
		case MINS10: r = roundSeconds(time) % 10 == 0; break;
		case MINS15: r = roundSeconds(time) % 15 == 0; break;
		case MINS20: r = roundSeconds(time) % 20 == 0; break;
		case MINS30: r = roundSeconds(time) % 30 == 0; break;
		case HOURS1: r = roundSeconds(time) % 60 == 0; break;
		case HOURS2: r = roundSeconds(time) % (2 * 60) == 0; break;
		case HOURS4: r = roundSeconds(time) % (4 * 60) == 0; break;
		case DAYS1: r = roundSeconds(time) % (24 * 60) == 0; break;
		default: throw new RuntimeException("invalid type, "+type); } return r;
	}
	
	public static boolean isMark2(long time, TimeLine type) {
		boolean r = false; switch (type) {
		case MINS10: r = roundSeconds(time) % 1 == 0; break;
		case MINS20: r = roundSeconds(time) % 2 == 0; break;
		case MINS30: r = roundSeconds(time) % 3 == 0; break;
		case HOURS1: r = roundSeconds(time) % 6 == 0; break;
		case HOURS2: r = roundSeconds(time) % 12 == 0; break;
		case HOURS4: r = roundSeconds(time) % 24 == 0; break;
		default: throw new RuntimeException("invalid type, "+type); } return r;
	}
	
	public static TimeLine autoTimeLine(Range range, List<Integer> positions, int pixLength, int dWidth) {
		if(range == null) return null; TimeLine timeLine = null;
		final double min = range.getLower(), max = range.getUpper();
		if (max - min < 6400000) timeLine = TimeLine.MINS1;
		else if (max - min < 43200000) timeLine = TimeLine.MINS10;
		else if (max - min < 86400000) timeLine = TimeLine.MINS30;
		else if (max - min < 604800000) timeLine = TimeLine.HOURS1;
		else timeLine = TimeLine.HOURS2; return timeLine;
	}
}

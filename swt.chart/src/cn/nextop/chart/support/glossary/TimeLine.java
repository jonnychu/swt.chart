package cn.nextop.chart.support.glossary;

/**
 * @author jonny
 */
public enum TimeLine {
	//
	DAYS1, SEC10, MINS1, MINS5, MINS10, MINS15, MINS20, MINS30, HOURS1, HOURS2, HOURS4;
	
	/**
	 * 
	 */
	public TimeLine next(TimeLine prev) {
		switch (prev) {
		case SEC10: return MINS1;
		case MINS1: return MINS5;
		case MINS5: return MINS10;
		case MINS10: return MINS15;
		case MINS15: return MINS20;
		case MINS20: return MINS30;
		case MINS30: return HOURS1;
		case HOURS1: return HOURS2;
		case HOURS2: return HOURS4;
		case HOURS4: return DAYS1;
		case DAYS1: return MINS5;
		default: return DAYS1;
		}
	}
}

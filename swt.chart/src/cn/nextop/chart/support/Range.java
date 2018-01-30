package cn.nextop.chart.support;

/**
 * 
 */
public class Range {
	//
	final private double lower;
	final private double upper;

	/**
	 * 
	 */
	public Range(double start, double end) {
		this.lower = start; this.upper = end;
	}

	/**
	 * 
	 */
	public double getLower() { return lower; }
	public double getUpper() { return upper; }
	
	/**
	 * 
	 */
	public boolean inRange(final double value) {
		if (lower <= upper) return value >= lower && value <= upper;
		else return value >= upper && value <= lower;
	}
	

	/**
	 * 
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Range)) return false;
		final Range other = (Range) obj;
		return other.lower == lower && other.upper == upper;
	}

	@Override
	public String toString() { return "lower=" + lower + ", upper=" + upper; }
	
	@Override
	public int hashCode() {
		int result = (int) Double.doubleToLongBits(lower);
		result = 37 * result + (int) Double.doubleToLongBits(upper); return result;
	}
}

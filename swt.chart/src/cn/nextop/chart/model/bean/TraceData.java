package cn.nextop.chart.model.bean;

public class TraceData {
	//
	private double x;
	private double y;
	
	/**
	 * 
	 */
	public TraceData(double x, double y) {
		this.x = x; this.y = y;
	}
	
	/**
	 * 
	 */
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}

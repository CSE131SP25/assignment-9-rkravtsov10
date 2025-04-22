package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = ColorUtils.solidColor();
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, this.size);
		double length = 0.06;
		double width = 0.04;
	}
	
	public void drawFirst() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, 0.030);
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
}

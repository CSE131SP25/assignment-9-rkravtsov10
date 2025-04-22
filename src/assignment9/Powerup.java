package assignment9;
import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class Powerup {

	public static final double FOOD_SIZE = 0.02;
	private double x;
	private double y;
	
	//create powerup at a random location in game
	
	public Powerup() {
		this.x = Math.random();
		this.y = Math.random();
	}
	
	//need to draw the powerup
	public void draw() {
		StdDraw.setPenColor(100,100,20);
		StdDraw.filledCircle(this.x, this.y, FOOD_SIZE);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
}

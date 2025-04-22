package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.4, 0.4, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.getFirst();
		double newHeadX = head.getX() + deltaX; //this moves the snake horizontaly
		double newHeadY = head.getY() + deltaY; //this moves the snake vertically
		segments.addFirst(new BodySegment(newHeadX, newHeadY, SEGMENT_SIZE)); //this creates new parts of the segment that those x,y coordinates
		segments.removeLast(); // this takes away the final segment so it looks like the snake moved
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		segments.get(0).drawFirst();
		for(BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst(); // this is the head of the snake(1st piece)
		double dist = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2)); // center of head vs center of food
		if(dist < (SEGMENT_SIZE + Food.FOOD_SIZE)/2) { // if that comparison is less than the avg distance of the 2, it counts as a collision and the snake adds on a segment
			BodySegment tail = segments.getLast();
			segments.addLast(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE)); //this is the new body segment being created
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() { //how the game checks if the snake is in the bounds of the game
		BodySegment head = segments.getFirst();
		double headX = head.getX();
		double headY = head.getY();
		return headX >= 0 && headX <= 1 && headY >=0 && headY <=1; //this whole line will only allow the game to continue if all true
		//so in game, this condition is checked and if its false then game over will appear and game ends
	}
}


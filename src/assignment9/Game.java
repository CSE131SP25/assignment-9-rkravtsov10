package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int score; // this is my addition
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
		this.score = 0;
	}
	
	public void play() {
		while (true) { //set initially that the snake is in bounds always
			if(!snake.isInbounds()) { // if snake is not in bounds, you lose
				System.out.println("YOU LOST!!");
				StdDraw.clear();
				StdDraw.setPenColor(200,100,0);
				StdDraw.text(0.4, 0.4, "GAME OVER!!");
				StdDraw.show();
				break;
			}
			int dir = getKeypress();
			if(dir != -1) { //if not a not valid key was pressed, then the snake will move following the method call
				snake.changeDirection(dir);
			}
			
			snake.move(); // this updates the position of the snake, moves it to the new x,y coordinates
			
			if(snake.eatFood(food)) { //this is where the game detects the eating of food
				food.move(); //if the snake is eating, it calls the move method which places new food at location x,y
				score++;
				System.out.println("SCORE OF GAME: " + score); // this is my part 
				
			}
			
			updateDrawing(); // this redraws the new food that was created from eatFood and new position of the snake 
			StdDraw.pause(100);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}

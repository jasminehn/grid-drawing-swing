package HW1;

import java.awt.Graphics2D;

public class GridGameManager {
	
	int rows = 50; int cols = 50;
	GridUnit[][] grid = new GridUnit[rows][cols];
	/*
	 * [0][0]  [0][1]  [0][2]....
	 * [1][0]  [1][1]  [1][2]....
	 */
	
	/**
	 * Sets up a game of blank Grid Units (no locations or size), with random colors
	 */
	public GridGameManager() {
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				grid[row][col] = new GridUnit();
			}
		}
	}
	
	/**
	 * Sets up a game of grid units for a panel of the given width and height,
	 * and places grid units evenly according to the area they should occupy
	 * @param width of the parent panel
	 * @param height of the parent panel
	 */
	public GridGameManager(double width, double height) {
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				grid[row][col] = new GridUnit();
			}
		}
		updateGridDisplay(width, height);
	}
	
	/**
	 * Redraws the entire grid
	 * @param g
	 */
	public void drawGrame(Graphics2D g) {
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				grid[row][col].draw(g);
			}
		}
	}
	
	/**
	 * Resize the game to fit a panel of the given width and height
	 * @param width of the parent panel
	 * @param height of the parent panel
	 */
	public void updateGridDisplay(double width, double height) {
		double gridHeight = width / (double) rows;
		double gridWidth = height / (double) cols;
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				grid[row][col].setSize(gridHeight, gridWidth);
				grid[row][col].setLocation(gridHeight * row, gridWidth * col);
			}
		}
	}

}

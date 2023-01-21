import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class ColorGrid extends JPanel implements MouseInputListener, KeyListener {

	GridGameManager game;
	ColorPickerPanel pickerPanel; // Reference to the picker panel, required to update colors
	
	int cursorSize = 2;
	
	public ColorGrid(int width, int height, Color bgColor)  {
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor); 
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		game = new GridGameManager(width, height);
	}
	

	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		Graphics2D g = (Graphics2D) graphic;
		
		game.updateGridDisplay(getWidth(), getHeight());
		game.drawGrame(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for(int row = 0; row < game.rows; row++) {
			for(int col = 0; col < game.cols; col++) {
				if(game.grid[row][col].contains(e.getPoint())){
					game.grid[row][col].color = pickerPanel.color;
					/*
					 * paint 1 unit away from the one you've clicked with 2D array of GridUnits
					 * 
					 * 		1
					 * 	1	X	1
					 * 		1
					 * 
					 * for 2 units:
					 * 			2	
					 * 		2	1	2
					 * 	2	1	X	1	2
					 * 		2	1	2
					 * 			2
					 * 
					 * and so forth....
					 * 
					 * then check boundaries so you don't go out of bounds on the left/right
					 */		
					for(int i = 0; i <= cursorSize; i++) {
						try {
							game.grid[row + i][col].color = pickerPanel.color;
							game.grid[row - i][col].color = pickerPanel.color;
							game.grid[row][col + i].color = pickerPanel.color;
							game.grid[row][col - i].color = pickerPanel.color;
							game.grid[row + i][col + i].color = pickerPanel.color;
							game.grid[row + i][col - i].color = pickerPanel.color;
							game.grid[row - i][col - i].color = pickerPanel.color;
							game.grid[row - i][col + i].color = pickerPanel.color;
						}catch(IndexOutOfBoundsException outOfBounds) {
							//do nothing...
						}
					}
				}
			}
		}
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode() == KeyEvent.VK_0) {
			cursorSize = 0;
		}else if(k.getKeyCode() == KeyEvent.VK_1) {
			cursorSize = 1;
		}else if(k.getKeyCode() == KeyEvent.VK_2) {
			cursorSize = 2;
		}else if(k.getKeyCode() == KeyEvent.VK_3) {
			cursorSize = 3;
		}else if(k.getKeyCode() == KeyEvent.VK_4) {
			cursorSize = 4;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}

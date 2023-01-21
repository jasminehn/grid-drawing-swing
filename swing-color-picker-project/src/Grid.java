import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

public class Grid extends JPanel{
	
	private static final int rows = 50, cols = 50, size = 10;
	
	Random rand = new Random();
	
	/**
     * Generates a 50x50 grid of cells
     * 
     * @param d The display from which the cells get the user-input color
     */
	public Grid(Display d) {
		super();
		setPreferredSize(new Dimension(rows * size, cols * size));
		setBackground(Color.white);
		setLayout(new GridLayout(rows, cols, 0, 0));
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Cell cell = new Cell(size, d);
				
				int r = rand.nextInt(255);
            	int g = rand.nextInt(255);
            	int b = rand.nextInt(255);
            	Color randomColor = new Color(r, g, b); // Sets each cell as a random color
				cell.setBackground(randomColor);
				add(cell);
			}
		}
	}
	
}

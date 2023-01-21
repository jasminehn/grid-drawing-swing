import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class Cell extends JPanel implements MouseInputListener {
	
	Display d;

    private final int cellSize;
    
    /**
     * Creates a cell with a specified size
     * 
     * @param cellSize The size of the cell (width and height)
     * @param d The display from which the cells get the user-input color
     */
    Cell (int cellSize, Display d){
        this.cellSize = cellSize;
        this.d = d;
        this.addMouseListener(this);
        setPreferredSize(new Dimension(cellSize, cellSize));
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
    	// Checks if the left mouse button is pressed when the mouse enters a cell
    	if (SwingUtilities.isLeftMouseButton(e)) {
    		setBackground(d.chosenColor);
    	}
    }

    @Override
    public void mouseExited(MouseEvent e) {}
    
}

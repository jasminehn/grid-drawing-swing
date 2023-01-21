import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GridUnit {
	
	private Rectangle2D.Double display = new Rectangle2D.Double(0, 0, 0, 0);
	Color color;
	
	/**
	 * Sets up an empty grid unit (with no size or location), and a random color.
	 */
	GridUnit(){
		color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
	}
	
	/**
	 * Update the width and height of a grid unit
	 * @param width
	 * @param height
	 */
	public void setSize(double width, double height) {
		display.width = width;
		display.height = height;
	}
	
	/**
	 * Update the x, y location of a grid unit
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y) {
		display.x = x;
		display.y = y;
	}
	
	/**
	 * Draws the grid unit, with a black outline and the given color
	 * @param g
	 */
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.draw(display);
		g.setColor(color);
		g.fill(display);
	}
	
	/**
	 * Returns true if the underlying display rectangle contains the point, otherwise false
	 * @param p - the point
	 * @return true if display contains the point
	 */
	public boolean contains(Point2D p) {
		if(display.contains(p)) {
			return true;
		}else {
			return false;
		}
	}

}

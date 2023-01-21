import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JPanel{
	
	Rectangle2D.Double rect = new Rectangle2D.Double(250, 10, 50, 25); // Creates rectangle where current chosen color is displayed visually

	private JLabel currColor = new JLabel("Current color: "); // Displays current color chosen by user
	
	private JLabel red = new JLabel("Red: "); // Displays current red value of color chosen by user 
	private JTextField rText = new JTextField("0", 5); // Text fields where the user enters the desired red value
	int rVal = Integer.parseInt(rText.getText()); // Stores the red value entered by the user as an integer
	
	private JLabel green = new JLabel("Green: "); // Displays current green value of color chosen by user
	private JTextField gText = new JTextField("255", 5); // Text fields where the user enters the desired green value
	int gVal = Integer.parseInt(gText.getText()); // Stores the green value entered by the user as an integer
	
	private JLabel blue = new JLabel("Blue: "); // Displays current blue value of color chosen by user
	private JTextField bText = new JTextField("255", 5); // Text fields where the user enters the desired blue value
	int bVal = Integer.parseInt(bText.getText()); // Stores the blue value entered by the user as an integer
	
	private JButton confirmButton = new JButton("Confirm"); // Button to confirm the values entered as the chosen color
	
	private JLabel update = new JLabel(""); // Displays the previous color after a new color is chosen
	
	public Color chosenColor = new Color(0, 255, 255); // Current color chosen by user (default is cyan)
	
	/**
     * Creates a cell with a specified size
     * 
     * @param width Sets the width of the panel
     * @param height Sets the height of the panel
     * @param bgColor Sets background color of the panel
     */
	public Display(int width, int height, Color bgColor) {
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		
		this.setLayout(new GridLayout(0, 1));
		this.add(currColor);
		
		JPanel colors = new JPanel();
		colors.setBackground(bgColor);
		colors.add(red);
		colors.add(rText);
		colors.add(green);
		colors.add(gText);
		colors.add(blue);
		colors.add(bText);
		
		JPanel confirm = new JPanel();
		confirm.setBackground(bgColor);
		confirm.add(confirmButton);
		
		JPanel other = new JPanel();
		other.setBackground(bgColor);
		other.add(update);
		
		this.add(colors);
		this.add(confirm);
		this.add(other);
		
		// Method is called when the confirm button is clicked
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rTemp = rVal; // Stores the current red value in a temporary integer
					int gTemp = gVal; // Stores the current red value in a temporary integer
					int bTemp = bVal; // Stores the current red value in a temporary integer
					rVal = Integer.parseInt(rText.getText());
					gVal = Integer.parseInt(gText.getText());
					bVal = Integer.parseInt(bText.getText());
					
					// Checks if the values entered are valid color values
					if(rVal > 255 || rVal < 0 || gVal > 255 || gVal < 0 || bVal > 255 || bVal < 0) { 
				          JOptionPane.showMessageDialog(null, "Enter a number between 0 and 255");
				          rText.setText("0");
				          bText.setText("0");
				          gText.setText("0");
					}
					else {
						chosenColor = new Color(rVal, gVal, bVal);
						currColor.setText("Current color: R" + rVal + " G" + gVal +  " B" + bVal);
						update.setText("Color updated! Previous color was: R" + rTemp + " G" + gTemp +  " B" + bTemp);
					}
					
				}
				
				// Checks if a non-number has been entered
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Enter integers only (no decimals, letters, symbols, etc.)"); 
					rText.setText("0");
					bText.setText("0");
					gText.setText("0");
				}
			}
			
		});
		
		// Tracks which JTextLabel is currently selected by the user
		FocusListener f = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Component source = e.getComponent(); // Stores the currently selected JTextLabel as a variable
                source.setBackground(Color.lightGray); // Sets JTextField background to gray
                if (source instanceof JTextField) {
                    ((JTextField)source).setText(""); // Sets JTextField to blank
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(Color.white);  // Sets JTextField background back to white
            }
        };
        
        rText.addFocusListener(f);
        gText.addFocusListener(f);
        bText.addFocusListener(f);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		
		g.setColor(chosenColor); // Sets the color of the square as the current chosen color
		g.fill(rect);
		repaint();
	}

}

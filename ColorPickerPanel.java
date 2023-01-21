import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorPickerPanel extends JPanel{
	private JLabel currentColorLabel; //The text of "Current Color: r g b"
	private JLabel currentColorImageLabel; //The color preview square
	private JLabel redLabel;
	private JLabel greenLabel;
	private JLabel blueLabel;
	private JLabel errorLabel;
	private JTextField redTextField;
	private JTextField greenTextField;
	private JTextField blueTextField;
	private JButton confirmButton;
	
	int red = 100;
	int green = 215;
	int blue = 250;
	
	public Color color = new Color(red, green, blue);
	
	ColorPickerPanel(int width, int height, Color bgColor){
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor); 
		
		currentColorLabel = new JLabel("Current Color: R" + red + " G" + green + " B" + blue);
		currentColorImageLabel = new JLabel();
		currentColorImageLabel.setOpaque(true);
		currentColorImageLabel.setBackground(new Color(red, green, blue));
		redLabel = new JLabel("Red: ");
		greenLabel = new JLabel("Green: ");
		blueLabel = new JLabel("Blue: ");
		errorLabel = new JLabel("");
		redTextField = new JTextField(""+red);
		greenTextField = new JTextField(""+green);
		blueTextField = new JTextField(""+blue);
		confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        confirmColor();
		    } 
		});
		
		this.add(currentColorLabel);
		this.add(currentColorImageLabel);
		this.add(redLabel);
		this.add(greenLabel);
		this.add(blueLabel);
		this.add(errorLabel);
		this.add(redTextField);
		this.add(greenTextField);
		this.add(blueTextField);
		this.add(confirmButton);
		
		redTextField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) { redTextField.setText(""); }
		    @Override
		    public void focusLost(FocusEvent e) { }
		});
		greenTextField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) { greenTextField.setText(""); }
		    @Override
		    public void focusLost(FocusEvent e) { }
		});
		blueTextField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) { blueTextField.setText(""); }
		    @Override
		    public void focusLost(FocusEvent e) { }
		});
		
		confirmButton.setMnemonic(KeyEvent.VK_C);
		
		redLabel.setLabelFor(redTextField);
		greenLabel.setLabelFor(greenTextField);
		blueLabel.setLabelFor(blueTextField);
		
	}
	
	public void resizeComponents() {
		int width = getWidth(); int height = getHeight();
		int widthUnit = width/20; int heightUnit = height/10;
		int x = 0; int y = 0;
		
		
		//row 1
		y = heightUnit;
		x = widthUnit;
		currentColorLabel.setLocation(x, y);
		currentColorLabel.setSize(widthUnit * 12, heightUnit);
		x += widthUnit * 12;
		currentColorImageLabel.setLocation(x, y);
		currentColorImageLabel.setSize(widthUnit*2, heightUnit);
		//currentColorLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		
		//row 2
		y = heightUnit * 3;
		x = widthUnit;
		redLabel.setLocation(x, y);
		redLabel.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 2;
		redTextField.setLocation(x, y);
		redTextField.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 3;
		greenLabel.setLocation(x, y);
		greenLabel.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 2;
		greenTextField.setLocation(x, y);
		greenTextField.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 3;
		blueLabel.setLocation(x, y);
		blueLabel.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 2;
		blueTextField.setLocation(x, y);
		blueTextField.setSize(widthUnit * 2, heightUnit);
		x += widthUnit * 3;
		
		//row 3
		y = heightUnit * 5;
		x = widthUnit * 8;
		confirmButton.setLocation(x, y);
		confirmButton.setSize(widthUnit * 4, heightUnit);
		
		//row 4
		y = heightUnit * 7;
		x = widthUnit;
		errorLabel.setLocation(x, y);
		errorLabel.setSize(widthUnit * 18, heightUnit);
	}
	
	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		Graphics2D g = (Graphics2D) graphic;
		resizeComponents();

	}
	
	public void confirmColor() {
		int oldRed = red; int oldGreen = green; int oldBlue = blue;
		try {
			red = Integer.parseInt(this.redTextField.getText().toString());
			green = Integer.parseInt(this.greenTextField.getText().toString());
			blue = Integer.parseInt(this.blueTextField.getText().toString());
			color = new Color(red, green, blue);
			this.currentColorImageLabel.setBackground(color);
			errorLabel.setText("Color updated! Previous color was: " + oldRed + 
					" " + oldGreen + " " + oldBlue);
			this.currentColorLabel.setText("Current Color: R" + red + " G" + green + " B" + blue);
		}catch(Exception e) {
			red = oldRed; green = oldGreen; blue = oldBlue;
			errorLabel.setText("Not a valid color (0-255 only)");
			System.out.println("Error entering a color");
		}
	}

}

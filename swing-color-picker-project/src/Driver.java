import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int panelWidth = screen.width / 2;
		int panelHeight = screen.height / 2;
		
		//DISPLAY 2: COLOR PICKER
		Display display2 = new Display(panelWidth/2, panelHeight/2, Color.white);
		JFrame frame2 = new JFrame();
		frame2.setTitle("Color Picker");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(display2);
		frame2.pack();
		frame2.setLocation(700, 100);
		frame2.setVisible(true);
		
		//DISPLAY 1: COLOR GRID
		Grid display1 = new Grid(display2);
		JFrame frame1 = new JFrame();
		frame1.setTitle("Color Grid");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(display1);
		frame1.pack();
		frame1.setLocation(200, 100);
		frame1.setVisible(true);
		
	}
}

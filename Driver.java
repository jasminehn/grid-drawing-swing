package HW1;

import java.awt.Color;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String args[]) {
		ColorPickerPanel colorPickerPanel = new ColorPickerPanel(400, 200, Color.white);
		JFrame pickerFrame = new JFrame();
		pickerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pickerFrame.setTitle("Color Picker");
		pickerFrame.setLocation(1000, 150);
		pickerFrame.add(colorPickerPanel);  
		pickerFrame.pack();
		pickerFrame.setVisible(true); 
		
		ColorGrid colorGridPanel = new ColorGrid(400, 400, Color.white);
		JFrame gridFrame = new JFrame();
		gridFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridFrame.setTitle("Color Grid");
		gridFrame.setLocation(600, 150);
		gridFrame.add(colorGridPanel);  
		gridFrame.pack();
		gridFrame.setVisible(true); 
		
		colorGridPanel.pickerPanel = colorPickerPanel;
	}

}

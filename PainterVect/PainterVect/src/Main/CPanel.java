package Main;

import Utils.XCommand;
import GUI.*;

import javax.swing.*;

public class CPanel extends JPanel 
{
	public CPanel(XCommand cmd)
	{
		setLayout(null);
		
		ColorPanel colorPanel 		 = new ColorPanel(cmd);
		WidthPanel widthPanel 		 = new WidthPanel(cmd);
		TabPanel paintPanel  		 = new TabPanel(cmd);
		TypePanel typePanel  		 = new TypePanel(cmd);
		ToolBar toolBar      		 = new ToolBar(cmd);
		StatusBar statusBar  		 = new StatusBar(cmd);
		SaveLoadPanel saveLoadPanel   = new SaveLoadPanel(cmd);

		toolBar.setBounds   (0,   0,   800, 70);
		colorPanel.setBounds(0,   70,  120,  40);
		widthPanel.setBounds(0,   130, 120,  140);
		typePanel.setBounds (0,   270, 120,  220);
		paintPanel.setBounds(120, 70,  600,  500);
		statusBar.setBounds (120, 580,  600,  30);
		saveLoadPanel.setBounds (0, 500,  120,  100);

		add(colorPanel);
		add(statusBar);
		add(paintPanel);
		add(typePanel);
		add(widthPanel);
		add(toolBar);
		add(saveLoadPanel);
	}
}

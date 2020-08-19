package mainSource;
import java.awt.Component;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import XML_Parser.MarkupParser;
import canvasLayer.*;

public class MainProgram {

	public static void main(String[] args){
		
		
		//MainFrame frame = new MainFrame("Calculator", 100, 100, 360, 360);
		JFrame frame = new JFrame("Calc");
		frame.setLayout(null);
		frame.setBounds(0, 0, 1000, 750);
		frame.setVisible(true);
		
		String path = "C:\\Users\\adm\\Desktop\\painter.xml";
		//String path = "C:\\Users\\adm\\Desktop\\calculator.xml";
		MarkupParser d = new MarkupParser(path);
		Component comp = d.GetMemento();
		frame.add(comp);
		frame.repaint();
	}

}

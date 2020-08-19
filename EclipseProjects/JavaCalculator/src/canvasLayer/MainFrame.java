package canvasLayer;

import javax.swing.JFrame;
public class MainFrame extends JFrame {
	
	private CalculatorPanel calcPanel;
	
	public MainFrame(String title, int x, int y, int width, int height)  {
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(x, y, width, height);
		
		calcPanel = new CalculatorPanel();
		this.add(calcPanel);
		this.setVisible(true);
	}
}

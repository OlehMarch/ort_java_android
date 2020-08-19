package canvasLayer;

import javax.swing.JFrame;


@SuppressWarnings({ "serial" })
public class CanvasLayer extends JFrame
{
	private Canvas canvas = null;
	
	public CanvasLayer(String title, int x, int y, int width, int height)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(x, y, width, height);
		this.setTitle(title);
		this.setVisible(true);
		
		canvas = new Canvas();
		
		this.setContentPane(canvas);
	}

}

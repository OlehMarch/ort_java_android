package canvasLayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	private int stackX = 0, stackY = 0;

	private void startPaint(Graphics g, Color color, int x, int y){
		Graphics2D graph2D = null;
		graph2D = (Graphics2D)g;
        graph2D.setColor(Color.RED);
        graph2D.drawLine(stackX, stackY, x, y);
	}
	
	public Canvas(){
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				stackX = e.getX();
				stackY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getX();
				int y = e.getY();
				startPaint(getGraphics(), Color.RED, x, y);
				stackX = x;
				stackY = y;
			}
		});
	}
}

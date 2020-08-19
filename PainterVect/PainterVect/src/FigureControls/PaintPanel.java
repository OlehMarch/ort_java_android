package FigureControls;

import Utils.XCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	private XCommand cmd;
	private Point point;
	public String title;
	FigurePaintPanel current = null;

	public PaintPanel(XCommand cmd) {
		this.cmd = cmd;

		addMouseListener(this);
		addMouseMotionListener(this);
		this.addMouseMotionListener(this.cmd.eventListenerStatus);
		this.setLayout(null);
		cmd.eventListenerStatus.getListenerDataChange(cmd.data);

	}

	protected void setMemento(FigurePaintPanel figure){

		if(current != null){
			current.deselect();
		}
		current = figure;
		if(figure != null)
			current.requestFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		point = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Rectangle r = new Rectangle(point.x, point.y, e.getX() - point.x, e.getY() - point.y);
		FigurePaintPanel f = new FigurePaintPanel(r, cmd);
		f.setBounds(point.x, point.y, e.getX() - point.x, e.getY() - point.y);
		this.add(f);
		f.requestFocus();
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setMemento(null);
	}


	@Override public void mouseDragged(MouseEvent e) {}
	@Override public void mouseMoved(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyPressed(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}
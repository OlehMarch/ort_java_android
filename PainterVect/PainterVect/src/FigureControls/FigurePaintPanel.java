package FigureControls;

import ActionListener.XDataListener.IXDataListener;
import GUI.PopMenu;
import Model.Figure;
import Utils.XCommand;
import Utils.xData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FigurePaintPanel extends JComponent implements FocusListener, MouseListener, MouseMotionListener, KeyListener, IXDataListener {
	private Figure fig;
	private XCommand cmd;
	private Point point;
	private boolean leftButtonPressed = false;
	private Figure buffer;


	public FigurePaintPanel(Rectangle r, XCommand cmd) {
		setLayout(null);
		fig = new Figure(r, cmd.data);
		this.cmd = cmd;

		setBounds(r);
		setOpaque(false);

		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseMotionListener(cmd.eventListenerStatus);
		addFocusListener(this);
		setComponentPopupMenu(new PopMenu(cmd));
	}

	public void setMemento(){
		((PaintPanel)getParent()).setMemento(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		requestFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			point = e.getPoint();
			leftButtonPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			leftButtonPressed = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (leftButtonPressed)
		{
			Rectangle r = this.getBounds();
			int deltaX = e.getX() - point.x;
			int deltaY = e.getY() - point.y;
			setBounds(r.x + deltaX, r.y + deltaY, (int)r.getWidth(), (int)r.getHeight() );
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		setMemento();
		select();
		getParent().repaint();
	}
	public void setBuffer(Figure fig){
		buffer = fig.getCopy();
	}
	public Figure getBuffer(){
		return buffer;
	}
	public void deselect(){
		this.removeAll();
		setBorder(null);
		setBackground(null);

		fig.setData(new xData(fig.getData()));
		cmd.dataChanged.removeListener(this);
		removeKeyListener(this);
	}

	public void select(){
		for (Direction dir : Direction.values()) {
			FigureControl fc = new FigureControl(dir);
			this.add(fc);
			fc.setLocation();
			addKeyListener(this);
		}
		setBorder(BorderFactory.createLineBorder(Color.black));
		cmd.data = (this.fig.getData());
		cmd.dataChanged.addListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D gg = (Graphics2D) g;
		gg.setColor(this.fig.getData().getColor());
		gg.setStroke(new BasicStroke(this.fig.getData().getWidth()));
		int offs = fig.getData().getWidth();

		switch (this.fig.getData().getType()) {
			case Curve:
				//gg.drawPolyline(data.convertPoints(data.xPoints, getX()), data.convertPoints(data.yPoints, getY()), data.nPoints);
				break;
			case Line:
				gg.drawLine(0, 0, getWidth(), getHeight());
				break;
			case Rectangle:
				gg.drawRect(offs/2, offs/2, getWidth() - offs, getHeight() - offs);
				break;
			case RoundRectangle:
				int r = getWidth()<getHeight()? getWidth()/4: getHeight()/4;
				gg.drawRoundRect(offs/2, offs/2, getWidth() - offs, getHeight() - offs, r, r);
				break;
			case Ellipse:
				gg.drawOval(offs/2, offs/2, getWidth() - offs, getHeight() - offs);
				break;
			default:
				break;
		}
	}

	@Override
	public void onXDataChanged() {
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Rectangle r = this.getBounds();
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:
				if(e.isControlDown()) { r.y++; r.height--;}
				else if(e.isShiftDown()){r.y--; r.height++;}
				else r.y--;
				break;
			case KeyEvent.VK_DOWN:
				if(e.isControlDown()) r.height--;
				else if(e.isShiftDown()) r.height++;
				else r.y++;
				break;
			case KeyEvent.VK_LEFT:
				if(e.isControlDown()){r.x++; r.width--;}
				else if(e.isShiftDown()){r.x--;  r.width++;}
				else r.x--;
				break;
			case KeyEvent.VK_RIGHT:
				if(e.isControlDown()) r.width--;
				else if(e.isShiftDown()) r.width++;
				else r.x++;
				break;
			case KeyEvent.VK_C:
				if(e.isControlDown() && isFocusOwner()){
					setBuffer(fig);
				}
				break;
			case KeyEvent.VK_V:
				if(e.isControlDown() && buffer!=null){
					PaintPanel pp=(PaintPanel) getParent();

					Rectangle rectangle = new Rectangle(new Point(20,20),  getBuffer().getRect().getSize());
					FigurePaintPanel f = new FigurePaintPanel(rectangle, cmd);
					f.setBounds(rectangle);
					pp.add(f);
					f.requestFocus();
					pp.repaint();
					return;
				}
			default:
				break;
		}
		setBounds(r);
	}

	@Override public void keyReleased(KeyEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void mouseMoved(MouseEvent e) {}
	@Override public void focusLost(FocusEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
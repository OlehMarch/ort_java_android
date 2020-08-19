package FigureControls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FigureControl extends JPanel implements MouseListener, MouseMotionListener {
    private Point point;
    private Direction dir;

    public FigureControl(Direction dir){

        this.dir = dir;
        this.setBackground(Color.black);
        this.setForeground(Color.black);
        this.setSize(10, 10);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        switch (dir)
        {
            case TOP:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        onTopMouseMove(e);
                    }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                break;

            case BOTTOM:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {onBottomMouseMove(e);}
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                break;

            case LEFT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {onLeftMouseMove(e);}
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                break;

            case RIGHT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {onRightMouseMove(e); }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                break;

            case TOPLEFT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        onTopMouseMove(e);
                        onLeftMouseMove(e);
                    }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                break;

            case TOPRIGHT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        onTopMouseMove(e);
                        onRightMouseMove(e);
                    }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                break;

            case BOTTOMLEFT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        onBottomMouseMove(e);
                        onLeftMouseMove(e);
                    }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                break;

            case BOTTOMRIGHT:
                this.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        onBottomMouseMove(e);
                        onRightMouseMove(e);
                    }
                    @Override public void mouseMoved(MouseEvent e) {}
                });
                this.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                break;
        }
        invalidate();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation();
    }

    public  void setLocation(){
        Rectangle r = getParent().getBounds();
        switch (dir){
            case TOP:
                this.setBounds((getParent().getWidth() - getWidth()) / 2, 0, getWidth(), getHeight());
                break;
            case BOTTOM:
                r.setBounds((r.width-getWidth())/2, r.height-getHeight(),getWidth(),getHeight() );
                this.setBounds(r);
                break;
            case TOPLEFT:
                r.setBounds(0,0,10,10);
                this.setBounds(r);
                break;
            case TOPRIGHT:
                this.setBounds(getParent().getWidth() - getWidth() ,0, getWidth(), getHeight());
                break;
            case LEFT:
                this.setBounds(0, (getParent().getHeight() - getHeight())/2, getWidth(), getHeight());
                break;
            case RIGHT:
                this.setBounds(getParent().getWidth() - getWidth(), (getParent().getHeight() - getHeight())/2, getWidth(), getHeight());
                break;
            case BOTTOMLEFT:
                this.setBounds(0,getParent().getHeight()- getHeight(), getWidth(), getHeight());
                break;
            case BOTTOMRIGHT:
                this.setBounds(getParent().getWidth() - getWidth(), getParent().getHeight()- getHeight(), getWidth(), getHeight());
                break;
                default: break;
        }
    }

    private void onTopMouseMove(MouseEvent e)
    {
        Rectangle r = e.getComponent().getParent().getBounds();
        r.y = r.y + e.getY() - point.y;
        r.height = r.height - e.getY() + point.y;
        onRectangle(r,e);
    }

    private void onRightMouseMove(MouseEvent e)
    {
        Rectangle r = e.getComponent().getParent().getBounds();
        r.width = r.width + e.getX() - point.x;
        onRectangle(r,e);
    }

    private void onBottomMouseMove(MouseEvent e)
    {
        Rectangle r = e.getComponent().getParent().getBounds();
        r.height = r.height+e.getY()-point.y;
        onRectangle(r,e);
    }

    private void onLeftMouseMove(MouseEvent e)
    {
        Rectangle r = e.getComponent().getParent().getBounds();
        r.x = r.x + e.getX()-point.x;
        r.width=r.width - e.getX()+point.x;
        onRectangle(r,e);
    }
    private void onRectangle(Rectangle r,MouseEvent e){
        Component parent = e.getComponent().getParent();
        parent.setBounds(r);
        parent.getParent().invalidate();
        parent.getParent().repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        point = e.getPoint();
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
}

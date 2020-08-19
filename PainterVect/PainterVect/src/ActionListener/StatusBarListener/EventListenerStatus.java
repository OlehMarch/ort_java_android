package ActionListener.StatusBarListener;

import FigureControls.PaintPanel;
import Utils.xData;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EventListenerStatus implements MouseMotionListener {

	private EventListenerList listenerList = new EventListenerList();

	public void addListener(IActionListener tabList) {
		listenerList.add(IActionListener.class, tabList);
	}
	public void removeListener(IActionListener tabList) {
		listenerList.remove(IActionListener.class, tabList);
	}
	private void getListenerChanged(MouseEvent p) {
		IActionListener[] ls = listenerList.getListeners(IActionListener.class);
		for (IActionListener l : ls) {
			l.actionPoint(p);
		}
	}

	public void getListenerDataChange(xData data) {
		IActionListener[] ls = listenerList.getListeners(IActionListener.class);
		for (IActionListener l : ls) {
			l.actionDataChange(data);
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseMoved(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Component sender = arg0.getComponent();
		if(sender instanceof PaintPanel){
			this.getListenerChanged(arg0);
		}
		else{
			MouseEvent me = new MouseEvent(sender, arg0.getID(), arg0.getWhen(), arg0.getModifiers(),
					arg0.getX() + sender.getX(),
					arg0.getY() + sender.getY(),
					arg0.getClickCount(),
					arg0.isPopupTrigger()
			);
			this.getListenerChanged(me);
		}
	}
}
package ActionListener.StatusBarListener;

import Utils.xData;

import java.awt.event.MouseEvent;
import java.util.EventListener;

public interface IActionListener extends EventListener {
	void actionPoint(MouseEvent e);
	void actionDataChange(xData data);
}

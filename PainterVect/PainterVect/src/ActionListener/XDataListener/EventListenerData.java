package ActionListener.XDataListener;

import javax.swing.event.EventListenerList;
import java.util.EventListener;

public class EventListenerData implements EventListener {

    private EventListenerList listenerList = new EventListenerList();

    public void addListener(IXDataListener listener) {
        listenerList.add(IXDataListener.class, listener);
    }

    public void removeListener(IXDataListener listener) {
        listenerList.remove(IXDataListener.class, listener);
    }

    public void Invoke() {
        IXDataListener[] ls = listenerList.getListeners(IXDataListener.class);
        for (IXDataListener l : ls) {
            l.onXDataChanged();
        }
    }
}


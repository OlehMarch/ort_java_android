package ActionListener.TabListener;

import javax.swing.event.EventListenerList;
import java.util.EventListener;

public class EventListenerGen implements EventListener {

    private EventListenerList listenerList = new EventListenerList();

    public void addListener(ITabListener tabListener){
        listenerList.add(ITabListener.class, tabListener);
    }
    public void removeListener(ITabListener tabListener) {
        listenerList.remove(ITabListener.class, tabListener);
    }
    public void ListenerTabAdd(String tabName) {
        ITabListener[] ls = listenerList.getListeners(ITabListener.class);
        for (ITabListener l : ls) {
            l.onTabAdded(tabName);
        }
    }

    public void ListenerTabDel(String tabName) {
        ITabListener[] ls = listenerList.getListeners(ITabListener.class);
        for (ITabListener l : ls) {
            l.onTabDeleted(tabName);
        }
    }

}

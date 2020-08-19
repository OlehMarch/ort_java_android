package ActionListener.TabListener;

import java.util.EventListener;

public interface ITabListener extends EventListener {
    void onTabAdded(String tabName);
    void onTabDeleted(String tabName);
}

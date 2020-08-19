package GUI;

import ActionListener.TabListener.ITabListener;
import Utils.EnumFigureType;
import Utils.XCommand;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JMenuBar implements ITabListener
{
    JMenu mTabs;
    XCommand cmd;

    public MenuPanel(XCommand cmd)
    {
        this.cmd = cmd;
        JMenu mFile = new JMenu("File");
        JMenuItem mNew = new JMenuItem("New");
        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mOpen = new JMenuItem("Open");
        JMenu mColor = new JMenu("Color");
        JMenuItem mCol = new JMenuItem("Color");
        mFile.add(mNew);
        mFile.addSeparator();
        mFile.add(mSave);
        mFile.add(mOpen);
        add(mFile);

        mNew.addActionListener(cmd.actionNewTab);
        mOpen.addActionListener(cmd.actionOpen);
        mSave.addActionListener(cmd.actionSave);

        mColor.add(mCol);
        add(mColor);

        mCol.addActionListener(cmd.actionColor);

        JMenu mWidth = new JMenu("Width");
        String[] strWidth = {"Small", "Medium", "Large"};
        for(String s : strWidth)
        {
            JMenuItem item = new JMenuItem(s);
            mWidth.add(item);
            item.addActionListener(cmd.actionWidth);
        }
        add(mWidth);

        JMenu mType = new JMenu("Type");
        for(EnumFigureType s : EnumFigureType.values())
        {
            JMenuItem item = new JMenuItem(s.toString());
            mType.add(item);
            item.addActionListener(cmd.actionType);
        }
        add(mType);

        mTabs = new JMenu("Tabs");
        add(mTabs);
        mTabs.addActionListener(cmd.actionSelectTab);
        cmd.tAddListener.addListener(this);
    }

    @Override
    public void onTabAdded(String tabName) {
        JMenuItem tabItem = new JMenuItem(tabName);
        tabItem.addActionListener(cmd.actionSelectTab);
        mTabs.add(tabItem);
    }

    @Override
    public void onTabDeleted(String tabName) {
        for(Component item : mTabs.getMenuComponents()){
            if(item.getClass() == JMenuItem.class && ((JMenuItem)item).getText().equals(tabName)){
                mTabs.remove(item);
            }
        }

    }
}

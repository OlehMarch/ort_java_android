package GUI;

import Utils.XCommand;
import FigureControls.PaintPanel;

import javax.swing.*;
import java.awt.*;

public class TabPanel extends JTabbedPane
{
    private XCommand cmd;

    public TabPanel(XCommand cmd)
    {
        this.cmd = cmd;
        cmd.setPanel(this);
        setBounds(160, 70, cmd.actionPanel.getWidth() - 200, cmd.actionPanel.getHeight() - 230);
    }

    public void addPanel()
    {
        PaintPanel p = new PaintPanel(cmd);
        p.title = "Tab" + (this.getSelectedIndex()+1);
        this.addTab(p.title, p);
        p.setBorder(null);
        p.requestFocusInWindow();
        int count = getTabCount();
        setSelectedIndex(count-1);
        createTabBtn(p.title);
    }

    public void createTabBtn(String title)
    {
        JPanel pnlTab = new JPanel();

        JLabel lblTitle = new JLabel(title);
        JButton btnClose = new JButton("X");

        btnClose.setForeground(Color.RED);
        btnClose.setBackground(Color.LIGHT_GRAY);
        btnClose.setBorderPainted(false);
        btnClose.setFont( new Font ("Verdana", Font.BOLD, 11));
        btnClose.setPreferredSize(new Dimension(15, 15));
        btnClose.setMargin(new Insets(0, 0, 0, 0));
        btnClose.addActionListener(cmd.actionCloseTab);

        pnlTab.setOpaque(true);
        pnlTab.setBackground(new Color(0,0,0,0));
        pnlTab.add(lblTitle);
        pnlTab.add(btnClose);
        setTabComponentAt(this.getSelectedIndex(), pnlTab);
    }

    public void deleteTab()
    {
        remove(this.getComponentAt(this.getSelectedIndex()));
    }
}
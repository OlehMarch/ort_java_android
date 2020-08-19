package Main;

import GUI.MenuPanel;
import Utils.XCommand;

import javax.swing.*;

public class CFrame extends JFrame
{
	public XCommand cmd ;
	public CFrame(XCommand cmd)
	{
		setTitle("My Painter");
		setBounds(100, 30, 750, 680);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.cmd =cmd;

		MenuPanel menu = new MenuPanel(cmd);
		setJMenuBar(menu);

		this.getContentPane().add(new CPanel(cmd));

		cmd.actionNewTab.actionPerformed(null);

		setVisible(true);
	}
}

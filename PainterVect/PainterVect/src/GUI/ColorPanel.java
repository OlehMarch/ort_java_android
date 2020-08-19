package GUI;

import Utils.XCommand;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel 
{
	public ColorPanel(XCommand cmd)
	{
		setLayout(null);
		JButton btn = new JButton("COLOR");
		btn.setBounds(10, 0, 100, 30);
		btn.addActionListener(cmd.actionColor);
		add(btn);
	}
}

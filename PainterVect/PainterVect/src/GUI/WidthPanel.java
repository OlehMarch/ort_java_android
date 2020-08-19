package GUI;

import Utils.XCommand;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WidthPanel extends JPanel {

	public WidthPanel(XCommand cmd)
	{
		setLayout(null);

		JButton btnSmall = new JButton("Small");
		JButton btnMedium = new JButton("Medium");
		JButton btnLarge = new JButton("Large");
		
		btnSmall.setBounds(10, 0, 100, 30);
		btnMedium.setBounds(10, 40, 100, 30);
		btnLarge.setBounds(10, 80, 100, 30);
		
		btnSmall.addActionListener(cmd.actionWidth);
		btnMedium.addActionListener(cmd.actionWidth);
		btnLarge.addActionListener(cmd.actionWidth);
		
		add(btnSmall);
		add(btnMedium);
		add(btnLarge);
	}
	
}

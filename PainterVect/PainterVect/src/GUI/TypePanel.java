package GUI;

import Utils.XCommand;
import javax.swing.*;

public class TypePanel extends JPanel {

    public  TypePanel(XCommand cmd)
    {
        setLayout(null);

        JButton btnCurve = new JButton("Curve");
        JButton btnLine = new JButton("Line");
        JButton btnEllipse = new JButton("Ellipse");
        JButton btnRect = new JButton("Rectangle");
        JButton btnRoundRect = new JButton("Round Rectangle");
        btnRoundRect.setActionCommand("RoundRectangle");
        btnCurve.setBounds(10, 0, 100, 30);
        btnLine.setBounds(10, 40, 100, 30);
        btnEllipse.setBounds(10, 80, 100, 30);
        btnRect.setBounds(10, 120, 100, 30);
        btnRoundRect.setBounds(10, 160, 100, 30);

        btnCurve.addActionListener(cmd.actionType);
        btnLine.addActionListener(cmd.actionType);
        btnEllipse.addActionListener(cmd.actionType);
        btnRect.addActionListener(cmd.actionType);
        btnRoundRect.addActionListener(cmd.actionType);
        
        add(btnRect);
        add(btnRoundRect);
        add(btnEllipse);
        add(btnCurve);
        add(btnLine);
    }
}

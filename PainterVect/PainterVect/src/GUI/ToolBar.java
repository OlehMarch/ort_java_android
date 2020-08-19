package GUI;

import Utils.XCommand;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

    public  ToolBar(XCommand cmd) {
        setLayout(null);

        Font font    = new Font("TimesRoman", Font.BOLD, 10); 
		

        JButton btnCurve = new JButton("Cur");
        JButton btnLine = new JButton("Lin");
        JButton btnEllipse = new JButton("Ell");
        JButton btnRect = new JButton("Rect");
        JButton btnRoundRect = new JButton("RRect");
        
        btnCurve.setActionCommand("Curve");
        btnLine.setActionCommand("Line");
        btnEllipse.setActionCommand("Ellipse");
        btnRect.setActionCommand("Rectangle");
        btnRoundRect.setActionCommand("RoundRectangle");
        
        btnCurve.setBounds(10, 10, 60, 30);
        btnLine.setBounds(70, 10, 60, 30);
        btnEllipse.setBounds(130, 10, 60, 30);
        btnRect.setBounds(190, 10, 60, 30);
        btnRoundRect.setBounds(250, 10, 75, 30);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(335, 10, 60, 30);
        JButton btnLoad = new JButton("Load");
        btnLoad.setBounds(395, 10, 60, 30);

        JButton btnColor = new JButton("Color");
        btnColor.setBounds(465, 10, 60, 30);

        JButton btnSmall = new JButton("S");
        JButton btnMedium = new JButton("M");
        JButton btnLarge = new JButton("L");
        
        btnMedium.setBounds(595, 10, 60, 30);
        btnSmall.setBounds(535, 10, 60, 30);
        btnLarge.setBounds(655, 10, 60, 30);

        btnSmall.setActionCommand("Small");
        btnMedium.setActionCommand("Medium");
        btnLarge.setActionCommand("Large");
        
        btnSmall.addActionListener(cmd.actionWidth);
		btnMedium.addActionListener(cmd.actionWidth);
		btnLarge.addActionListener(cmd.actionWidth);
     
        
        btnCurve.addActionListener(cmd.actionType);
        btnLine.addActionListener(cmd.actionType);
        btnEllipse.addActionListener(cmd.actionType);
        btnRect.addActionListener(cmd.actionType);
        btnRoundRect.addActionListener(cmd.actionType);
        
        add(btnSmall);
        add(btnMedium);
        add(btnLarge);
        add(btnColor);
        add(btnSave);
        add(btnLoad);
        add(btnRect);
        add(btnRoundRect);
        add(btnEllipse);
        add(btnCurve);
        add(btnLine);

        
        for (Component c : this.getComponents()) {
        	c.setFont(font);
		}
        

    }
}

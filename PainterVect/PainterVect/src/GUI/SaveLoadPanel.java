package GUI;

import Utils.XCommand;

import javax.swing.*;

public class SaveLoadPanel extends JPanel {

    public SaveLoadPanel(XCommand cmd) {

        setLayout(null);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(10, 0, 100, 30);
        JButton btnLoad = new JButton("Load");
        btnLoad.setBounds(10, 40, 100, 30);

        btnLoad.addActionListener(cmd.actionOpen);
        btnSave.addActionListener(cmd.actionSave);

        add(btnSave);
        add(btnLoad);

    }
}

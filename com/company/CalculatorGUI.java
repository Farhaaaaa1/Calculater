package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    MouseButton changer;
    public String primitive = "0";
    public String seccond = "0";
    public String oprator = "";
    public Boolean isRes = true;

    public CalculatorGUI() {

       JMenuBar mb = new JMenuBar();
        JMenu fileMenue = new JMenu("Menue");
        JMenu fileMenue1 = new JMenu("Menue1");
        JMenu x = new JMenu("Menu");
        JMenuItem m1 = new JMenuItem("MenuItem1");
        JMenuItem m2 = new JMenuItem("MenuItem2");
        JMenuItem m3 = new JMenuItem("MenuItem3");
        x.add(m1);
        x.add(m2);
        x.add(m3);
        mb.add(x);
        setJMenuBar(mb);



        setIconImage(new ImageIcon("src/eraser.png").getImage());
        JTextArea display = new JTextArea(10, 3);
        KeyListener a;
        setTitle("AUT Calculator");
        setSize(230, 320);
        setLocation(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton ac = new JButton(new ImageIcon("src/eraser.png"));
        ac.setBounds(165, 20, 40, 40);
        ac.setFocusable(false);
        add(ac);
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(" ");
            }
        });
        display.setEditable(false);
        display.addKeyListener(a = new KeyListener(display));
        display.setFont(new Font("ARIAL", 14, 14));
        display.setSize(150, 40);
        display.setLocation(15, 20);
        display.setText(" ");
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(6, 3));
        String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "00"};
        for (int i = 0; i < num.length; ++i) {
            JButton btn = new JButton();
            btn.setFocusable(false);
            btn.setOpaque(false);
            btn.setBorderPainted(true);
            btn.setText(num[i]);
            changer = new MouseButton(btn);
            btn.addMouseListener(changer);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isRes == false) {
                        display.setText("");
                        isRes = true;
                    }

                    String k = display.getText();
                    k += btn.getText();
                    display.setText(k);
                    oprator = "";
                }
            });
            keyboardPanel.add(btn);
        }
        Oprator o;
        String[] opr = {"+", "-", "/", "%", "*", "=", "."};
        for (int i = 0; i < opr.length; ++i) {
            JButton btn = new JButton();
            btn.setText(opr[i]);
            btn.setFocusable(false);
            keyboardPanel.add(btn);
            changer = new MouseButton(btn);
            btn.addMouseListener(changer);
            btn.addActionListener(o = new Oprator(btn, display, this));
        }

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        JPanel p2 = new JPanel();
        p1.add(keyboardPanel);
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0, 70, 200, 220);
        tp.add("mamooli", p1);
        tp.add("mohandesi", p2);

        add(tp);
        add(display);
        setFocusable(false);
        //getContentPane().add(scrollPane);
        setVisible(true);

    }

    private void setMenuBar(JMenuBar mb) {
    }
}

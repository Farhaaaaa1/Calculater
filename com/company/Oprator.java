package com.company;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Oprator implements ActionListener {
    JButton button = new JButton();
    JTextArea display;
    CalculatorGUI frame;
    String res;
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String[] opr = {"+", "-", "/", "%", "*", "."};
    String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};
    List<String> list1 = Arrays.asList(opr);
    List<String> list2 = Arrays.asList(num);
    public Oprator(JButton button, JTextArea display, CalculatorGUI farme) {
        this.button = button;
        this.display = display;
        this.frame = farme;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = (" " + display.getText().replaceAll(" ", ""));
        String last = String.valueOf(a.charAt(a.length() - 1));
        if (!button.getText().equals("=") && frame.oprator.equals("")&& list2.contains(String.valueOf(last))) {
            frame.isRes = true ;
            display.setText(display.getText() + button.getText());

        } else if (button.getText().equals("=")&&list2.contains(String.valueOf(last))) {
            try {
                String A = display.getText().replaceAll(" ","");
                frame.isRes = false;
                frame.oprator = "";
                display.setText(String.valueOf(engine.eval(A)));
            } catch (ScriptException ex) {
                ex.printStackTrace();
            }
        }
    }
}

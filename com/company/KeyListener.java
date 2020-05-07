package com.company;

import com.sun.tools.javac.util.ArrayUtils;

import javax.swing.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class KeyListener extends KeyAdapter {
    JTextArea area;

    public KeyListener(JTextArea area) {
        this.area = area;
    }

    String[] opr = {"+", "-", "/", "%", "*", "."};
    String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};
    List<String> list1 = Arrays.asList(opr);
    List<String> list2 = Arrays.asList(num);

    public void keyPressed(KeyEvent e) {
        String a = (" " + area.getText().replaceAll(" ", ""));
        String last = String.valueOf(a.charAt(a.length() - 1));
        if (list1.contains(String.valueOf(e.getKeyChar())) && list2.contains(String.valueOf(last)))
            area.setText(area.getText() + String.valueOf(e.getKeyChar()));

        if (list2.contains(String.valueOf(e.getKeyChar())))
            area.setText(area.getText() + String.valueOf(e.getKeyChar()));

    }


}
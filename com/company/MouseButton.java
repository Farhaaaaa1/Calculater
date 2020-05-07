package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseButton extends MouseAdapter {
    Color color;
    JButton button = new JButton();
    public MouseButton(JButton button) {
        this.button = button;
        color = button.getBackground();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        button.setForeground(Color.red);
        color = button.getBackground();
        button.setBackground(Color.BLACK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        button.setForeground(Color.BLACK);
        button.setBackground(color);
    }
}

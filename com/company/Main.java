package com.company;

import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
// try {
//         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//         if ("Nimbus".equals(info.getName())) {
//         UIManager.setLookAndFeel(info.getClassName());
//         break;
//         }
//         }
//         } catch (Exception e) {
//         // If Nimbus is not available, you can set the GUI to another look and feel.
//         }

public class Main {
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        CalculatorGUI salam = new CalculatorGUI();
        // TabbedPaneExample() ;
    }
}

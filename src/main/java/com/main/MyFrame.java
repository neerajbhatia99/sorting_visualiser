package com.main;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    private MyCanvas canvas;
    public MyFrame(MyCanvas canvas) {
        this.canvas = canvas;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        add(canvas);
        pack();

    }
}

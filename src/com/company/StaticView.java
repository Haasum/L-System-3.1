package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;


public class StaticView extends JFrame {
    static Dimension screenSize;
    JPanel turtle;
    RecursiveLsys lsys;
    Texture texture;

    public StaticView(RecursiveLsys lsys){
        this.lsys = lsys;
        drawFrame();

        drawMainPanel();
        texture = new Texture(true);

    }

    private void drawMainPanel() {

        turtle = new DynamicView(lsys);
        turtle.setVisible(true);
        turtle.setSize(screenSize);
        turtle.setBackground(new Color(99, 125, 150));
        turtle.setLayout(null);
        this.add(turtle, BorderLayout.CENTER);

    }

    private void drawFrame() {
        setTitle("Growing Tree 2");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        setLayout(new BorderLayout());
        setLocation(500,0);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addExpandKeyListener(KeyListener listener){
        turtle.addKeyListener(listener);
    }

    public void addListeners(KeyListener keyListener){
        turtle.addKeyListener(keyListener);
    }
    }


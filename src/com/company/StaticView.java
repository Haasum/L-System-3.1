package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;


public class StaticView extends JFrame {
    static Dimension screenSize;
    JPanel dynamicView;
    RecursiveLsys lsys;
    Texture texture;

    public StaticView(RecursiveLsys lsys){
        this.lsys = lsys;
        drawFrame();

        drawMainPanel();
        texture = new Texture(true);

    }

    private void drawMainPanel() {

        dynamicView = new DynamicView(lsys);
        dynamicView.setVisible(true);
        dynamicView.setSize(screenSize);
        dynamicView.setBackground(new Color(99, 125, 150));
        dynamicView.setLayout(null);
        this.add(dynamicView, BorderLayout.CENTER);

    }

    private void drawFrame() {
        setTitle("Growing Tree 2");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        setLayout(new BorderLayout());
        setLocation(0,0);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addExpandKeyListener(KeyListener listener){
        dynamicView.addKeyListener(listener);
    }

    public void addListeners(KeyListener keyListener){
        dynamicView.addKeyListener(keyListener);
    }
    }


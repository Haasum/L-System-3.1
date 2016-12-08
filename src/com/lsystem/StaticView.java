package com.lsystem;

import javax.swing.*;
import java.awt.*;

import static com.lsystem.DynamicView.screenHeight;
import static com.lsystem.DynamicView.screenWidth;




public class StaticView extends JFrame {
    static Dimension screenSize;
    JPanel dynamicView;
    MenuPanel menuPanel;
    RecursiveLsys lsys;
    Texture texture;
    final static int MENU_WIDTH = 100;


    public StaticView(RecursiveLsys lsys){
        this.lsys = lsys;
        drawFrame();

        drawMainPanel();
        drawMenuPanel();

        texture = new Texture(true);

    }

    private void drawMainPanel() {

        dynamicView = new DynamicView(lsys);
        dynamicView.setVisible(true);
        dynamicView.setSize(screenWidth-MENU_WIDTH,screenHeight);
        dynamicView.setBackground(new Color(99, 125, 150));
        dynamicView.setLayout(null);
        dynamicView.setLocation(MENU_WIDTH,0);
        this.add(dynamicView);

    }

    private void drawFrame() {
        setTitle("Growing Tree 2");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void drawMenuPanel() {
        menuPanel = new MenuPanel(lsys, this);
        menuPanel.setVisible(true);
        menuPanel.setSize(MENU_WIDTH, screenHeight);
        menuPanel.setBackground(new Color(255,255,255));
        menuPanel.setLayout(null);
        menuPanel.setLocation(0,0);
        this.add(menuPanel);
    }

    public void addListeners(ExpandKeyListener expandKeyListener){

        dynamicView.addKeyListener(expandKeyListener);
    }
}


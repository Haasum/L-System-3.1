package com.lsystem.view;

import com.lsystem.control.UserInput;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static com.lsystem.view.DynamicView.screenHeight;
import static com.lsystem.view.DynamicView.screenWidth;




public class StaticView extends JFrame {
    final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel dynamicView;
    MenuPanel menuPanel;
    RecursiveLsystem lsystem;
    VisualComponents visualComponents;

    final static int MENU_WIDTH = 150; //MENU_WIDTH is declared and assigned the final value 150

    public StaticView(RecursiveLsystem lsystem){
        this.lsystem = lsystem;
        drawMainFrame();
        drawMainPanel();
        drawMenuPanel();

        visualComponents = new VisualComponents(true);

    }

    /**
     * Creates the main panel.
     * <p>
     *     This initializes the dynamicView object, which is also refered to as the mainPanel.
     * </p>
     */
    private void drawMainPanel() {
        dynamicView = new DynamicView(lsystem);
        dynamicView.setVisible(true);
        dynamicView.setSize(screenWidth-MENU_WIDTH,screenHeight); //the size of the dynamicView panel is corresponding to the current screensize
        dynamicView.setBackground(Color.WHITE);
        dynamicView.setLayout(null);
        dynamicView.setLocation(MENU_WIDTH,0);
        this.add(dynamicView);
    }

    /**
     * Sets properties for the program frame.
     * <p>
     *     This sets the properties for the program frame, refered to as the Main Frame, or staticView.
     *     This contains the properties, e.g. size, layout and title.
     * </p>
     */
    private void drawMainFrame() {
        setTitle("Growing Tree");
        setSize(SCREEN_SIZE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Creates the menu panel.
     * <p>
     *     This creates an instance of the Menu Panel object.
     *     This also sets the basic properties for that panel, e.g. size, layout and location.
     * </p>
     */
    private void drawMenuPanel() {

        menuPanel = new MenuPanel(lsystem, dynamicView, this);
        menuPanel.setVisible(true);
        menuPanel.setSize(MENU_WIDTH, screenHeight);
        menuPanel.setBackground(new Color(255,255,255));
        menuPanel.setLayout(null);
        menuPanel.setFocusable(true);
        menuPanel.setLocation(0,0);
        this.add(menuPanel);
    }

    /**
     * //TODO: mangler!!! hilsen naja
     * @param userInput is the chosen userinput
     */
    public void addListeners(UserInput userInput){ //TODO: userinput.fetchinputType. man skal ikke se i koden at det er en keylistener eller en leaplistener

            this.addKeyListener((KeyListener) userInput);
            dynamicView.addKeyListener((KeyListener) userInput);

    }
}


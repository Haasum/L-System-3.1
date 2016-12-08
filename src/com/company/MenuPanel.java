package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by naja on 08-12-2016.
 */
public class MenuPanel extends JPanel {
    RecursiveLsys lsys;
    Texture texture;
    public enum InputType {LEAPLISTENER, KEYLISTENER};

    public MenuPanel(RecursiveLsys lsys) {
        this.lsys = lsys;
        makeViewButtons();
        makeInputButtons();
    }

    private void makeInputButtons() {
        JLabel inputLabel = new JLabel("Input Type:");
        inputLabel.setLocation(10, 220);
        inputLabel.setSize(100, 30);
        this.add(inputLabel);
        int y = 200;

        for (InputType k: InputType.values()) {
            y += 60;
            JButton inputbutton = new JButton();
            inputbutton.setLocation(10, y);
            inputbutton.setBackground(Color.darkGray);
            inputbutton.setSize(50, 50);
            this.add(inputbutton);


        }

    }


    private void makeViewButtons() {

        JLabel textureLabel = new JLabel("Texture on/off");
        textureLabel.setLocation(10, 50);
        textureLabel.setSize(100, 30);
        this.add(textureLabel);

        Button leafbuttonGrow = new Button("ON");
        leafbuttonGrow.setLocation(10, 100);
        leafbuttonGrow.setBackground(Color.green);
        leafbuttonGrow.setSize(50, 50);
        this.add(leafbuttonGrow);

        leafbuttonGrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("put texture on tree");
                texture = new Texture(true);
            }
        });
        Button leafbuttonKill = new Button("OFF");
        leafbuttonKill.setLocation(10, 160);
        leafbuttonKill.setBackground(Color.black);
        leafbuttonKill.setSize(50, 50);
        this.add(leafbuttonKill);
        leafbuttonKill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("remove texture on tree");
                texture = new Texture(false);
            }
        });
    }
}

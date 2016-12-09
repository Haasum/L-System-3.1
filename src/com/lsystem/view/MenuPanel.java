package com.lsystem.view;

import com.lsystem.control.UserInput;
import com.lsystem.control.UserInputFactory;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


public class MenuPanel extends JPanel {
    RecursiveLsystem lsys;
    VisualComponents visualComponents;

    public enum InputType {LEAPLISTENER, KEYLISTENER}

    ;
    private Map<JButton, InputType> inputTypeMap; //TODO: bruges til leapmotion - må ikke slettes
    UserInput userInput;
    StaticView staticView;
    JPanel dynamicView;

    public MenuPanel(RecursiveLsystem lsys, JPanel dynamicView, StaticView staticView) {
        this.staticView = staticView;
        this.dynamicView = dynamicView;
        this.lsys = lsys;
        makeTextureButtons();
        makeInputButtons();
    }

    private void makeInputButtons() { //TODO: Til leapmotion - må ikke slettes
        JLabel inputLabel = new JLabel("Input Type:");
        inputLabel.setLocation(10, 220);
        inputLabel.setSize(100, 30);
        this.add(inputLabel);
        int y = 200;

        for (InputType it : InputType.values()) {
            y += 60;
            JButton inputbutton = new JButton();
            inputbutton.setLocation(10, y);
            inputbutton.setBackground(Color.darkGray);
            inputbutton.setSize(50, 50);
            this.add(inputbutton);

            inputbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserInputFactory userInputFactory = new UserInputFactory(lsys);
                    userInput = userInputFactory.fetchUserInput(it);
                    staticView.addListeners(userInput);
                }
            });
        }
    }


    private void makeTextureButtons() {

        JLabel textureLabel = new JLabel("VisualComponents on/off");
        textureLabel.setLocation(10, 50);
        textureLabel.setSize(100, 30);
        this.add(textureLabel);

        Button textureOnBtn = new Button("ON");
        textureOnBtn.setLocation(10, 100);
        textureOnBtn.setBackground(Color.green);
        textureOnBtn.setSize(50, 50);
        this.add(textureOnBtn);

        textureOnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                visualComponents = new VisualComponents(true);
            }
        });
        Button textureOffBtn = new Button("OFF");
        textureOffBtn.setLocation(10, 160);
        textureOffBtn.setBackground(Color.black);
        textureOffBtn.setSize(50, 50);
        this.add(textureOffBtn);
        textureOffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                visualComponents = new VisualComponents(false);
            }
        });
    }
}

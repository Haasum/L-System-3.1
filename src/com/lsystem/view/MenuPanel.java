package com.lsystem.view;

import com.lsystem.control.UserInput;
import com.lsystem.control.UserInputFactory;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static com.lsystem.view.StaticView.MENU_WIDTH;


public class MenuPanel extends JPanel {
    RecursiveLsystem lsys;
    VisualComponents visualComponents;
    public static final int MENU_MIDDLE = MENU_WIDTH/2;


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

    /**
     * Creates the input buttons.
     * <p>
     *     This creates the input buttons, which are used to choose the preferred input for the user.
     *     This also creates the actionlistener for the inputbuttons.
     * </p>
     */
    private void makeInputButtons() { //TODO: Til leapmotion - må ikke slettes
        JLabel inputLabel = new JLabel("CHOSE INPUT");
        inputLabel.setLocation(MENU_MIDDLE-40, 230);
        inputLabel.setSize(80, 30);
        this.add(inputLabel);
        int y = 200;

        for (InputType it : InputType.values()) { //for-each loop which creates a button for each inputType.
            y += 60;

            Button inputbutton = new Button(String.valueOf(it));
            inputbutton.setLocation(MENU_MIDDLE-50, y);
            inputbutton.setBackground(Color.lightGray);
            inputbutton.setSize(100, 50);
            this.add(inputbutton);

            inputbutton.addActionListener(new ActionListener() { //adds a new actionlistener for each button
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserInputFactory userInputFactory = new UserInputFactory(lsys); //initialize the user input factory
                    userInput = userInputFactory.fetchUserInput(it); //the userinput-type is fetched
                    staticView.addListeners(userInput); //the choosen input type is added to the static view
                }
            });
        }
    }

    /**
     * Creates texture buttons.
     * <p>
     *     This creates the two buttons "TEXTURE ON" and "TEXTURE OFF".
     *     The buttons contains an actionlistener, which changes the visualcomponents,
     *     thereby removing or applying texture to the view.
     * </p>
     */
    private void makeTextureButtons() {

        JLabel textureLabel = new JLabel("TEXTURE ON/OFF");
        textureLabel.setLocation(MENU_MIDDLE-50, 70);
        textureLabel.setSize(100, 30);
        this.add(textureLabel);

        Button textureOnBtn = new Button("TEXTURE ON"); //Creates the "TEXTURE ON" button
        textureOnBtn.setLocation(MENU_MIDDLE-50, 100);
        textureOnBtn.setBackground(Color.lightGray);
        textureOnBtn.setSize(100, 50);
        this.add(textureOnBtn);

        textureOnBtn.addActionListener(new ActionListener() { //Actionlistener for the button
            @Override
            public void actionPerformed(ActionEvent e) {
                visualComponents = new VisualComponents(true); //creates af ned instance of the Visual componentClass
            }
        });

        Button textureOffBtn = new Button("TEXTURE OFF"); //creates the "TEXTURE OFF" button
        textureOffBtn.setBackground(Color.LIGHT_GRAY);
        textureOffBtn.setLocation(MENU_MIDDLE-50, 160);
        textureOffBtn.setSize(100, 50);
        this.add(textureOffBtn);
        textureOffBtn.addActionListener(new ActionListener() { //actionlistener for the button
            @Override
            public void actionPerformed(ActionEvent e) {
                visualComponents = new VisualComponents(false);//creates af ned instance of the Visual componentClass
            }
        });
    }
}

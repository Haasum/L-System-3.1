package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;
import com.lsystem.view.MenuPanel;
import com.lsystem.view.StaticView;

public class UserInputFactory {

    RecursiveLsystem lsys;
    MenuPanel.InputType inputType;
    StaticView staticView;
  //  public enum InputType {LEAPLISTENER, KEYLISTENER};

    public UserInputFactory(RecursiveLsystem lsys) {
        this.lsys = lsys;
    }

    public UserInput fetchUserInput(MenuPanel.InputType inputType) {

        switch (inputType) {
            case LEAPLISTENER:
                System.out.println("Leap er nice nu");
                break;

            case KEYLISTENER:
                System.out.println("Jeg har sgu fundet mig en keylistener");
                return new ExpandKeyListener(lsys);

            default:
                System.out.println("I can't detect any user input, please try again");
        }
        return null;
    }
}
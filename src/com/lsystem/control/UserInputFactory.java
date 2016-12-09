package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;
import com.lsystem.view.MenuPanel;
import com.lsystem.view.StaticView;

public class UserInputFactory {

    RecursiveLsystem lsystem;
    MenuPanel.InputType inputType;
    StaticView staticView;
  //  public enum InputType {LEAPLISTENER, KEYLISTENER};

    public UserInputFactory(RecursiveLsystem lsystem) {
        this.lsystem = lsystem;
    }

    public UserInput fetchUserInput(MenuPanel.InputType inputType) {

        switch (inputType) {
            case LEAPLISTENER:
               // return new LeapListener(controller2,lsystem);
                return null;
            case KEYLISTENER:
                return new ExpandKeyListener(lsystem);

            default:
                return null;
        }
    }
}
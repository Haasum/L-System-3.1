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
                break;
            case KEYLISTENER:
                return new ExpandKeyListener(lsys);

            default:
                return null;
        }
        return null;
    }
}
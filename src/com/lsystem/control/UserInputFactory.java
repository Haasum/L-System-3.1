package com.lsystem.control;

import com.leapmotion.leap.Controller;
import com.lsystem.LeapListener;
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
               // return new LeapListener(controller2,lsys);
                return null;
            case KEYLISTENER:
                return new ExpandKeyListener(lsys);

            default:
                return null;
        }
    }
}
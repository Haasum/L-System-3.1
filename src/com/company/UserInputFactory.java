package com.company;

public class UserInputFactory {

    RecursiveLsys lsys;
    MenuPanel.InputType inputType;
    StaticView staticView;
  //  public enum InputType {LEAPLISTENER, KEYLISTENER};

    public UserInputFactory(RecursiveLsys lsys) {
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
package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;
import com.lsystem.view.MenuPanel;
import com.lsystem.view.StaticView;

public class UserInputFactory {

    RecursiveLsystem lsystem;
    MenuPanel.InputType inputType;
    StaticView staticView;
  //  public enum InputType {LEAPLISTENER, KEYLISTENER};

    /***
     * Constructs the UserInputFactory
     * @param lsystem the current instance of the RecursiveLsystem Class
     */
    public UserInputFactory(RecursiveLsystem lsystem) {
        this.lsystem = lsystem;
    }

    /***
     * Sets the userinput-type.
     * <p>
     *     This runs when a user input is chosen (by clicking one of the buttons on the left side of the program).
     *     This contains a switch case, with a case for every type of input type.
     *     If the program had one more inputtype (e.g. a kinect sensor), the switch case should contain
     *     a case relative to that input.
     *
     *     For now the method initializes the ExpandKeyListener klasse, if the case (=the user input) is KEYLISTENER.
     * </p>
     * @param inputType the type of input chosen by the user
     * @return the chosen user input
     */
    public UserInput fetchUserInput(MenuPanel.InputType inputType) {

        switch (inputType) {
            case LEAPLISTENER:
               /* Here a leapListener should be initialized. This is not working. But it should look like this next line:
               return new LeapListener(controller2,lsystem); */
                return null;
            case KEYLISTENER:
                return new ExpandKeyListener(lsystem); //initialize new instance of the expandKeyListener class
            default:
                return null;
        }
    }
}
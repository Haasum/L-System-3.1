

package com.lsystem.control;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.lsystem.model.RecursiveLsystem;


public class LeapListener extends Listener implements UserInput {

    //True for Debugging
    boolean DEBUG = true;
    boolean USE_CALIBRATED_SCREEN = true;

    //Just to control the speed, it can be changed accordingly to needs
    int SLOW = 150;

    float cur_x = 0, cur_y = 0;
    int fingers_count = 0;
    int prev_fingers_count = 0;

    private float x;
    private float y;
    boolean isConnected;

    RecursiveLsystem lsys;
    String treeToExpand;
    String expandedTree;


    public LeapListener(Controller leapController, RecursiveLsystem lsys) {
        this.lsys = lsys;
        System.out.println("is called");

    }

    /**
     * Lets the user know that the leap Motion sensor is connected.
     * <p>
     *     this runs when the leap motion sensor is connected, and prints out a system print,
     *     which state that very same thing
     * </p>
     * @param leapController the controller for the leap motion sensor
     * */

    public void onConnect(Controller leapController) {
        System.out.println("LeapMotion is Connected");
        isConnected = true;
    }

    /**
     * Lets the user know that the leap Motion sensor is disconnected.
     * <p>
     *     this runs when the leap motion sensor is disconnected, and prints out a system print,
     *     which state that very same thing
     * </p>
     * @param leapController the controller for the leap motion sensor
     * */

    public void onDisconnect(Controller leapController) {
        System.out.println("LeapMotion is Disconnected");
        isConnected = false;
    }

    /**
     * Lets the user know that the program is exited.
     * <p>
     *     this runs when the program is exited, and prints out a system print,
     *     which state that very same thing
     * </p>
     * @param leapController the controller for the leap motion sensor
     * */

    public void onExit(Controller leapController) {
        System.out.println("Exited");
        System.exit(0);
    }

    /**
     * Checks for movement on the leap motion sensor.
     * <p>
     *     This runs every frame, and checks for gestures.
     *     If there are any gestures, the method will check if any of the gestures was a Swipe (a specific hand movement).
     *     If so, a method to expand the tree one generation is called.
     * </p>
     * */

    public void onFrame(Controller leapController) {
        // Get the most recent frame and report some basic information
        Frame frame = leapController.frame();

        int numGestures = frame.gestures().count(); //counts the no of gestures is the frame

        for (int i = 0; i < numGestures; i++) { //for loop that runs for every gesture in the frame
            if (frame.gestures().get(i).type() == Gesture.Type.TYPE_SWIPE) {  //check if the gesture was a'swipe'
                expandGeneration(lsys); //if so, the method to expand the tree is called
                slow();


            }
        }
    }    private void slow() {
        try {
            Thread.sleep(SLOW);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Expands the tree one generation.
     * <p>
     *     This expands the three by one generation.
     *     First of all the method checks if the three has been expanded the maximum amount.
     *     If not, the current tree string will be fetched and expanded, and thereby the new tree String is sat
     * </p>
     * @param lsystem an instance of the class RecursiveLsystem
     * */

    @Override
    public void expandGeneration(RecursiveLsystem lsystem) {
        System.out.println("tree is now expanding");
        //TODO: her tilføjes expand agtig metode
        treeToExpand = lsystem.getTreeString();
        expandedTree = lsystem.expand(treeToExpand, 1);
        lsystem.setTreeString(expandedTree);

    }
}
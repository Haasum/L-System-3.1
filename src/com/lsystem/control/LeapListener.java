/*

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
    int SLOW = 40;


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


    public void onConnect(Controller leapController) {
        System.out.println("LeapMotion is Connected");
        isConnected = true;
    }

    public void onDisconnect(Controller leapController) {
        System.out.println("LeapMotion is Disconnected");
        isConnected = false;
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
        System.exit(0);
    }

    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();

        int numGestures = frame.gestures().count();

        for (int i = 0; i < numGestures; i++) {


            if (frame.gestures().get(i).type() == Gesture.Type.TYPE_SWIPE) {
                expandGeneration(lsys);


            }
        }
    }

    @Override
    public void expandGeneration(RecursiveLsystem lsystem) {
        System.out.println("tree is now expanding");
        //TODO: her tilføjes expand agtig metode
        treeToExpand = lsystem.getTreeString();
        expandedTree = lsystem.expand(treeToExpand, 1);
        lsystem.setTreeString(expandedTree);

    }
}

*/
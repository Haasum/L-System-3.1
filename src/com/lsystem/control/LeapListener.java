/*

package com.lsystem.control;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Frame;
import com.lsystem.model.RecursiveLsystem;


import static com.lsystem.view.DynamicView.screenHeight;
import static com.lsystem.view.DynamicView.screenWidth;


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
        ;
        slow();
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
            slow();

            if (!frame.fingers().isEmpty()) {

                // Get fingers
                FingerList fingers = frame.fingers();
                fingers_count = frame.fingers().count();

                if (DEBUG && fingers_count != prev_fingers_count) {
                    System.out.println("Currently " + fingers_count + " fingers visible.\n");
                    prev_fingers_count = fingers_count;
                }


                if (!fingers.isEmpty()) {
                    // Calculate the hand's average finger tip position
                    Vector avgPos = Vector.zero();
                    for (Finger finger : fingers) {
                        avgPos = avgPos.plus(finger.tipPosition());
                    }
                    avgPos = avgPos.divide(fingers.count());


                    if (USE_CALIBRATED_SCREEN) {
                        //New Pointing System using first calibrated screen. Thanks to wooster @ freenode IRC
                        ScreenList screens = controller.locatedScreens();

                        if (screens.isEmpty()) return;
                        Screen s = screens.get(0);
                        PointableList pointables = frame.hands().get(0).pointables();

                        if (pointables.isEmpty()) return;
                        Pointable firstPointable = pointables.get(0);
                        Vector intersection = s.intersect(
                                firstPointable,
                                true, // normalize
                                1.0f // clampRatio
                        );
                        // if the user is not pointing at the screen all components of
                        // the returned vector will be Not A Number (NaN)
                        // isValid() returns true only if all components are finite
                        if (!intersection.isValid()) return;

                        float x = s.widthPixels() * intersection.getX();
                        // flip y coordinate to standard top-left origin
                        float y = s.heightPixels() * (1.0f - intersection.getY());

                        System.out.println("x pos is " + x + " & y pos is " + y);


                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Slows down the frame rate
    private void slow() {
        try {
            Thread.sleep(SLOW);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
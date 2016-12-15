/*

package com.lsystem;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Frame;
import com.lsystem.control.UserInput;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;

import static com.lsystem.view.DynamicView.screenHeight;
import static com.lsystem.view.DynamicView.screenWidth;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class LeapListener extends Listener implements UserInput {

    //True for Debugging
    boolean DEBUG = true;
    boolean USE_CALIBRATED_SCREEN = true;

    //Just to control the speed, it can be changed accordingly to needs
    int SLOW = 10;

    //Screen resolution, it should match the current screen resolution for more precise movements
    int SCREEN_X = screenWidth;
    int SCREEN_Y = screenHeight;

    float cur_x = 0, cur_y = 0;
    int fingers_count = 0;
    int prev_fingers_count = 0;
    JLabel handLabel;
    JPanel leapPanel;

    private float x;
    private float y;
    boolean isConnected;

    RecursiveLsystem lsys;
    String treeToExpand;
    String expandedTree;


    public LeapListener(Controller leapController, RecursiveLsystem lsys) {
        this.lsys = lsys;
        System.out.println("is called");
        //onInit(leapController);
      //  makeLeapFrame();
        slow();
    }


    private void makeLeapFrame() {
        JFrame leapFrame = new JFrame();
        leapFrame.setSize(200,200);
        leapFrame.setTitle("leap motion");
        leapFrame.setVisible(true);
        leapFrame.setLayout(new BorderLayout());
        leapFrame.setLocation(0,0);
        leapFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel leapPanel = new JPanel();
        leapPanel.setLayout(null);
        leapFrame.add(leapPanel);
        leapPanel.setBackground(Color.white);



        JLabel handLabel = new JLabel("H");
        handLabel.setBounds((int) getX(),(int) getY(),10,10);
        leapPanel.add(handLabel);

    }


    public void onInit(Controller controller) {
        System.out.println("Initialized");
        System.out.println("Current screen resolution: " + SCREEN_X + "x" + SCREEN_Y);
    }

    public void onConnect(Controller leapController) {
        System.out.println("Connected");
        isConnected = true;
    }

    public void onDisconnect(Controller leapController) {
        System.out.println("Disconnected");
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
                        //         moveMouse(x, y);

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

        public void moveMouse(float x, float y) {
            Robot mouseHandler;

            if (cur_x != x || cur_y != y) {

                cur_x = x;
                cur_y = y;

                try {

                    mouseHandler = new Robot();
                    mouseHandler.mouseMove((int) x, (int) y);

                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void expandGeneration(RecursiveLsystem lsys) {
        System.out.println("Det virker");
        //TODO: her tilføjes expand agtig metode
        treeToExpand = lsys.getTreeString();
        expandedTree = lsys.expand(treeToExpand,1);
        lsys.setTreeString(expandedTree);

    }
}

*/
package com.company;

import java.io.IOException;

public class Controller {

    public Controller(IOException){//com.leapmotion.leap.Controller controller2) {

        txt test = new txt();
        String txtFile = test.checkTxt();

        //Txt textFileReader = new Txt();
        //String textFileString = textFileReader.getTxtInput();

        Grammatik grammatik = new Grammatik(textFileString);
        RecursiveLsys lsys = new RecursiveLsys(grammatik);
        //String tree = lsys.getTree();

        StaticView staticView = new StaticView(lsys);


        // Listeners:

        ExpandKeyListener expandKeyListener = new ExpandKeyListener(lsys);
/*
TODO: følgende er det der kalder leapListener. udkommenteret i denne version
        LeapListener listener = new LeapListener(controller2, lsys);
        controller2.enableGesture(Gesture.Type.TYPE_SWIPE);//  controller.enableGesture( Gesture.Type.TYPE_CIRCLE );
        controller2.addListener(listener);
        System.out.println("Press Enter to quit..."); // Keep this process running until Enter is pressed
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller2.removeListener(listener); */

        staticView.addKeyListener(expandKeyListener);
        staticView.addListeners(expandKeyListener);


    }


}
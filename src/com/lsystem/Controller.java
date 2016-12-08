package com.lsystem;

import com.lsystem.control.ExpandKeyListener;
import com.lsystem.control.Txt;
import com.lsystem.model.Grammatik;
import com.lsystem.model.RecursiveLsys;
import com.lsystem.view.StaticView;

import java.io.IOException;

public class Controller {

    public Controller() throws IOException { //TODO: leapmotion: //IOException){//com.leapmotion.leap.Controller controller2) {


        Txt textFileReader = new Txt();
        String txtFileString = textFileReader.checkTxt();


        Grammatik grammatik = new Grammatik(txtFileString);
        RecursiveLsys lsys = new RecursiveLsys(grammatik);

        StaticView staticView = new StaticView(lsys);

        ExpandKeyListener expandKeyListener = new ExpandKeyListener(lsys);
        staticView.addKeyListener(expandKeyListener);
        staticView.addListeners(expandKeyListener);

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


    }


}
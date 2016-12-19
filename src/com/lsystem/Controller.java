package com.lsystem;

//TODO: OBS! leap er slået fra - er det korrekt?

import com.leapmotion.leap.Gesture;
import com.lsystem.model.Grammatik;
import com.lsystem.model.RecursiveLsystem;
import com.lsystem.model.TextfileReader;
import com.lsystem.view.StaticView;

import java.io.IOException;

public class Controller {

    /**
     * Constructs the controller object.
     * <p>
     *     This controls all the objects (classes) that are initialized in the initialization of the program.
     * </p>
     * @throws IOException
     */
    public Controller(com.leapmotion.leap.Controller leapController) throws IOException {

        TextfileReader textFileReader = new TextfileReader();
        String textFileString = textFileReader.getText();
        Grammatik grammatik = new Grammatik(textFileString);
        RecursiveLsystem lsystem = new RecursiveLsystem(grammatik);
        StaticView staticView = new StaticView(lsystem);


//TODO: følgende er det der kalder leapListener. udkommenteret i denne version
        com.lsystem.control.LeapListener listener = new com.lsystem.control.LeapListener(leapController, lsystem);
        leapController.enableGesture(Gesture.Type.TYPE_SWIPE);//  controller.enableGesture( Gesture.Type.TYPE_CIRCLE );
        leapController.addListener(listener);

        System.out.println("Press Enter to quit..."); // Keep this process running until Enter is pressed
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        leapController.removeListener(listener);

    }


}

  //   ExpandKeyListener expandKeyListener = new ExpandKeyListener(lsystem);
    //  staticView.addKeyListener(expandKeyListener);
      // staticView.addListeners(expandKeyListener);

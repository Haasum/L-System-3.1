package com.lsystem.control;

import com.lsystem.model.NonTerminalExpander;
import com.lsystem.model.RecursiveLsystem;
import com.lsystem.view.DynamicView;
import com.lsystem.view.NonTerminal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class NonTerminalMouseListener implements MouseListener{
    RecursiveLsystem lsystem;
    DynamicView dynamicView;
    int mouseX;
    int mouseY;
    ArrayList<NonTerminal> allNonTerminals;

    /**
     * Constructs the NonTerminal MouseListener
     * @param dynamicView the current instance of the dynamicView class
     * @param lsystem the current instance of the RecursiveLsystem class
     */
    public NonTerminalMouseListener(DynamicView dynamicView, RecursiveLsystem lsystem){
        this.dynamicView = dynamicView;
        this.lsystem = lsystem;
        dynamicView.addMouseListener(this);
    }

    /**
     * Gets position of the mouse.
     * <p>
     *     This runs if the mouse is clicked.
     *     If so, this gets the position of the mouse.
     *     Last a method to fetch the non terminals ('buds') in the clicked area is called.
     * </p>
     * @param e the event. holds information, e.g. the position of the mouse when it was clicked
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
        allNonTerminals = dynamicView.getAllNonTerminals();
        fetchNonTerminalInPoint();

    }

    /**
     * Gets the non terminals ('buds') in the clicked area.
     * <p>
     *     This contains a foreach loop, that checks all the non terminals.
     *     If a non terminal contains the mouse position, the non terminal is added
     *     to an array of non terminals in point.
     * </p>
     */
    public void fetchNonTerminalInPoint() {
        ArrayList<NonTerminal> nonTerminalsInPoint = new ArrayList<NonTerminal>();
        for (NonTerminal nt : allNonTerminals) { //foreach non terminal in the allNonTerminals arraylist
            if (nt.getBud().contains(mouseX, mouseY) == true) { //if the 'bud' of the non terminal contains the mouse
                nonTerminalsInPoint.add(nt); //the non terminal are added to an array
            }
        }
        if (nonTerminalsInPoint.isEmpty() == false) {
            //        expandNonTerminals(nonTerminalsInPoint); //TODO: kan vi slette 100 p - har ikke set denne før nu 19-12
            NonTerminalExpander nonTerminalExpander = new NonTerminalExpander(nonTerminalsInPoint, lsystem);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

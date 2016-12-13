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


    public NonTerminalMouseListener(DynamicView dynamicView, RecursiveLsystem lsystem){
        this.dynamicView = dynamicView;
        this.lsystem = lsystem;
        dynamicView.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
        allNonTerminals = dynamicView.getAllNonTerminals();
        fetchNonTerminalInPoint();

    }

    public void fetchNonTerminalInPoint() {
        ArrayList<NonTerminal> nonTerminalsInPoint = new ArrayList<NonTerminal>();
        for (NonTerminal nt : allNonTerminals) {
            if (nt.getBud().contains(mouseX, mouseY) == true) {
                nonTerminalsInPoint.add(nt);
            }
        }
        if (nonTerminalsInPoint.isEmpty() == false) {
            //        expandNonTerminals(nonTerminalsInPoint);
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

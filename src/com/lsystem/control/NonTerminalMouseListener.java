package com.lsystem.control;

import com.lsystem.view.DynamicView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NonTerminalMouseListener implements MouseListener{

    DynamicView dynamicView;

    public NonTerminalMouseListener(DynamicView dynamicView){
        this.dynamicView = dynamicView;
        dynamicView.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();
        dynamicView.fetchNonTerminalInPoint(mouseX, mouseY);

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

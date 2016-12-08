package com.lsystem.control;

import com.lsystem.view.DynamicView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExpandNodeMouseListener implements MouseListener{ //TODO: ændre navn til NonTerminalMouseListener

    DynamicView dynamicView;
    Point mouseP;

    public ExpandNodeMouseListener(DynamicView dynamicView){
        this.dynamicView = dynamicView;
        dynamicView.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        mouseP = new Point(x,y);
        dynamicView.ntClicked(x, y);

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

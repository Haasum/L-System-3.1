package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

/**
 * Created by MasterWillis on 06/12/2016.
 */
public class ExpandNodeMouseListener implements MouseListener{

    Turtle turtle;
    Point mouseP;

    public ExpandNodeMouseListener(Turtle turtle){
        this.turtle = turtle;
        turtle.addMouseListener(this);
        System.out.println(turtle.getTestHashMap());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        int allowedDiff = 2;

        mouseP = new Point(x,y);
        System.out.println("mouse clicked");

        Collection<Point> nonTerminalPoints = turtle.getTestHashMap().values();

        for (Point p : nonTerminalPoints ) {

            if (((p.getX() - mouseP.getX() < allowedDiff) || (mouseP.getX() - p.getX() < allowedDiff)) && (((p.getY() - mouseP.getY() < allowedDiff) || (mouseP.getY() - p.getY() < allowedDiff))))
       {
                System.out.println("mouse is clicked on " + mouseP);
                System.out.println("JEG SKAL EKSPANDERE på punkt nr " + p);
            }
            else{
                System.out.println("ØV");
            }

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

package com.company;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class NonTerminal {
    Graphics2D g2dd;
    private AffineTransform affineTransform;
    private int x;
    private int y;
    private Point p;
    Ellipse2D ntCircle;
    DynamicView dynamicView;
    Point realX;
    static final int CIRCLE_RADIUS = 5;
    private int i;
    private char c;

    public NonTerminal(Graphics2D g2dd, AffineTransform affineTransform, DynamicView dynamicView, int i, char c){
        this.g2dd = g2dd;
        this.setAffineTransform(affineTransform);
        this.dynamicView = dynamicView;
        this.c = c;
        this.i = i;
        setScreenPosition();
        drawButton();
        setRealX();
    }


    public void setScreenPosition(){
        x = (int) getAffineTransform().getTranslateX();
        y = (int) getAffineTransform().getTranslateY();
        p = new Point(x, y);

    }

    private void setRealX() {
        realX = p.getLocation();
    }

    private void drawButton() {
        ntCircle = new Ellipse2D.Float();
        ntCircle.setFrameFromCenter(x,y,x+CIRCLE_RADIUS,y+CIRCLE_RADIUS);
        g2dd.setPaint(Color.magenta);
        g2dd.fill(ntCircle);
        g2dd.draw(ntCircle);

       // dynamicView.add(ntCircle);
    }


    private void setScreenPos() {


    }

    public Ellipse2D getNtCircle(){
        return ntCircle;
    }

    public Point getrealX() {
        return this.realX;
    }

    public AffineTransform getAffineTransform() {
        return affineTransform;
    }

    public void setAffineTransform(AffineTransform affineTransform) {
        this.affineTransform = affineTransform;
    }

    public int getI() {
        return i;
    }

    public char getC() {
        return c;
    }


/*    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }*/
}


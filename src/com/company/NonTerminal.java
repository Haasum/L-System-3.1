package com.company;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class NonTerminal {
    Graphics2D g2d;
    AffineTransform affineTransform;
    private int x;
    private int y;
    private Point p;
    Ellipse2D ntCircle;

    public NonTerminal(Graphics2D g2d, AffineTransform affineTransform){
        this.g2d = g2d;
        this.affineTransform = affineTransform;
        setScreenPosition();
        drawButton();
    }

    public void setScreenPosition(){
        x = (int)affineTransform.getTranslateX();
        y = (int)affineTransform.getTranslateY();
        p = new Point(x, y);
    }

    private Point getScreenPosition() {

        return p;
    }

    private void drawButton() {
        ntCircle = new Ellipse2D.Float();
        ntCircle.setFrameFromCenter(x,y,15,15);
        //ntCircle.setFrameFromCenter(0,0,15,15);
        g2d.draw(ntCircle);
    }
    public Ellipse2D getNtCircle(){
        return ntCircle;
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


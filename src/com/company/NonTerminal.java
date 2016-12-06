package com.company;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by MasterWillis on 06/12/2016.
 */
public class NonTerminal {
    Graphics2D g2d;
    AffineTransform affineTransform;
    private int x;
    private int y;
    private Point p;

    public NonTerminal(Graphics2D g2d, AffineTransform affineTransform) {
        this.g2d = g2d;
        this.affineTransform = affineTransform;

        setPosition();
        drawButton();
    }

    private void setPosition() {
        setX((int) affineTransform.getTranslateX());
        setY((int) affineTransform.getTranslateY());
        setP(new Point(getX(), getY()));
    }

    private void drawButton() {
        g2d.fillOval(0,0,10,10);
    }

    public int getX() {
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
    }

}

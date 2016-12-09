package com.lsystem.view;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class NonTerminal {
    Graphics2D g2dd;
    private AffineTransform affineTransform;
    private int screenX;
    private int screenY;
    Ellipse2D bud;
    DynamicView dynamicView;
    static final int CIRCLE_RADIUS = 5;
    private int i;
    private char c;

    public NonTerminal(Graphics2D g2dd, AffineTransform turtleTransform, DynamicView dynamicView, int i, char c) {
        this.g2dd = g2dd;
        this.setAffineTransform(turtleTransform);
        this.dynamicView = dynamicView;
        this.c = c;
        this.i = i;
        setScreenPosition();
        drawBud();
    }


    public void setScreenPosition() {
        screenX = (int) getAffineTransform().getTranslateX();
        screenY = (int) getAffineTransform().getTranslateY();

    }


    private void drawBud() {
        bud = new Ellipse2D.Float();
        bud.setFrameFromCenter(screenX, screenY, screenX + CIRCLE_RADIUS, screenY + CIRCLE_RADIUS);
        g2dd.setPaint(Color.magenta);
        g2dd.fill(bud);
        g2dd.draw(bud);

    }

    public Ellipse2D getBud() {
        return bud;
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

}


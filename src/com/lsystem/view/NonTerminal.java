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

    /***
     * * Constructs the NonTerminal object
     * <p>
     *     This contains the methods that the non terminal object consist of
     *     hereunder the methods that sets the screen position of the buds and a the method that draws the buds.
     * </p>
     * @param g2d the graphics object that the buds are to be drawn on
     * @param turtleTransform the turtles affine transform, used for getting the screen position of the turtle
     * @param dynamicView the current instance of the dynamicView class
     * @param i the position of the current bud (the nonterminal character)
     * @param c the nonterminal character
     */
    public NonTerminal(Graphics2D g2d, AffineTransform turtleTransform, DynamicView dynamicView, int i, char c) {
        this.g2dd = g2d;
        this.setAffineTransform(turtleTransform);
        this.dynamicView = dynamicView;
        this.c = c;
        this.i = i;
        setScreenPosition();
        drawBud();
    }

    /**
     * Sets the screen position of the turtle.
     * <p>
     *     This sets the screen position of the turtle, by getting the translate X and Y of the turtle
     * </p>
     */
    public void setScreenPosition() {
        screenX = (int) getAffineTransform().getTranslateX();
        screenY = (int) getAffineTransform().getTranslateY();

    }

    /**
     * Draws the pink buds on the three.
     * <p>
     *     This draws a bud, on the positions that where set in the previous setScreenPosition method.
     *     The buds position are drawn from the center of the bud.
     * </p>
     */
    private void drawBud() {
        bud = new Ellipse2D.Float();
        bud.setFrameFromCenter(screenX, screenY, screenX + CIRCLE_RADIUS, screenY + CIRCLE_RADIUS); //the bud position is sat from the center of the bud
        g2dd.setPaint(Color.magenta);
        g2dd.fill(bud);
        g2dd.draw(bud); //TODO: TROR Ikke den her er nødvendig, da fill(bud) som udgangspunkt også tegner. men kan ikke teste det pt. kan en anden gøre dette? hilsen naja

    }

    /**
     * Gets the bud.
     * <p>
     *     This is a getter for the bud.
     * </p>
     * @return the bud of this instance of the object
     */
    public Ellipse2D getBud() {
        return bud;
    }

    /**
     * Gets the transform for the bud.
     * <p>
     *     This is a getter for the affinetransform of the drawed bud.
     *     The affineTransform is to be used, when the bud is expanding.
     * </p>
     * @return the transform of this instance of the object
     */
    public AffineTransform getAffineTransform() {
        return affineTransform;
    }

    /**
     * Sets the affineTransform of the bud.
     * <p>
     *     This is a setter for the affineTransform of the drawed bud.
     *     The affineTransform is a parameter from the class Dynamic view, where the Non-terminal (bud) was initialized.
     * </p>
     * @param affineTransform The transform properties of this instance of the object
     */
    public void setAffineTransform(AffineTransform affineTransform) {
        this.affineTransform = affineTransform;
    }

    /**
     * Gets the non-terminals position in the treeString.
     * @return the position of the non-terminal in the treeString
     */
    public int getI() {
        return i;
    }

    /**
     * Gets the non-terminals character.
     * @return the character (in the treeString) of the non-terminal
     */
    public char getC() {
        return c;
    }

}


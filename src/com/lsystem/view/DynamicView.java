package com.lsystem.view;

import com.lsystem.control.NonTerminalMouseListener;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static com.lsystem.view.VisualComponents.leafLeft;
import static com.lsystem.view.VisualComponents.leafRight;

public class DynamicView extends JPanel {

    RecursiveLsystem lsystem;
    Graphics2D turtle;
    Graphics2D g2d;
    private ArrayList<NonTerminal> allNonTerminals;
    NonTerminal nonTerminal;
    //NonTerminalExpander nonTerminalExpander;
    //ArrayList<NonTerminal> nonTerminalsInPoint;
    NonTerminalMouseListener nonTerminalMouseListener;

    //TODO NAJA SKIFTER PLACErING PÅ Screen dimension
    public static int screenHeight = (int) StaticView.SCREEN_SIZE.getHeight();
    public static int screenWidth = (int) StaticView.SCREEN_SIZE.getWidth();
    static int middleX = (screenWidth - StaticView.MENU_WIDTH) / 2;
    AffineTransform firstTransform = AffineTransform.getTranslateInstance(middleX, screenHeight - 100);

    private final static int BRANCH_HEIGHT = -40;

    ArrayList<AffineTransform> turtlePositions = new ArrayList<AffineTransform>();


    public DynamicView(RecursiveLsystem lsystem) {
        super();
        this.lsystem = lsystem;
        makeMouseListener();
        allNonTerminals = new ArrayList<NonTerminal>();
    }

    private void makeMouseListener() {
        nonTerminalMouseListener = new NonTerminalMouseListener(this, lsystem);

    }
    @Override
    public void paintComponent(Graphics g) {
        getAllNonTerminals().clear();
        super.paintComponent(g);
        turtle = (Graphics2D) g.create();
        g2d = (Graphics2D) g.create();
        makeBackground(turtle);
        turtle.setTransform(firstTransform);

        int j = 0;

        for (int i = 0; i < lsystem.getTreeString().length(); i++) {
            char c = lsystem.getTreeString().charAt(i);

            switch (c) {
                case 'F':
                    j++;
                    if (j == 1) {
                        makeLog(turtle);
                    }
                    else {
                        growBranch(turtle);
                    }
                    break;
                case 'A':
                    drawNonTerminal(turtle, g2d, i, c);
                    break;
                case 'B':
                    drawNonTerminal(turtle, g2d, i, c);
                    break;
                case 'C':
                    drawNonTerminal(turtle, g2d, i, c);
                    break;
                case '+':
                    rotateRight(turtle);
                    break;
                case '-':
                    rotateLeft(turtle);
                    break;
                case '[':
                    push(turtle);
                    break;
                case ']':
                    pop(turtle);
                    break;
                default:
                    System.out.println("Char " + c + " not in alphabet");
                    break;
            }

        }
        repaint();
        requestFocus(); //keyexpand will work, even if buttons in the left panel are pressed last
    }
    private void push(Graphics2D turtle) {
        turtlePositions.add(turtle.getTransform());

    }
    private void pop(Graphics2D turtle) {
        AffineTransform tf = turtlePositions.get(turtlePositions.size() - 1);
        turtle.setTransform(tf);
        turtlePositions.remove(turtlePositions.size() - 1);
    }
    private void growBranch(Graphics2D turtle) {
        turtle.setStroke(new BasicStroke(2.0f));
        turtle.drawLine(0, 0, 0, BRANCH_HEIGHT);
        turtle.translate(0, BRANCH_HEIGHT);
        drawLeafs(turtle);

    }
    private void drawLeafs(Graphics2D turtle) {

        for (int i = 0; i < 4; i++) { //loop for drawing the leafs
            turtle.drawImage(leafRight, 0, (i - 1) * ((-1) * BRANCH_HEIGHT / 4), this);
            turtle.drawImage(leafLeft, -15, (i - 1) * ((-1) * (10 * BRANCH_HEIGHT) / 47), this); //the leafs are drawn with a spacing of 4,7 pixel
        }

    }
    private void rotateLeft(Graphics2D turtle) {
        turtle.rotate(Math.PI / 8);
    }
    private void rotateRight(Graphics2D turtle) {
        turtle.rotate(-Math.PI / 8);
    }
    private void makeLog(Graphics2D turtle) {
        GeneralPath logShape = new GeneralPath();
        final double points[][] = {
                {-2, -200}, {2, -200},
                {6, 0}, {-6, 0}
        };

        logShape.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);
        logShape.closePath();
        turtle.fill(logShape);
        turtle.translate(0, -200);

    }
    private void makeBackground(Graphics2D turtle) {
        g2d.drawImage(VisualComponents.background, 0, 0, screenWidth, screenHeight, this); //backgroundIMG. placed on position 0,0 - and scaled to fit screensize
        turtle.setColor(Color.BLACK);
        turtle.setPaint(VisualComponents.barkTex);


    }

    public void drawNonTerminal(Graphics2D turtle, Graphics2D g2dd, int i, char c) {
        AffineTransform currentTf = turtle.getTransform();
        nonTerminal = new NonTerminal(g2dd, currentTf, this, i, c);
        getAllNonTerminals().add(nonTerminal);
    }



    public void changeLength() {
        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                switch (propertyName) {
                    case "branch":
                        System.out.println("branchheight is now" + evt.getNewValue());
                        break;
                    default:
                        break;
                }
            }
        });
        repaint();
    }


    public ArrayList<NonTerminal> getAllNonTerminals() {
        return allNonTerminals;
    }
}

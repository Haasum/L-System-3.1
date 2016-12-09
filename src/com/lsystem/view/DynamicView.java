package com.lsystem.view;

import com.lsystem.control.ExpandBudMouseListener;
import com.lsystem.model.BudExpander;
import com.lsystem.model.RecursiveLsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import static com.lsystem.view.Texture.*;

public class DynamicView extends JPanel {
//TODO Fix de ens ArrayLists
    RecursiveLsystem lsystem;
    Graphics2D turtle;
    Graphics2D g2d;
    ArrayList<NonTerminal> listOfNT;
    NonTerminal nonTerminal;
    BudExpander budExpander;
    ArrayList<NonTerminal> ntArray;

    ExpandBudMouseListener expandBudMouseListener;


    public static int screenHeight = (int) StaticView.SCREEN_SIZE.getHeight();
    public static int screenWidth = (int) StaticView.SCREEN_SIZE.getWidth();
    static int middleX = (screenWidth - StaticView.MENU_WIDTH) / 2;
    private static final int BRANCH_HEIGHT = -40;
    AffineTransform originalTrans = AffineTransform.getTranslateInstance(middleX, screenHeight - 100);
    ArrayList<AffineTransform> subTrees = new ArrayList<AffineTransform>();


    public DynamicView(RecursiveLsystem lsystem) {
        super();
        this.lsystem = lsystem;

        makeMouseListener();

        listOfNT = new ArrayList<NonTerminal>();

    }

    private void makeMouseListener() {
        expandBudMouseListener = new ExpandBudMouseListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        listOfNT.clear();

        super.paintComponent(g);

        turtle = (Graphics2D) g.create();
        g2d = (Graphics2D) g.create();

        makeBackground(turtle);

        turtle.setTransform(originalTrans);

        int j = 0;
        for (int i = 0; i < lsystem.getTreeString().length(); i++) {
            char currentCheck = lsystem.getTreeString().charAt(i);


            switch (currentCheck) {
                case 'F':
                    j++;
                    if (j == 1) {
                        makeLog(turtle);
                    } else {
                        growBranch(turtle);
                    }
                    break;
                case 'A':
                    drawNonTerminal(turtle, g2d, i, currentCheck);
                    break;
                case 'B':
                    drawNonTerminal(turtle, g2d, i, currentCheck);
                    break;
                case 'C':
                    drawNonTerminal(turtle, g2d, i, currentCheck);
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
                    System.out.println("Char " + currentCheck + " not in alphabet");
                    break;
            }
        }
        repaint();
        requestFocus(); //keyexpand will work, even if buttons in the left panel are pressed last
    }

    private void push(Graphics2D turtle) {
        subTrees.add(turtle.getTransform());
    }

    private void pop(Graphics2D turtle) {
        AffineTransform t = subTrees.get(subTrees.size() - 1);
        turtle.setTransform(t);
        subTrees.remove(subTrees.size() - 1);
    }

    private void growBranch(Graphics2D turtle) {
        turtle.setStroke(new BasicStroke(2.0f));

        turtle.drawLine(0, 0, 0, BRANCH_HEIGHT);
        turtle.translate(0, BRANCH_HEIGHT);
        drawLeafs(turtle);
    }

    private void drawLeafs(Graphics2D turtle) {

        for (int i = 0; i < 4; i++) { //loop for drawing the leafs
            turtle.drawImage(leafImg, 0, (i - 1) * ((-1) * BRANCH_HEIGHT / 4), this);
            turtle.drawImage(leafImg2, -15, (i - 1) * ((-1) * (10 * BRANCH_HEIGHT) / 47), this); //the leafs are drawn with a spacing of 4,7 pixel
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
        g2d.drawImage(backImg, 0, 0, screenWidth, screenHeight, this); //backgroundIMG. placed on position 0,0 - and scaled to fit screensize
        turtle.setColor(Color.BLACK);
        turtle.setPaint(Texture.barkTex);

    }

    public void drawNonTerminal(Graphics2D turtle, Graphics2D g2dd, int i, char c) {
        AffineTransform newTransform = turtle.getTransform();
        nonTerminal = new NonTerminal(g2dd, newTransform, this, i, c);//, affineTransform);
        listOfNT.add(nonTerminal);
    }

    public void ntClicked(int mouseX, int mouseY) {

        ntArray = new ArrayList<NonTerminal>();


        for (NonTerminal nt : listOfNT) {

            if (nt.getNtCircle().contains(mouseX, mouseY) == true) {

                ntArray.add(nt);
            } else {


            }

        }

        if (ntArray.isEmpty() == false) {
            expandNode(ntArray);
        }
    }

    private void expandNode(ArrayList ntArray) {
        budExpander = new BudExpander(ntArray, lsystem);
    }
}

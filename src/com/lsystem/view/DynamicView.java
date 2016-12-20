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
    NonTerminalMouseListener nonTerminalMouseListener;

    static int middleX = (StaticView.SCREEN_WIDTH - StaticView.MENU_WIDTH) / 2;
    AffineTransform firstTransform = AffineTransform.getTranslateInstance(middleX, StaticView.SCREEN_HEIGHT - 100);

    private final static int BRANCH_HEIGHT = -40;

    ArrayList<AffineTransform> turtlePositions = new ArrayList<AffineTransform>();

    /**
     * Constructs the Dynamic view object.
     * @param lsystem the current instance of the recursive lsystem class
     */
    public DynamicView(RecursiveLsystem lsystem) {
        super();
        this.lsystem = lsystem;
        makeMouseListener();
        allNonTerminals = new ArrayList<NonTerminal>();
    }

    /**
     * Initializes a mouseListener.
     * <p>
     *     This initializes the mouseListener 'nonTerminalMouseListener', which is used to get the mouse position
     *     everytime the mouse is clicked.
     * </p>
     */
    private void makeMouseListener() {
        nonTerminalMouseListener = new NonTerminalMouseListener(this, lsystem);

    }
    /**
     * Paints each of the components in its container.
     * <p>
     *     This is the paintcomponent, which paints the dynamic components, such as the three and the background.
     *     this contains a graphics object (Graphics g), which - in this case only is used to hold two other
     *     graphics objects; turtle and g2d.
     *
     *     turtle holds all the components for the three.
     *     g2d holds the background image, and the (nonTerminal) dots on the three.
     *
     *     this also contains a for-loop that gets the expanded string, and creates components accordingly.
     * </p>
     * @param g the basic graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        getAllNonTerminals().clear();
        super.paintComponent(g);
        turtle = (Graphics2D) g.create();
        g2d = (Graphics2D) g.create();
        makeBackground(turtle);
        turtle.setTransform(firstTransform);

        int j = 0;

        for (int i = 0; i < lsystem.getTreeString().length(); i++) { //for-loop. runs for every character in the treeString
            char c = lsystem.getTreeString().charAt(i);

            switch (c) {
                case 'F':
                    if (j == 0) {
                        makeLog(turtle);
                        j = 1;
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
                    System.out.println("Character " + c + " not in alphabet");
                    break;
            }

        }
        repaint();
        requestFocus(); //keyexpand will work, even if buttons in the left panel are pressed last
    }
    /**
     * Saves the position of the turtle.
     * <p>
     *     This saves the current position of the turtle.
     *     The position will be added to an array, which can be used later on,
     *     when the pop() method is called.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void push(Graphics2D turtle) {
        turtlePositions.add(turtle.getTransform());

    }
    /**
     * Sets the position of the Turtle back to the previous position.
     * <p>
     *     This gets the previous turtle position from the array of turtle positions.
     *     The turtles transform is then set to that previous position.
     *     The last turtle position is then removed from the array of turtle positions.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void pop(Graphics2D turtle) {
        AffineTransform tf = turtlePositions.get(turtlePositions.size() - 1);
        turtle.setTransform(tf);
        turtlePositions.remove(turtlePositions.size() - 1);
    }
    /**
     * Draws a branch on the tree.
     * <p>
     *     This is the method, that is called everytime a branch has to be drawn.
     *     The turtle draws the branch and afterwords the turtle position is moved (translated)
     *     from the root of the branch, to the end of the branch.
     *     This also calls the method that draws the leafs on the branch.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void growBranch(Graphics2D turtle) {
        turtle.setStroke(new BasicStroke(2.0f));
        turtle.drawLine(0, 0, 0, BRANCH_HEIGHT);
        turtle.translate(0, BRANCH_HEIGHT);
        drawLeafs(turtle);

    }
    /**
     * Draws the leafs on the branch.
     * <p>
     *     This draws 4 leafs on each side of each branch.
     *     This contains a for-loop, which runs 4 times, and draws 1 leaf on each side of the branch,
     *     for every loop. The position of the leafs is moved a little for every loop.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void drawLeafs(Graphics2D turtle) {

        for (int i = 0; i < 4; i++) { //loop for drawing the leafs
            turtle.drawImage(leafRight, 0, (i - 1) * ((-1) * BRANCH_HEIGHT / 4), this);
            turtle.drawImage(leafLeft, -15, (i - 1) * ((-1) * (10 * BRANCH_HEIGHT) / 47), this); //the leafs are drawn with a spacing of 4,7 pixel
        }
    }
    /**
     * Rotates the turtle to the left.
     * <p>
     *     This rotates the turtle to the left by 22,5 degrees (Math.PI/8)
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void rotateRight(Graphics2D turtle) {
        turtle.rotate(Math.PI / 8);
    }
    /**
     * Rotates the turtle to the right.
     * <p>
     *     This rotates the turtle to the right by 22,5 degrees (Math.PI/8)
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void rotateLeft(Graphics2D turtle) {
        turtle.rotate(-Math.PI / 8);
    }
    /** Draws the log shape.
     * <p>
     *     This generates a path, which simulates a log shape.
     *     The logshape is then filled and drawed. This is followed by the turtle position
     *     being moved from the bottom of the log to the top of the log.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void makeLog(Graphics2D turtle) {
        GeneralPath logShape = new GeneralPath();
        final double points[][] = {
                {-2, -200}, {2, -200},
                {6, 0}, {-6, 0}
        };

        logShape.moveTo(points[0][0], points[0][1]);  //the path follows the 'points' double array
        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);
        logShape.closePath(); //the path is closed
        turtle.fill(logShape); //the path is filled
        turtle.translate(0, -200); //the turtle position is moved

    }
    /**
     * Draws the background.
     * <p>
     *     This draws the background image, and set the scale corresponding to the screen width and height.
     *     The color of turtle is then declared as black, and the paint(texture) is then declared as the bark texture
     * </p>
     * @param turtle the graphics object which are used to draw the three
     */
    private void makeBackground(Graphics2D turtle) {
        g2d.drawImage(VisualComponents.background, 0, 0, StaticView.SCREEN_WIDTH, StaticView.SCREEN_HEIGHT, this); //backgroundIMG. placed on position 0,0 - and scaled to fit screensize
        turtle.setColor(Color.BLACK);
        turtle.setPaint(VisualComponents.barkTex);


    }
    /**
     * Draws the pink buds on the three.
     * <p>
     *     This gets the current current position and rotation of the turtle.
     *     Afterwords a nonTerminal object is initialized, and that new object is last
     *     put in an array of all the non-terminals.
     * </p>
     * @param turtle the graphics object which are used to draw the three
     * @param g2d the graphics object which are used to draw anything but the three
     * @param i the location of the non Terminal, in the treeString
     * @param c the character of the non Terminal
     */
    public void drawNonTerminal(Graphics2D turtle, Graphics2D g2d, int i, char c) {
        AffineTransform currentTf = turtle.getTransform();
        nonTerminal = new NonTerminal(g2d, currentTf, this, i, c);
        getAllNonTerminals().add(nonTerminal);
    }


//TODO: this is not used. kunen være fedt hvis vi nåede det. men jeg kan ikke nå det lige nu. kh naja
    public void changeLenght() {
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

    /**
     * Gets a list of all the non-terminals.
     * <p>
     *     This is a getter for the arraylist of all the non-terminals.
     * </p>
     * @return
     */
    public ArrayList<NonTerminal> getAllNonTerminals() {
        return allNonTerminals;
    }
}


package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpandKeyListener implements KeyListener, UserInput {

    RecursiveLsystem lsystem;
    String treeToExpand;
    String expandedTree;
    int currentGenNo = 0;
    final static int MAX_GEN_NO = 10;

    /**
     * Constructs the Expandkeylistener
     * @param lsystem the current instance of theRecursiveLsystem class
     */
    public ExpandKeyListener(RecursiveLsystem lsystem) {
        this.lsystem = lsystem;
    }
    /**
     * Expands tree if key up is pressed.
     * <p>
     *     This is a keyPressed method, that runs everytime a key is pressed.
     *     If the key 'up' is pressed, a method to expand the tree one generation is called.
     * </p>
     * @param e the event. Used to get information on which key was pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            expandGeneration(lsystem);
        } else {
            System.out.println("press up to make the tree grow"); //admin guidelines, in case another (wrong) key is pressed
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Expands the tree one generation.
     * <p>
     *     This expands the three by one generation.
     *     First of all the method checks if the three has been expanded the maximum amount.
     *     If not, the current tree string will be fetched and expanded, and thereby the new tree String is sat
     * </p>
     * @param lsystem an instance of the class RecursiveLsystem
     */
    @Override
    public void expandGeneration(RecursiveLsystem lsystem) {
        if (currentGenNo <= MAX_GEN_NO) {
            currentGenNo++;
            treeToExpand = lsystem.getTreeString(); //gets the current tree String
            expandedTree = lsystem.expand(treeToExpand, 1); //expands the string by 1 generation
            lsystem.setTreeString(expandedTree); //sets the tree string to the new (and expanded) tree string
        } else
            System.out.println("The tree will only expand 10 generations to avoid overloading your computer"+"\n"+"You can change this limit in the class ExpandKeyListener "); //admin information, that will let you know that the tree has been expanded to the sat maximum limit

    }
}
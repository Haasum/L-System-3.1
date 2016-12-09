
package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpandKeyListener implements KeyListener, UserInput {

    RecursiveLsystem lsystem;
    String treeToExpand;
    String expandedTree;
    int currentGenNo = 0;
    int maxGenNo = 10;

    public ExpandKeyListener(RecursiveLsystem lsystem) {
        this.lsystem = lsystem;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            expandGeneration(lsystem);
        } else {
            System.out.println("press up to make the tree grow");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void expandGeneration(RecursiveLsystem lsys) {
        if (currentGenNo <= maxGenNo) {
            currentGenNo++;
            treeToExpand = lsys.getTreeString();
            expandedTree = lsys.expand(treeToExpand, 1);
            lsys.setTreeString(expandedTree);
        } else
            System.out.println("The tree will only expand 10 generations to avoid overloading your computer"+"\n"+"You can change this limit in the class ExpandKeyListener ");

    }
}
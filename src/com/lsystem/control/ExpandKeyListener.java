
package com.lsystem.control;

import com.lsystem.model.RecursiveLsystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpandKeyListener implements KeyListener, UserInput {

    RecursiveLsystem lsys;
    String treeToExpand;
    String expandedTree;
    int currGenNo = 0;
    int maxGenNo = 10;

    public ExpandKeyListener(RecursiveLsystem lsys) {
        this.lsys = lsys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            expandGeneration(lsys);
        } else {
            System.out.println("press up to make the tree grow");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void expandGeneration(RecursiveLsystem lsys) {
        if (currGenNo <= maxGenNo) {
            currGenNo++;
            treeToExpand = lsys.getTreeString();
            expandedTree = lsys.expand(treeToExpand, 1);
            lsys.setTreeString(expandedTree);
        } else
            System.out.println("Too many generations");

    }
}

package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpandKeyListener implements KeyListener, UserInput {

    RecursiveLsys lsys;
    String treeToExpand;
    String expandedTree;
    int currGenNo =3;
    int maxGenNo = 10;

    public ExpandKeyListener(RecursiveLsys lsys){
        this.lsys = lsys;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP)  {
            expandGeneration(lsys);

        }

        else {
            System.out.println("wrong key");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void expandGeneration(RecursiveLsys lsys) {
        if (currGenNo <= maxGenNo){
            currGenNo++;
        treeToExpand = lsys.getTree();
        expandedTree = lsys.expand(treeToExpand,1);
        lsys.setTree(expandedTree);}
        else
        System.out.println("Too many generations");

    }
}


/*package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpandKeyListener implements KeyListener {
    //RecursiveLsys lsys;
    //String treeToExpand;
    //String expandedTree;

    public ExpandKeyListener(RecursiveLsys lsys) {
        this.lsys = lsys;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            System.out.println("up");

            treeToExpand = lsys.getTree();
            System.out.println("Jeg skal expandes: " + treeToExpand);
            expandedTree = lsys.expand(treeToExpand,1);
           System.out.println("Jeg burde blive tegnet" + expandedTree);
            lsys.setTree(expandedTree);
        }

        else if (e.getKeyCode() == e.VK_DOWN) {
            System.out.println("down");

        }

        else {
            System.out.println("wrong key");
        }
    }




    @Override
    public void keyReleased(KeyEvent e) {

    }
}
*/
package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;


public class ButtonExpandListener implements ActionListener{

    RecursiveLsys lsys;
    int i = 1;
    char c = 'A';

    public ButtonExpandListener(NonTerminal nt, RecursiveLsys lsys){
        System.out.println("jeg kører Button expand listener med: " + nt.getI());
        this.lsys = lsys;
        this.i = nt.getI();
        this.c = nt.getC();
        AffineTransform expandTrans = new AffineTransform(nt.getAffineTransform());
        expandNodeInTree();
    }

    public void expandNodeInTree(){
        System.out.println("jeg kører expand node in tree");

        String toBeExpanded = ""+c;
        String expandedTree = lsys.expand(toBeExpanded, 1);
        System.out.println(expandedTree);

        String currTree = lsys.getTree();
        String newTree1 = currTree.substring(0,i+1);
        System.out.println("newtree 1 " + newTree1);
        String newTree2 = expandedTree;
        System.out.println("newtree 2 " + newTree2);
        String newTree3 = currTree.substring(i+1,currTree.length());
        System.out.println("newtree 3 " + newTree3);

        String newTree = newTree1+newTree2+newTree3;
        System.out.println("the new expanded tree is " + newTree);

        lsys.setTree(newTree);

        /*
        * Recsys: I stedet for tree, skal der oprettes en rodknude.
        * Hver knude har leftRight / liste af børneknuder
        * Knudeværdi: bogstav
        * BladKnude: tom børneliste
        *
        * ToString
        *
         * Turtle = expand retter i træet og ikke i strengen
           * Hver knude får relateret en button
           * Knuder er actionlisteners.
           * Knudeobjekt lytter på om der bliver trykket på en knap
           * Hvis der trykkes kan der expandes.
        *
        * */

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        expandNodeInTree();
    }

}

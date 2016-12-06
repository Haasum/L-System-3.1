package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonExpandListener implements ActionListener{

    RecursiveLsys lsys;
    int i;
    char c;

    public ButtonExpandListener(RecursiveLsys lsys, int i, char c){
        this.lsys = lsys;
        this.i = i;
        this.c = c;
    }

    public void expandNodeInTree(){

        String toBeExpanded = ""+c;
        String expandedTree = lsys.expand(toBeExpanded, 1);
        System.out.println(expandedTree);

        String currTree = lsys.getTree();
        String newTree1 = currTree.substring(0,i);
        String newTree2 = expandedTree;
        String newTree3 = currTree.substring(i+1,currTree.length());

        String newTree = newTree1+newTree2+newTree3;

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

package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ButtonExpandListener implements ActionListener{

    RecursiveLsys lsys;
    int i = 1;
    int[] intArray;
    ArrayList<Integer> intArray2;
    char c = 'A';
    NonTerminal nt;
    ArrayList<NonTerminal> ntArray;

    public ButtonExpandListener(ArrayList<NonTerminal> ntArray, RecursiveLsys lsys){
        this.ntArray = ntArray;
        this.lsys = lsys;

       // this.i = nt.getI();
       // this.c = nt.getC();
        //AffineTransform expandTrans = new AffineTransform(nt.getAffineTransform());
        checkArray();
      //  expandNodeInTree();
    }

    private void checkArray() {
        String currTree = lsys.getTree();
        System.out.println("Jeg bliver leget med "+currTree);
        String newTree1 = currTree.substring(0,ntArray.get(0).getI());
        System.out.println("first tree " + newTree1);

        String toBeExpanded = ""+ntArray.get(0).getC();
        String expandedTree = lsys.expand(toBeExpanded, 1);
        String newTree2 = expandedTree ;
        System.out.println("second tree " + newTree2);

        String newTree3 = currTree.substring(ntArray.get(0).getI()+1,ntArray.get(1).getI());
        System.out.println("third tree"+newTree3);


        String toBeExpanded2 = ""+ntArray.get(1).getC();
        String expandedTree2 = lsys.expand(toBeExpanded2, 1);
        String newTree4 = expandedTree2 ;
        System.out.println("fourth tree " + newTree4);

        String newTree5 = currTree.substring(ntArray.get(1).getI()+1,currTree.length());
        System.out.println("fifth tree"+newTree5);

        for (int j = 0; j < ntArray.size(); j++) {

            ntArray.get(j).getI();

        }

    }

    public void expandNodeInTree(){
        System.out.println("jeg kører expand node in tree");

        String toBeExpanded = ""+c;
        String expandedTree = lsys.expand(toBeExpanded, 1);
        System.out.println(expandedTree);

        String currTree = lsys.getTree();
        String newTree1 = currTree.substring(0,i);
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

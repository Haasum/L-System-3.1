package com.lsystem.control;

import com.lsystem.model.RecursiveLsys;
import com.lsystem.view.NonTerminal;

import java.util.ArrayList;


public class ButtonExpandListener {//implements ActionListener{

    RecursiveLsys lsys;
    ArrayList<NonTerminal> ntArray;

    public ButtonExpandListener(ArrayList<NonTerminal> ntArray, RecursiveLsys lsys){
        this.ntArray = ntArray;
        this.lsys = lsys;
        checkArray();
    }

    private void checkArray() {
        String currTree = lsys.getTree();

        ArrayList<String> subStrings = new ArrayList<String>();

        int previousInt = 0;

        for (int j = 0; j < ntArray.size(); j++) {
            String ntree2 = currTree.substring(previousInt, ntArray.get(j).getI());
            subStrings.add(ntree2);

            if (j < ntArray.size()-1) {
                String ntree3 = "" + ntArray.get(j).getC();
                String expandedTree2 = lsys.expand(ntree3, 1);
                subStrings.add(expandedTree2);

                previousInt = ntArray.get(j).getI()+1;
            }
            else  {
                String ntree4 = "" + ntArray.get(j).getC();
                String expandedTree = lsys.expand(ntree4, 1);
                subStrings.add(expandedTree);

                String ntree5 = currTree.substring(ntArray.get(j).getI()+1, currTree.length());
                subStrings.add(ntree5);

            }

        }

        String newTreeTheEnd = "";

        for (String s : subStrings)
        {
            newTreeTheEnd += s;
        }
        lsys.setTree(newTreeTheEnd);
    }

/*
    @Override
    public void actionPerformed(ActionEvent e) {
        expandNodeInTree();
    }*/

}

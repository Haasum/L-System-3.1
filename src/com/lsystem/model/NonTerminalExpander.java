package com.lsystem.model;
import com.lsystem.view.NonTerminal;
import java.util.ArrayList;


public class NonTerminalExpander {

    RecursiveLsystem lsystem;
    ArrayList<NonTerminal> nonTerminalsInPoint;

    public NonTerminalExpander(ArrayList<NonTerminal> nonTerminalsInPoint, RecursiveLsystem lsystem) {
        this.nonTerminalsInPoint = nonTerminalsInPoint;
        this.lsystem = lsystem;
        checkArray();
    }

    private void checkArray() {
        String currentTreeString = lsystem.getTreeString();
        ArrayList<String> subStrings = new ArrayList<String>();
        int j = 0;

        for (int i = 0; i < nonTerminalsInPoint.size(); i++) {
            String subString1 = currentTreeString.substring(j, nonTerminalsInPoint.get(i).getI());
            subStrings.add(subString1);

            if (i < nonTerminalsInPoint.size() - 1) {
                String subString2 = "" + nonTerminalsInPoint.get(i).getC();
                String expandedString2 = lsystem.expand(subString2, 1);
                subStrings.add(expandedString2);

                j = nonTerminalsInPoint.get(i).getI() + 1;
            }
            else {
                String subString3 = "" + nonTerminalsInPoint.get(i).getC();
                String expandedString1 = lsystem.expand(subString3, 1);
                subStrings.add(expandedString1);
                String subString4 = currentTreeString.substring(nonTerminalsInPoint.get(i).getI() + 1, currentTreeString.length());
                subStrings.add(subString4);
            }
        }

        String newTree = "";
        for (String s : subStrings) {
            newTree += s;
        }
        lsystem.setTreeString(newTree);
    }
}

package com.lsystem.model;

import java.util.ArrayList;

public class RecursiveLsystem {
    ArrayList<Rule> ruleset;
    Grammatik grammatik;
    char axiom;
    String axiomString = "";
    int genNo = 0;
    String treeString;

//TODO i recsys: der skal være en metode: stopCondition()

    public RecursiveLsystem(Grammatik grammatik) {

        this.grammatik = grammatik;
        axiom = grammatik.addAxiom();
        this.ruleset = grammatik.ruleset;
        axiomString += axiom;
        treeString = expand(axiomString, genNo);


    }
    public String expand(String s, int genNo) {
        String next = "";
        if (genNo == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String ruleToExpand = getRuleInRuleset(c);
            if (ruleToExpand != "" && ruleToExpand != null) {
                next += expand(ruleToExpand, genNo-1  );
            }
            else if (ruleToExpand == "" || ruleToExpand == null) {
                next += c;
            }
        }
        return next;
    }

    public String getRuleInRuleset(char c) {
        String s = "";

        ArrayList<String> randomRules = new ArrayList<String>();
        for (int i = 0; i < ruleset.size(); i++) {
            char currAlpha = ruleset.get(i).getLeftSide();
            if (currAlpha == c) {
                s = ruleset.get(i).getRightSide();
                randomRules.add(s);
            }
        }
        if (randomRules.size() > 1) {
            RandomRulePicker randomRulePicker = new RandomRulePicker(randomRules);
            s = randomRulePicker.getRandomRule();
        }
        return s;
    }

    public void setTreeString(String treeString) {
        this.treeString = treeString;
    }

    public String getTreeString(){
        return treeString;
    }

}

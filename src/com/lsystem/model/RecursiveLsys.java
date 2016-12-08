package com.lsystem.model;

import java.util.ArrayList;

public class RecursiveLsys {
    ArrayList<Rule> ruleset;
    Grammatik grammatik;
    char axiom1;
    String treeLsys1 = "";
    int genNo1 = 0;
    String tree;
    ArrayList<String> rulesForRand;

//TODO i recsys: der skal være en metode: stopCondition()

    public RecursiveLsys(Grammatik grammatik) {

        this.grammatik = grammatik;
        axiom1 = grammatik.addAxiom();
        this.ruleset = grammatik.ruleset;
        treeLsys1 += axiom1;
        tree = expand(treeLsys1, genNo1);


    }
    public String expand(String s, int genNo1) {

        String next = "";


        if (genNo1 == 0) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            String expandRule = checkLetterInAlpha(curr);

            if (expandRule != "" && expandRule != null) {
                next += expand(expandRule, genNo1-1  );
            }
            else if (expandRule == "" || expandRule == null) {
                next += curr;

            }
        }
        return next;
    }
    public String checkLetterInAlpha(char c) {
        String k = "";
        rulesForRand = new ArrayList<String>();
        for (int i = 0; i < ruleset.size(); i++) {
            char currAlpha = ruleset.get(i).getAlfabet();
            if (currAlpha == c) {
                k = ruleset.get(i).getRegel();
                rulesForRand.add(k);
            }
        }
        if (rulesForRand.size() > 1) {
            Rand rand = new Rand(rulesForRand);
            k = rand.getRandRule();
        }

        return k;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public String getTree(){
        return tree;
    }

}

package com.lsystem.model;

import java.util.ArrayList;

public class RecursiveLsystem {
    ArrayList<Rule> ruleset;
    Grammatik grammatik;
    char axiom;
    String axiomString = "";
    int genNo = 0;
    String treeString;


    public RecursiveLsystem(Grammatik grammatik) {

        this.grammatik = grammatik;
        axiom = grammatik.addAxiom();
        this.ruleset = grammatik.ruleset;
        axiomString += axiom;
        treeString = expand(axiomString, genNo);


    }

    /**
     * Expands the current string recursively.
     * <p>
     *     This expands the string, with the rules from the ruleset array.
     *     This contains of a for-loop, that runs through a String (s), and expands that String.
     *
     *     The for-loop checks the characters in the String one by one.
     *     First the characters rule is returned by the method getRuleInRuleset, //method or function
     *     which could of one of two outcomes:
     *     <p>1. outcome: If the character is a primitive (e.g. '+'), the getRuleInRuleset method returns null.
     *     If so the character is not replaced by a rule, and will just be applied directly to the expanded String.
     *     2. outcome: If the character isnt a primitive (e.g. 'A'), the getRuleInRuleset method returns the expansion
     *     rule of that character (e.g. F[+A][-A]). The rule (not the character) is then applied to the expanded String.
     *
     *     //TODO: mere med expand igen. recursion.
     *     </p>
     *
     *
     * </p>
     * @param s is the string to be expanded
     * @param genNo is the number of times the string should be expanded
     * @return the expanded string
     */
    public String expand(String s, int genNo) {
        String next = "";


        if (genNo == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) { //the for-loop that runs through the String character by character
            char c = s.charAt(i);
            String ruleToExpand = getRuleInRuleset(c); //expands the character by calling the getRuleInRuleset function
            if (ruleToExpand != "" && ruleToExpand != null) { //if the character has a rule, this if sentence counts
                next += expand(ruleToExpand, genNo-1  ); //whats to be expanded next
            }
            else if (ruleToExpand == "" || ruleToExpand == null) { //if the character is a primitive, this if sentence counts.
                next += c;
            }
        }
        return next;
    }

    /**
     * Fetches the left side of the ruleset for the current character.
     * <p>
     *     This gets a parameter - the current character from the previous method.
     *     The purpose of this method is to fetch the expansion rule of that character.
     *     First the method looks op the character in the ruleset Array.
     *     Secondly, if the character has two or more rules, the RandomRulePicker class is initialized
     *     and a random rule is chosen from the array of rules. That chosen rule is returned.
     *
     *     If the character only if one rule, that rule is the String (s), that this method returns
     * </p>
     * @param c the current character to be expanded
     * @return the expansion-rule of that current character
     */
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

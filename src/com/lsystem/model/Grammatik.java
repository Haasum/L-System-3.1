package com.lsystem.model;

import java.util.ArrayList;

public class Grammatik {
    ArrayList<Rule> ruleset;
    char currentLetter;
    String currentRule = "";
    Rule rule;
    String textFileString;

    public Grammatik(String textFileString){
        this.textFileString = textFileString;
        ruleset = new ArrayList<Rule>();
        addAxiom();
        addPrimitives();
        addRules();
    }
    public char addAxiom() {
        char axiom = textFileString.charAt(0);
        return axiom;
    }

    /**
     * Adds the primitives to ruleset.
     * <p>
     *     This declares and assigns the primitives to a character array.
     *     This is followed by a foreach loop which adds all the primitives in the array to the ruleset.
     * </p>
     */
    public void addPrimitives(){
        char[] primitives = new char[]{'[',']','+','-'};
        for (char c :primitives) {
            Rule primitive = new Rule(c);
            ruleset.add(primitive);
        }
    }

    /**
     * Adds the character rules, sat by the chosen text input.
     * <p>
     *     This contains a for-loop, which check every character in the textFileString.
     *     The characters are assigned to the ruleset as a letter or a rule, depending on their position in the textFileString.
     *     The current character that are being checked, is reffered to as 'c'
     *
     *     What happens in the for-loop is:
     *     The letter before the colon (:) is assigned as the currentLetter
     *     The letters after the colon (:) is assigned together as the currentRule
     *     When c is a comma (,), the currentLetter and currentRule is send to the addRule method
     * </p>
     */
    public void addRules() {
        for (int i = 0; i < textFileString.length()-1; i++) { //for-loop that runs for the length of the textFileString
            StringBuilder sb = new StringBuilder();
            char c = textFileString.charAt(i);
            if (c == ':') { //if c is colon, the character before colon, is assigned as the currenLetter
                currentLetter = textFileString.charAt(i - 1);
            }
            if (c == ',') { //if c is a comma, the addRule method is called.
                addRule();
                sb.setLength(0); //the Stringbuilder sb, is set to null
            }
            else if (textFileString.charAt(i+1) != ':' && c != ':'){ //if c is a character after the colon, it is to be assigned to the current rule
                sb.append(c);
                currentRule += String.valueOf(sb);
            }
            else if (c == '.') { //TODO: denne har vi glemt at bruge. vi skal lige snakke om det fælles om vi skal rette syntax i rapport eller slette denne. Den siger at textfile skal slutte på .
                return;
            }
        }
    }

    /**
     * Creates a new rule.
     * <p>
     *     This initializes a new rule, with the properties currentLetter and currentRule,
     *     which are assigned in the previous method.
     *     The new rule is then added to a ruleset.
     * </p>
     */
    private void addRule() {
        rule = new Rule(currentLetter, currentRule);
        ruleset.add(rule); //rules are saved in a ruleset array.
        currentRule = ""; //currentRule is reset
    }
}

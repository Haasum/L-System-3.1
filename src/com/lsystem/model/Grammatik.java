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

    public void addPrimitives(){
        char[] primitives = new char[]{'[',']','+','-'};
        for (char c :primitives) {
            Rule primitive = new Rule(c);
            ruleset.add(primitive);
        }
    }
    public void addRules() {
        for (int i = 0; i < textFileString.length()-1; i++) {
            StringBuilder sb = new StringBuilder();
            char c = textFileString.charAt(i);
            if (c == ':') {
                currentLetter = textFileString.charAt(i - 1);
            }
            if (c == ',') {
                addRule();
                sb.setLength(0);
            }
            else if (textFileString.charAt(i+1) != ':' && c != ':'){
                sb.append(c);
                currentRule += String.valueOf(sb);
            }
            else if (c == '.') {
                return;
            }
        }
    }
    private void addRule() { //rules are send and saved in a ruleset array.
        rule = new Rule(currentLetter, currentRule);
        ruleset.add(rule);
        currentRule = ""; //currentRule is reset
    }
}

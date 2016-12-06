package com.company;

import java.util.ArrayList;

/**
 * Created by MasterWillis on 03/12/2016.
 */
public class Grammatik {
    ArrayList<Rule> ruleset;
    char currentLetter;
    String currRule = "";
    Rule rule;

    String textFile;


    public Grammatik(String textFileString){
        this.textFile = textFileString;
        ruleset = new ArrayList<Rule>();
        addAxiom();
        addPrimitives();
        addRules();
    }
    private void addAxiom() {

        char axiom = 'K';
        String axiomRule = "F[-A][+A]";
        Rule axRule = new Rule(axiom, axiomRule);
        ruleset.add(axRule);

    }
    public void addPrimitives(){
        char[] primitives = new char[]{'[',']','+','-'};
        for (char c :primitives) {
            Rule primitive = new Rule(c);
            ruleset.add(primitive);
        }
    }
    public void addRules() {
        for (int i = 0; i < textFile.length()-1; i++) {
            StringBuilder buildRule = new StringBuilder();
            char current = textFile.charAt(i);
            if (current == ':') {
                currentLetter = textFile.charAt(i - 1);
            }
            if (current == ',') {
                addRule();
                buildRule.setLength(0);
            }
            else if (textFile.charAt(i+1) != ':' && current != ':'){
                buildRule.append(current);
                currRule += String.valueOf(buildRule);
            }
            else if (current == '.') {
                return;
            }
        }
    }
    private void addRule() { //reglerne sendes. det er også her de skal gemmes
        rule = new Rule(currentLetter, currRule);
        ruleset.add(rule);
        currRule = ""; //currRule nulstilles
    }
}

package com.lsystem;

public class Rule {
    private char alfabet;
    private String regel;
    private boolean isTerminal = false;
    public Rule(char input, String regel){
        this.setAlfabet(input);
        this.setRegel(regel);

    }
    public Rule(char input){
        this.alfabet = input;
        setTerminal(true);
    }

    public char getAlfabet() {
        return alfabet;
    }

    public void setAlfabet(char alfabet) {
        this.alfabet = alfabet;
    }

    public String getRegel() {
        return regel;
    }

    public void setRegel(String regel) {
        this.regel = regel;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}

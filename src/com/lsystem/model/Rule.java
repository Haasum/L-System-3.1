package com.lsystem.model;

public class Rule {
    private char leftSide;
    private String rightSide;
    private boolean isTerminal = false;

    public Rule(char leftSide, String rightSide){
        this.setLeftSide(leftSide);
        this.setRightSide(rightSide);

    }
    public Rule(char primitive){
        this.leftSide = primitive;
        setTerminal(true);
    }

    public char getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(char leftSide) {
        this.leftSide = leftSide;
    }

    public String getRightSide() {
        return rightSide;
    }

    public void setRightSide(String rightSide) {
        this.rightSide = rightSide;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}

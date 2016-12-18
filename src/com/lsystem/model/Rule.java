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

    /**
     * Gets the left side of the ruleset.
     * <p>
     *     This is a getter of the Left side of the ruleset.
     *     The left side contains the rule letter
     * </p>
     * @return
     */
    public char getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(char leftSide) {
        this.leftSide = leftSide;
    }

    /**
     * Gets the right side of the ruleset.
     * <p>
     *     This is a getter of the right side of the ruleset.
     *     The right side contains the rule of the ruleletter
     * </p>
     * @return
     */
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

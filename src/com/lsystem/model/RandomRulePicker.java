package com.lsystem.model;
import java.util.ArrayList;
import java.util.Random;



public class RandomRulePicker extends Random {
    ArrayList<String> randomRules;
    String randomRule = "";
    public RandomRulePicker(ArrayList<String> randomRules ){
        this.randomRules = randomRules ;
        chooseRandomRule();
    }

    /**
     * Choses one of the rules.
     * <p>
     *     This choses one of the rules randomly.
     * </p>
     */
    private void chooseRandomRule() {
        int min = 0;
        int max = randomRules.size() - 1;
        int randomNo = this.nextInt((max - min) + 1) + min;
        randomRule = randomRules.get(randomNo); //assigns a rule in the randomRule array to the randomRule
    }

    /**
     * Gets the random Rule.
     * <p>
     *     This is a getter for the random rule, chosen in the previous method (chooseRandomRule)
     * </p>
     */
    public String getRandomRule() {
        return randomRule;
    }
}
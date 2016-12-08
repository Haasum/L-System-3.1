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
    private void chooseRandomRule() {
        int min = 0;
        int max = randomRules.size() - 1;
        int randomNo = this.nextInt((max - min) + 1) + min;
        randomRule = randomRules.get(randomNo);
    }
    public String getRandomRule() {
        return randomRule;
    }
}
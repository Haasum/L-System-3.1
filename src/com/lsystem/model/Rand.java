package com.lsystem.model;
import java.util.ArrayList;
import java.util.Random;



public class Rand {
    ArrayList<String> rulesForRand;
    String randRule = "";
    Random rand;
    public Rand(ArrayList<String> rulesForRand){
        this.rulesForRand = rulesForRand;
        chooseRandomRule();
    }
    private void chooseRandomRule() {
        int min = 0;
        int max = rulesForRand.size() - 1;
        rand = new Random();
        int randNo = rand.nextInt((max - min) + 1) + min;
        randRule = rulesForRand.get(randNo);
    }
    public String getRandRule() {
        return randRule;
    }
}
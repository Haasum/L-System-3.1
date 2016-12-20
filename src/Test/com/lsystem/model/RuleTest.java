package com.lsystem.model;

import org.junit.Assert;
import org.junit.Test;


public class RuleTest {

    @Test
    public void getLeftSide() throws Exception {
        //Given
        char a = 'A';

        //When
        Rule ruleTest = new Rule (a);

        //Then
        Assert.assertTrue(String.valueOf(ruleTest.getLeftSide() == a), true );

    }

    @Test
    public void setLeftSide() throws Exception {
        //Given
        char a = 'A';
        String r = "FF-[[A]+A]+FF[+FFA]-A";

        //When
        Rule ruleTest = new Rule (a, r);
        ruleTest.setLeftSide('P');

        //then

        Assert.assertEquals("Failed SetLeftSide", ruleTest.getLeftSide(),'P');




    }

    @Test
    public void getRightSide() throws Exception {
        //Given
        char a = 'A';
        String r = "FF-[[A]+A]+FF[+FFA]-A";

        //When
        Rule ruleTest = new Rule (a, r);

        //Then
        Assert.assertEquals("rightside failed test", ruleTest.getRightSide(), r);
    }

    @Test
    public void setRightSide() throws Exception {
        //Given
        char a = 'A';
        String r = "FF-[[A]+A]+FF[+FFA]-A";

        //When
        Rule ruleTest = new Rule (a, r);
        ruleTest.setRightSide(r);

        //then

        Assert.assertEquals("Failed SetLeftSide", ruleTest.getRightSide(),r);


    }

    @Test
    public void setTerminal() throws Exception {

        //Given
        char c = 'A';
        String s = "FF-[[A]+A]+FF[+FFA]-A";




        //When
        Rule ruleTest = new Rule(c,s);



        //then

        Assert.assertEquals(true, ruleTest.equals(ruleTest));



    }

}
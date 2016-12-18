package com.lsystem.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 16-12-2016.
 */
public class RuleTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getLeftSide() throws Exception {

        char a = 'A';
        Rule ruleTest = new Rule (a);
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
        boolean b = true;



        //When
        Rule ruleTest = new Rule(c,s);
       


        //then

        Assert.assertEquals(true, b);



    }

}
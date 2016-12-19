package com.lsystem.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveLsystemTest {
    String textFileString;
    Grammatik grammatik;
    RecursiveLsystem reclsys;

    @Before
    public void before(){
        textFileString = "A:F[+A][-A],B:BBB,";
        grammatik = new Grammatik(textFileString );

    }
    //Tests
    @Test
    public void expand() throws Exception {
        //Test if method expands and a returns a string using rules from Grammatik, and if reursive method-calls only occur the correct number of times.
        String actual;
        String expected;
        int genNo; //number of recursions to be made
        String parameter;

        //Test 1: String = axiom and genNo is 0. Should return axiom.
        //Given
        textFileString = "A:F[+A][-A],B:ABA,";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        parameter = "A";
        genNo = 0;
        actual = reclsys.expand(parameter,genNo);
        expected = "A";
        //Then
        Assert.assertEquals("Failure: did not expand", expected, actual);


        //Test 2: String = axiom and genNo is 1. Should expand one time.
        //Given
        textFileString = "A:F[+A][-A],B:ABA,";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        parameter = "A";
        genNo = 1;
        actual = reclsys.expand(parameter,genNo);
        expected = "F[+A][-A]";
        //Then
        Assert.assertEquals("Failure: did not expand", expected, actual);

        //Test 3: Ruleset is with more productionrules and genNo is 1. Should expand using one rule.
        //Given
        textFileString = "A:FF[-B]C[+C],B:FF+F-F-F[FFFC][+C]-F-FC,C:FF-F+F+F[B][-B]+F+FB,D:LOL";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        parameter = "A";
        genNo = 1;
        actual = reclsys.expand(parameter,genNo);
        expected = "FF[-B]C[+C]";
        //Then
        Assert.assertEquals("Failure: did not expand", expected, actual);

        //Test 4: Ruleset is with more productionrules and genNo is 2. Should expand using more than one rule.
        //Given
        textFileString = "A:FF[-B]C[+C],B:FF+F-F-F[FFFC][+C]-F-FC,C:FF-F+F+F[B][-B]+F+FB, D:FFFF[A][B]";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        parameter = "A";
        genNo = 2;
        actual = reclsys.expand(parameter,genNo);

        expected = "FF[-FF+F-F-F[FFFC][+C]-F-FC]FF-F+F+F[B][-B]+F+FB[+FF-F+F+F[B][-B]+F+FB]";
        //Then
        Assert.assertEquals("Failure: did not expand", expected, actual);


    }

    @Test
    public void getRuleInRuleset() throws Exception {
        //Test if method returns a rule in Grammatik's ruleset, when given a char
        String actual;
        String expected;
        char testChar;

        //Test 1: char-parameter is in Ruleset and has 1 rule
        //Given
        textFileString = "A:F[+A][-A],B:ABA,";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        testChar = 'A';
        actual = reclsys.getRuleInRuleset(testChar);
        expected = "F[+A][-A]";
        //Then
        Assert.assertEquals("Failure: did not return the rule for char", expected, actual);

        //Test 2: char-parameter is in Ruleset and has more than 1 rule
        //Given
        textFileString = "A:F[+A][-A],A:F[-FA][-A],A:FF[++A],";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        testChar = 'A';
        actual = reclsys.getRuleInRuleset(testChar);

        String expected1 = "F\\[\\+A\\]\\[\\-A\\]";
        String expected2 = "F\\[\\-FA\\]\\[\\-A\\]";
        String expected3 = "FF\\[\\+\\+A\\]";
        String expectedRegex = expected1 +"|"+expected2+"|"+expected3; //regular expression or to check if a random rule has been chosen
        //Then
        Assert.assertTrue("Failure: did not return the rule for char", actual.matches(expectedRegex));

        //Test 3: char-parameter is not in Ruleset and returns an empty string
        //Given
        textFileString = "A:F[+A][-A],B:F[-FA][-A],C:FF[++A],";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        testChar = 'D';
        actual = reclsys.getRuleInRuleset(testChar);
        expected = "";

        //Then
        Assert.assertEquals("Failure: did not return the rule for char", expected, actual);

        //Test 4: char-parameter is a primitive in Ruleset, which has not rules. Therefore it should return null
        //Given
        textFileString = "A:F[+A][-A],B:F[-FA][-A],C:FF[++A],";
        grammatik = new Grammatik(textFileString);
        reclsys = new RecursiveLsystem(grammatik);
        //When
        testChar = '[';
        actual = reclsys.getRuleInRuleset(testChar);
        expected = null;
        //Then
        Assert.assertEquals("Failure: did not return the rule for char", expected, actual);
    }

    @Test
    public void setTreeString() throws Exception {

    }

    @Test
    public void getTreeString() throws Exception {

    }

}
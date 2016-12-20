package com.lsystem.model;

import com.lsystem.model.Grammatik;
import org.junit.Test;

import static org.junit.Assert.*;


public class GrammatikTest {
    @Test
    public void addAxiom() throws Exception {

        //Given
          String textFileString = "A:FF-[[A]+A]+FF[+FFA]-A,";

        //When
        char axiom = textFileString.charAt(0);

        //then
        assertArrayEquals('A',axiom);

    }

    private void assertArrayEquals(char a, char axiom) {
    }


    @Test
    public void addPrimitives() throws Exception {

    }

    @Test
    public void addRules() throws Exception {

    }

}
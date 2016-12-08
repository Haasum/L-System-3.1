package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MasterWillis on 03/12/2016.
 */
public class Txt {

    public Txt() throws IOException {
        checkTxt();
    }

    public String checkTxt() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src//TextfilePackage//txt.txt"));
            StringBuilder sb = new StringBuilder();
            String line;
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch
                        (IOException e) {
                    e.printStackTrace();
                }
                String inputFromText = sb.toString();
                return inputFromText;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //public String getTxtInput() { //her er outputtet samlet efter randommetoder er kørt
        //return this.inputFromTxt; // når input fra textFil skal virke
}

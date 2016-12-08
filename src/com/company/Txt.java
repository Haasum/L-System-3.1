package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Txt {

    public Txt() throws IOException {
        checkTxt();
    }

    public String checkTxt() throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src//TextfilePackage//txt.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
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

}

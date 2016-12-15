package com.lsystem.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextfileReader {

    public TextfileReader() throws IOException {
        getText();
    }

    public String getText() throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src//textfile_package//txt5.txt")); //SETS WHICH TEXTFILE TO READ
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
                String inputFromTextFile = sb.toString();
                return inputFromTextFile;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package com.lsystem.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextfileReader {

    /***
     * Constructs the text file reader object
     * <p>
     *     Consist of the method getText, which gets and parse the text as a String
     * </p>
     * @throws IOException
     */
    public TextfileReader() throws IOException {
        getText();
    }

    /**
     * Converts the text from a textFile to a String.
     * <p>
     *     This gets the a text from the chosen textfile.
     *     This contains a while-loop that runs for as many lines that the chosen text file contains.
     *     The lines in the textfile a added to a StringBuilder (sb), and when there are no more lines to read,
     *     the value of the StringBuilder is converted to a String.
     *     It is that string that the method returns. thereby converting a textfile to a String.
     * </p>
     * @return a String generated from a text file
     * @throws IOException //TODO: fælles hjælp hilsen naja
     */
    public String getText() throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src//textfile_package//txt.txt")); //SETS WHICH TEXTFILE TO READ
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) { //while loop that runs for each line in the textfile
                sb.append(line); //adds the line to the StringBuilder
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch
                        (IOException e) {
                    e.printStackTrace();
                }
                String inputFromTextFile = sb.toString(); //sets the inputFromTextFile to the value of sb (StringBuilder)
                return inputFromTextFile;
            }
        } catch (FileNotFoundException e) { //if no file is found
            e.printStackTrace(); //a print that is used for diagnosing the Exception (= file not found).
        }
        return null;
    }

}

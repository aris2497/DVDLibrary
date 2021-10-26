package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class example {
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */


    public static void main(String[] args) {
        /*
        1. Variables declared outside of try ... catch{} block
         */
        // 1. Set up File object
        File fileName = new File("Input.txt");
        FileReader file = null;
        String values[][] = new String[3][]; // This 2D array will store the values

        try {
            file = new FileReader(fileName);                // Needed to read file
            BufferedReader lines = new BufferedReader(file); // Needed to read each line
            for (int i = 0; i < values.length; i++) {
                values[i] = lines.readLine().split(","); // Splits string into an array and store it in
                // the 2D array values @ point j
                System.out.println(Arrays.toString(values[i])); // Print out the contents
            }
            file.close(); // N.B. Close the file!!!!
        } catch (FileNotFoundException ex) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Now total up the values in the array itself
        // 1. Loop thro' the array of strings
        // 2. Parse the values from String to int/double
        // 3. sumOfArray is now incremented by the value in the values array
        int diffMinMax = 0; // Variables needed for calculations
        int min = Integer.parseInt(values[0][0]); // Assuming min / max to be first value
        int max = Integer.parseInt(values[0][0]); // Parsing converts String to numeric form

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int tempVariable = Integer.parseInt(values[i][j]); // Parse the values as stepping thro'
                if (min > tempVariable) {
                    min = tempVariable;
                }
                if (max < tempVariable) {
                    max = tempVariable;
                }
            }
        }
        diffMinMax = max - min;
        System.out.println("The difference is " + diffMinMax);
        /**
         * File Writing Logic
         */
        int arrOut[] = {5, 100, 115, 20};
        File fileNameOut = new File("Output.txt");
        try {
            FileWriter fw = new FileWriter(fileNameOut);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < arrOut.length; i++) {
                Integer x = arrOut[i];
                bw.write(x.toString() + ",");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {

        }
    }
}


package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Model class of the MVC program
 *
 * class responsible for reading from, and writing to the file
 * DVD entries are stored and modified in arrayList dvds
 *
 * @author paulina
 */

public class DVDStorage {

    private static final File fileName = new File("films.csv"); //file with DVD
    public static ArrayList<DVD> dvds = new ArrayList<>(); //arrays for sorting DVDs data

    /**
     * File reading Logic
     */
    public static void loadDVDs() {
        try {
            FileReader file = new FileReader(fileName);//reading the file
            BufferedReader lines = new BufferedReader(file);
            String newLine = lines.readLine();
            int i = 1;
            while (newLine != null) { //reading values until end of file is reached
                String[] values = newLine.split(","); // Splits string into an array and store it in

                DVD dvd = new DVD(i, values[0], values[1], values[2], //creating new DVD object from the file line
                        values[3], values[4], values[5]);
                dvds.add(dvd);
                newLine = lines.readLine();
                i++; //increasing id value
            }
            file.close(); //Closing the file

        } catch (FileNotFoundException ex) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveDVDs(ArrayList<DVD> array) {
        /**
         * File Writing Logic
         */
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            //getting values from the array and writing into file with comas to separate values
            for (int i = 0; i < array.size(); i++) {
                DVD dvd = array.get(i);
                bw.write(dvd.getTitle() + ", " + dvd.getRealiseDate() + ", " + dvd.getMppaRating()
                        + ", " + dvd.getDirector() + ", " + dvd.getStudio() + ", " + dvd.getUserRating() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}

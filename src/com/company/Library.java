package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Controller class of the MVC program
 *
 * @author paulina
 */

public class Library {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        /**
         * getting values from the file into array
         */

        //reading DVDs from the file and saving values to the array
        DVDStorage.loadDVDs();

        //decides if to exit the program
        boolean isOn = true;

        //for users input
        Scanner scanner = new Scanner(System.in);

        /**
         * welcome prompt asks for a integer indicating the following actions
         * switching through users input
         *
         */
        while(isOn){
            Console.welcomePrompt();
            int input = scanner.nextInt();
            switch(input){
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    displayInfo();
                    break;
                case 6:
                    search();
                    break;
                default:
                    Console.noMatch();
            }//end of switch
            isOn = isOn();
        }//end of while

        //writing modified data back to the file
        DVDStorage.saveDVDs(DVDStorage.dvds);
    }//end of main

    private static boolean isOn() {
        Scanner scanner = new Scanner(System.in);
        String anotherQuery;
        boolean isOn;
        System.out.println("Have another query? Press [y] if yes if wish to continue " +
                "or any other symbol to exit.");
        anotherQuery = scanner.nextLine();
        if(anotherQuery.equalsIgnoreCase("y") | anotherQuery.equalsIgnoreCase("yes")){
            isOn = true;
        } else {
            System.out.println("bye!");
            isOn = false;
            //save the dvds array to the file
        }//end of if
        return isOn;
    }


    /**
     * displaying lists of DVDs based on the entered title
     */
    private static void search() {
        Console.searchDVDPrompt();
        Scanner scanner = new Scanner(System.in);
        boolean result = false;

        //getting title entered by the user
        String title = scanner.nextLine();
        for (DVD dvd: DVDStorage.dvds
        ) {
            if(dvd.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT))){
                //displaying yer or no
                result = true;
                System.out.println("Yes, DVD is in the collection. It's ID is " + dvd.getId() + ".");
            }//end of if
        }//end of foreach
        if(!result){
            System.out.println("No, there is no DVDs with this title in our Library.");
        }
    }//end of method

    /**
     * Firstly, asking user for the title of the DVD they wish to edit
     * Secondly, asking user for the name of field that should be edited
     * Lastly, replacing the old value with the value entered by the user
     */

    private static void editDVD() {
        String title, date, age, director, studio, rating;
        Console.editDVDPrompt();
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (DVD dvd: DVDStorage.dvds
        ) {
            if(dvd.getId() == id){
                Console.displayDVD(dvd);
                Console.editDVDFieldPrompt();//asking which field user wishes to edit
                Scanner scanner1 = new Scanner(System.in);
                String input = scanner1.nextLine();
                System.out.println("Enter new value: ");
                Scanner scanner2 = new Scanner(System.in);
                String newValue = scanner2.nextLine();
                switch(input.toLowerCase(Locale.ROOT)){
                    case "title":
                        dvd.setTitle(newValue);
                        break;
                    case "realise date":
                        dvd.setRealiseDate(newValue);
                        break;
                    case "mppa rating":
                        dvd.setMppaRating(newValue);
                        break;
                    case "director":
                        dvd.setDirector(newValue);
                        break;
                    case "studio":
                        dvd.setStudio(newValue);
                        break;
                    case "user rating":
                        dvd.setUserRating(newValue);
                        break;
                    default:
                        Console.noMatch();
                }//end of switch

            }//end of if
        }//end of foreach
    }

    /**
     * displaying information on the DVD based on the entered title
     */
    private static void displayInfo() {
        //prompt asking for the title
        Console.displayDVDsInfo();
        Boolean isAvailable = false;
        Scanner scanner = new Scanner(System.in);
        //getting title entered by the user
        String title = scanner.nextLine();
        for (DVD dvd: DVDStorage.dvds
             ) {
            //finding the DVD that title matches the title entered by the user
            if(dvd.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT))){
                //displaying all the information on the requested DVD
                isAvailable = true;
                Console.displayDVD(dvd);
            }
        }//end of foreach
        //informing the user there is no matching title
        if(!isAvailable){
            Console.noMatch();
        }
    }//end of method

    /**
     * removing DVD from the array where id equals to user input
     * for the indexing order consistency every id after the removed DVD is increased by 1
     *
     *
     */
    private static void removeDVD() {
        Console.removeDVDPrompt();
        Scanner scanner = new Scanner(System.in);
        int id  = scanner.nextInt();
        DVDStorage.dvds.remove(id - 1 );
        for(int i = id; i <= DVDStorage.dvds.size(); i++){
            DVDStorage.dvds.get(i - 1).setId(DVDStorage.dvds.get(i-1).getId() - 1);
            //System.out.println(DVDStorage.dvds.get(i));
        }//end of for

        //displaying information that DVD entry has been removed
        Console.DVDRemovedPrompt();

        listDVDs();
    }//end of method

    /**
     * Displaying all the current DVDs stored in the dvds array
     */

    private static void listDVDs() {
        Console.displayAll();

        for(int i = 0; i < DVDStorage.dvds.size(); i++){
            Console.displayDVD(DVDStorage.dvds.get(i));
        }//end of for
    }//end of method

    /**
     * collecting users new DVD entries,
     * creating new DVD object, passing the DVD values to the constructor
     * adding new object to the array of dvds
     *
     */

    private static void addDVD() {
        String title, date, age, director, studio, rating;

        Console.addDVDPrompt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        title = scanner.nextLine();
        System.out.println("Realise Date: ");
        date = scanner.nextLine();
        System.out.println("Mppa Rating: ");
        age = scanner.nextLine();
        System.out.println("Director: ");
        director = scanner.nextLine();
        System.out.println("Studio: ");
        studio = scanner.nextLine();
        System.out.println("Rating: ");
        rating = scanner.nextLine();

        //instantiating new DVD object and adding it to existing array of dvds
        DVD dvd = new DVD(DVDStorage.dvds.size() + 1, title, date, age, director, studio, rating);
        DVDStorage.dvds.add(dvd);
    }//end of method

}//end of class

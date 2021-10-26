package com.company;

/**
 * View class of the MVC program
 * Stores all users prompts
 *
 * @author paulina
 */
public class Console {
    public static void welcomePrompt(){
        System.out.println("Welcome to the DVD library!\n " +
                "If you'd like to add a DVD, press 1.\n " +
                "If you'd like to remove a DVD, press 2.\n " +
                "If you'd like to edit a DVD entry, press 3.\n " +
                "If you'd like to list the DVDs, press 4.\n " +
                "If you'd like to display the DVD info press 5.\n " +
                "If you'd like to search DVD by title, press 6. ");
    }

    public static void displayAll(){
        System.out.println("Here are all currently available DVDS: ");
    }
    public static void displayDVDsInfo(){
        System.out.println("Enter the title of the film you with to see detailed information on: ");

    }
    public static void addDVDPrompt(){
        System.out.println("To add a DVD to the library," +
                " provide the following details: ");
    }

    public static void removeDVDPrompt(){
        System.out.println("Enter ID of the DVD you wish to remove from the library");
    }
    public static void DVDRemovedPrompt(){
        System.out.println("The DVD has been removed from the library.");
    }
    public static void editDVDPrompt(){
        System.out.println("To edit a DVD in the library provide following details.\n" +
                "What is the id of the DVD you'd like to edit?");
    }
    public  static void editDVDFieldPrompt(){
        System.out.println("Which information do you wish to change?");
        System.out.println("Title, Realise Date, MPPA Rating, Director, Studio or User Rating?");
    }
    public static void searchDVDPrompt(){
        System.out.println("To search if the DVD is in the collection, please provide the title: ");
    }
    public static void displayDVD(DVD dvd){
        System.out.println("ID: "+ dvd.getId() + ", Title: " + dvd.getTitle() + ", Realise Sate: " + dvd.getRealiseDate() +
                ", MPPA Rating: " + dvd.getMppaRating() + ", Director: " + dvd.getDirector() +
                ", Studio: " + dvd.getStudio() + ", User Rating: " + dvd.getUserRating());
    }
    public static void noMatch(){
        System.out.println("Your choice doesn't match any of the options.");
    }


}

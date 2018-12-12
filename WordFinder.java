// Name: Xiaoyu Gao
// USC NetID: xiaoyuga
// CS 455 PA4
// Fall 2018

import java.util.*;
import java.io.FileNotFoundException;

/**
 class WordFinder
 This contains the main method. This class will have a main that's responseble for processing the command
 line argument, and handing any error processing. It also have the main command loop. Most of the other
 functionality will be delegated to other objects created in main and their methods. When running the
 program, to enable taking other dictionary rather than "AnagramDictionary", you need to type:

 java WordFinder [the name of other dictionary]

 And you need to wait for few seconds after showing "Type . to quit." for the program to process the
 dictionary in advance if it is a quite large dictionary.
 */

public class WordFinder {

    /**
     method main
     Main method of this program. This method contains judgement of file name, pre-processing for the
     input dictionary, then call the mainHelper method to do the main loop.
     */
    public static void main(String[] args) {

        String fileName = "";

        //Use argument to check if our target dictionary is "sowpods.txt" or not.
        if (args.length < 1) {
            fileName = "sowpods.txt";
        } else {
            fileName = args[0];
        }

        System.out.println("Type . to quit.");

        //Initialize objects that we need to use.
        Scanner sc = new Scanner(System.in);
        Rack enteredRack = new Rack();
        AnagramDictionary orderedDictionary;
        try {
            orderedDictionary = new AnagramDictionary(fileName);
        } catch (FileNotFoundException exc) {
            // Return error message and terminate the program if we cannot find the dictionary.
            System.out.println("ERROR: File not found: " + fileName);
            return;
        }

        // Run mainHelper method
        mainHelper(sc, enteredRack, orderedDictionary);
        sc.close();

    }

    /**
     method mainHelper
     This method mainly contain the main command loop. Read input from user, and then output the
     information that we expected.
     */

    private static void mainHelper(Scanner sc, Rack enteredRack, AnagramDictionary orderedDictionary) {

        System.out.print("Rack? ");
        String userInput = sc.nextLine();    //Read the first input from user.
        // Main command loop
        while(!userInput.equals(".")) {    // Terminate when user input a dot.
            String modifiedInput = userInput.replaceAll("[^a-zA-Z]", "");   //Remove all characters that are not "a" to "z" and "A" to "Z"

            ArrayList<String> allCombos = enteredRack.getAllCombos(modifiedInput);  // Get all combos from the input rack.
            // Get all words from dictionary from the combos then store them in outputList.
            ArrayList<String> outputList = new ArrayList<String>();

            for(int i = allCombos.size() - 1; i >= 0; i--) {
                outputList.addAll(orderedDictionary.getAnagramsOf(allCombos.get(i)));
            }

            System.out.println("We can make " + outputList.size() + " words from \"" + userInput + "\"");
            // If some words show in the outputList, then print them out.
            if(outputList.size() != 0) {
                System.out.println("All of the words with their scores (sorted by score):");
                enteredRack.showList(outputList);
            }

            System.out.print("Rack? ");
            userInput = sc.nextLine();
        }

    }

}
// Name: Xiaoyu Gao
// USC NetID: xiaoyuga
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


/**
 A dictionary of all anagram sets.
 Note: the processing is case-sensitive; so if the dictionary has all lower
 case words, you will likely want any string you test to have all lower case
 letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {

    private Map<Map<Character, Integer>, ArrayList<String>> orderedDictionary;

    /**
     Create an anagram dictionary from the list of words given in the file
     indicated by fileName.
     PRE: The strings in the file are unique.
     @param fileName  the name of the file to read from
     @throws FileNotFoundException  if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        File targetDictionary = new File(fileName);   //Get the dictionary file, it may throw FileNotFoundException.
        Scanner sc = new Scanner(targetDictionary);   //Use scanner to read the dictionary.

        //I pre-processing the dictionary and store the ordered dictionary in the "orderedDictionary" map.
        orderedDictionary = new HashMap<Map<Character, Integer>, ArrayList<String>>();

        //Use other parameters here to help me generate the "orderedDictionary" map.
        Map<Character, Integer> wordComponent;
        ArrayList<String> matchedWord;
        String nextWord = "";

        //Use this loop to read the dictionary line by line.
        while(sc.hasNext()) {
            nextWord = sc.next();

            //Use a HashMap to store the component of this word, like how many 'a' in this word or 'b' or 'c'...
            wordComponent = new HashMap<Character, Integer>();

            //Use this for loop to go through this word.
            for(int i = 0; i < nextWord.length(); i++) {
                char alphabet = nextWord.charAt(i);
                int alphabetCount = 0;
                //If we already have that alphabet in the map, add its value by one.
                //If not, then create a new entry in the map.
                if(wordComponent.containsKey(alphabet)) {
                    alphabetCount = wordComponent.get(alphabet) + 1;
                } else {
                    alphabetCount = 1;
                }
                wordComponent.put(alphabet, alphabetCount);
            }

            //If we already get some words with the same component of this word, then append this word in the
            //arrayList correlated to this specific component. If we can't find this component in
            //"orderedDictionary" map by now, then create a new entry in the map.
            if(orderedDictionary.containsKey(wordComponent)) {
                matchedWord = orderedDictionary.get(wordComponent);
                matchedWord.add(nextWord);
            } else {
                matchedWord = new ArrayList<String>();
                matchedWord.add(nextWord);
            }
            orderedDictionary.put(wordComponent, matchedWord);

        }

    }


    /**
     Get all anagrams of the given string. This method is case-sensitive.
     E.g. "CARE" and "race" would not be recognized as anagrams.
     @param s string to process
     @return a list of the anagrams of s
     */
    public ArrayList<String> getAnagramsOf(String s) {

        //Use a HashMap to store the component of this word, like how many 'a' in this word or 'b' or 'c'...
        Map<Character, Integer> targetStringComponent = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            int alphabetCount = 0;
            //If we already have that alphabet in the map, add its value by one.
            //If not, then create a new entry in the map.
            if(targetStringComponent.containsKey(alphabet)) {
                alphabetCount = targetStringComponent.get(alphabet) + 1;
            } else {
                alphabetCount = 1;
            }
            targetStringComponent.put(alphabet, alphabetCount);
        }

        //Then, we can use the map we generaetd before as the key of "orderedDictionary", and use the key
        //to get all the words that have the same component from "orderedDictionary".
        if(orderedDictionary.containsKey(targetStringComponent)) {
            return orderedDictionary.get(targetStringComponent);
        } else {
            return new ArrayList<String>();
        }

    }

}

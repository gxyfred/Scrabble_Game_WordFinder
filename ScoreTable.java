// Name: Xiaoyu Gao
// USC NetID: xiaoyuga
// CS 455 PA4
// Fall 2018

import java.util.*;

/**
 class ScoreTable
 We store the value of each alphabet in a Map called alphabetValue.
 */

public class ScoreTable {

    private Map<Character, Integer> alphabetValue;

    /**
     method ScoreTable
     The constructor function, we create a new HashMap and store the value
     of each alphabet in this Map.
     */
    public ScoreTable() {
        alphabetValue = new HashMap<Character, Integer>();
        alphabetValue.put('a', 1);
        alphabetValue.put('A', 1);
        alphabetValue.put('b', 3);
        alphabetValue.put('B', 3);
        alphabetValue.put('c', 3);
        alphabetValue.put('C', 3);
        alphabetValue.put('d', 2);
        alphabetValue.put('D', 2);
        alphabetValue.put('e', 1);
        alphabetValue.put('E', 1);
        alphabetValue.put('f', 4);
        alphabetValue.put('F', 4);
        alphabetValue.put('g', 2);
        alphabetValue.put('G', 2);
        alphabetValue.put('h', 4);
        alphabetValue.put('H', 4);
        alphabetValue.put('i', 1);
        alphabetValue.put('I', 1);
        alphabetValue.put('j', 8);
        alphabetValue.put('J', 8);
        alphabetValue.put('k', 5);
        alphabetValue.put('K', 5);
        alphabetValue.put('l', 1);
        alphabetValue.put('L', 1);
        alphabetValue.put('m', 3);
        alphabetValue.put('M', 3);
        alphabetValue.put('n', 1);
        alphabetValue.put('N', 1);
        alphabetValue.put('o', 1);
        alphabetValue.put('O', 1);
        alphabetValue.put('p', 3);
        alphabetValue.put('P', 3);
        alphabetValue.put('q', 10);
        alphabetValue.put('Q', 10);
        alphabetValue.put('r', 1);
        alphabetValue.put('R', 1);
        alphabetValue.put('s', 1);
        alphabetValue.put('S', 1);
        alphabetValue.put('t', 1);
        alphabetValue.put('T', 1);
        alphabetValue.put('u', 1);
        alphabetValue.put('U', 1);
        alphabetValue.put('v', 4);
        alphabetValue.put('V', 4);
        alphabetValue.put('w', 4);
        alphabetValue.put('W', 4);
        alphabetValue.put('x', 8);
        alphabetValue.put('X', 8);
        alphabetValue.put('y', 4);
        alphabetValue.put('Y', 4);
        alphabetValue.put('z', 10);
        alphabetValue.put('Z', 10);

    }

    /**
     method getScore
     Get the value of the alphabet c.
     */
    public int getScore(char c) {
        return alphabetValue.get(c);
    }

}
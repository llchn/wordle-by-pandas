package backend;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author Felicia Nemoto-Pace
 * Sources used: previous programming assignments, 
 * 
 */
public class Game {

    // String that stores correct guess
    private static String correctGuess = Dictionary.getValidTarget();

    // String that stores user's current guess
    private static String userGuess =  ""; // Mainboard.getUserInput();

    // String to store all possible input values
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that are correct
    private static String existingLetters = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that have not been tried
    private static String lettersNotTried = "abcdefghijklmnopqrstuvwxyz";

    static final Color green = Color.decode("#538D4E");
    static final Color yellow = Color.decode("#B59F3B");
    static final Color gray = Color.decode("#3A3A3C");
    static final Color orange = Color.decode("#F5793A");
    static final Color lightBlue = Color.decode("#85C0F9");
    
 // HashMap to store letters for userGuess and corresponding color in grid
     private static HashMap<Character, Color> gridMap = new HashMap<>(5);
    
 // HashMap to store letters on keyboard and corresponding color
    private static HashMap<Character, Color> keyboardMap = new HashMap<>(26);


    public Game() {
        // store letters of userGuess in map
        for (int i = 0; i < userGuess.length(); i++) {
            keyboardMap.put(alphabet.charAt(i), gray);
        }

        // store letters of alphabet in map
        for (int j = 0; j < alphabet.length(); j++) {
            keyboardMap.put(alphabet.charAt(j), gray);
        }
    }



    /**
     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
     * @param letter to be checked
     * @return true if absence known
     */
    public static boolean absenceKnown(char letter) {
        // if letter exists in existingLetters, then the absence is not known
        if (existingLetters.indexOf(letter) > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
     * @param letter to be checked
     * @return true if absence known
     */
    public static boolean presenceKnown(char letter) {
        // if letter exists in existingLetters, then presenceKnown
        if (existingLetters.indexOf(letter) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
     * @param letter to be checked
     * @return true if letter has not been tried
     */
    public boolean keyNotTried(char letter) {
        // if letter exists in lettersNotTried, return true
        if (lettersNotTried.indexOf(letter) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks a letter is in the correct spot on the grid
     * @param letter to be checked
     * @return true if letter has not been tried
     */
    public static boolean letterLocationKnown(char letter) {
        //to be filled
        return false;
    }

    /**
     * Updates colors of grid and keyboard
     */
    //    public static void updateColors() {
    //        // for item in gridMap, update color using stored color
    //        for (Map.Entry<Character, Color> entry : gridMap.entrySet()) {
    //            color = entry.getValue();
    //        }
    //        // for item in keyboardMap, update color using stored color
    //        for (Map.Entry<Character, Color> entry : keyboardMap.entrySet()) {
    //            color = entry.getValue();
    //        }
    //
    //        return;
    //    }

    /**
     * Switches the existing colors on the board to a high contrast mode for accessibility 
     */
    public static void highContrastMode() {
        // for each square in the grid
        // if color is yellow switch to light blue
        // if color is green switch to orange
        // for each key in keyboard
        // if color is yellow switch to light blue
        // if color is green switch to orange
        return;
    }

    /**
     * Switches the existing colors on the board to a high contrast mode for accessibility 
     */
    public static void normalMode() {
        // for each square in the grid
        // if color is light blue switch to yellow
        // if color is orange switch to green
        // for each key in keyboard
        // if color is light blue switch to yellow
        // if color is orange switch to green
        return;
    }

    /**
     * Play game.
     */
    public static void main (String[] args) {
        // if user presses return
        //check if colorBlindMode is on
        if (true) { //colorBlindButtonPressed
            highContrastMode();
        }
        // if colorBlindMode is off
        if (true) { //colorBlindButtonPressed
            normalMode();
        }
        // Error message "Not in word list" if word is not in dictionary
        if (!Dictionary.isValidGuess(userGuess)) {
            // popup error message "Not in word list"
        }
        // Error message "Too short" if fewer than 5 letters 
        // Error message "Too long" if more than 5 letters 
        // if user has won, no longer accept user input
        if (correctGuess == userGuess) {
            // popup with message that they won
            // end game
        }
        // if valid
        if (Dictionary.isValidGuess(userGuess)) {
            // update colors accordingly
            for (char c : userGuess.toCharArray()) {
                if (presenceKnown(c) && letterLocationKnown(c)){
                    // set square to green
                    gridMap.put(c, green);
                    // set keyboard to green
                } else if (absenceKnown(c)) {
                    // set square to dark gray
                    gridMap.put(c, gray);
                    // set keyboard to dark gray
                } else if (presenceKnown(c)) {
                    // set square to yellow
                    gridMap.put(c, yellow);
                    // set keyboard to yellow
                }
            }
        }
        // else
        // error message

    }
}



package wordle;

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
    private static String userGuess = "";
    
    // String to store all possible input values
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    // String to store remaining letters that are correct
    private static String existingLetters = "abcdefghijklmnopqrstuvwxyz";
    
    // String to store remaining letters that have not been tried
    private static String lettersNotTried = "abcdefghijklmnopqrstuvwxyz";
    
    // HashMap to store letter and correct position
    private static HashMap<Character, Color> correctPositionForLetter = new HashMap<>(5);
    
    /**
     * Takes the 5-letter correctGuess and stores its letter and position
     * @return map with correct letter and position correlations
     */
//    public HashMap absenceKnown() {
//        int currentLocation = 1;
//        for (char c : correctGuess.toCharArray()) {
//            correctPositionForLetter.put(currentLocation, c);
//            currentLocation++;
//        }
//        return correctPositionForLetter;
//    }
    
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
     * Play game.
     */
    public static void main (String[] args) {
        // if user presses return
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
                for (char l : userGuess.toCharArray()) {
                    if (presenceKnown(l) && letterLocationKnown(l)){
                        // set square to green
                        // set keyboard to green
                    } else if (absenceKnown(l)) {
                        // set square to dark gray
                        // set keyboard to dark gray
                    } else if (presenceKnown(l)) {
                        // set square to yellow
                        // set keyboard to yellow
                    }
                }
            }
            // else
                // error message
        
    }
    
   
  
}
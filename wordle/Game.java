package wordle;

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
    String correctGuess = Dictionary.getWord();
    
 // String that stores user's current guess
    String userGuess = "";
    
    // String to store all possible input values
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    // String to store remaining letters that are correct
    String existingLetters = "abcdefghijklmnopqrstuvwxyz";
    
    // String to store remaining letters that have not been tried
    String lettersNotTried = "abcdefghijklmnopqrstuvwxyz";
    
    // HashMap to store letter and correct position
    HashMap<Char, Integer> correctPositionForLetter = new HashMap<>(5);
    
    /**
     * Takes the 5-letter correctGuess and stores its letter and position
     * @return map with correct letter and position correlations
     */
    public HashMap absenceKnown() {
        int currentLocation = 1;
        for (Char c : correctGuess) {
            correctPositionForLetter.put(currentLocation, c);
            currentLocation++;
        }
        return correctPositionForLetter;
    }
    
    /**
     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
     * @param letter to be checked
     * @return true if absence known
     */
    public boolean absenceKnown(char letter) {
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
    public boolean presenceKnown(char letter) {
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
    public boolean letterLocationKnown(char letter) {
        //to be filled
        return false;
    }

    /**
     * 
     */
    public static void main (String[] args) {
        // if user presses return
            if (Dictionary.isValidGuess(userGuess)) {
                // update colors accordingly
                for (letter l : userGuess) {
                    if (presenceKnown() && letterLocationKnown()){
                        // set square to green
                        // set keyboard to green
                    } else if (absenceKnown()) {
                        // set square to dark gray
                        // set keyboard to dark gray
                    } else if (presenceKnown()) {
                        // set square to yellow
                        // set keyboard to yellow
                    }
                }
            }
            // else
                // error message
        
    }
    
   
  
}
    
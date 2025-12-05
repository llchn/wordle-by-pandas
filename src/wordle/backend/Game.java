package backend;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import ui.MainBoard; 

/**
 * 
 * 
 * @author Felicia Nemoto-Pace
 * Sources used: previous programming assignments, 
 * 
 */
public class Game {

    // String that stores correct guess
    private static String correctWord = "teeth";

    // String that stores user's current guess
    private static String userGuess =  "eerie"; 

    // String to store all possible input values
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that are correct
    private static String existingLetters = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that have not been tried
    private static String lettersNotTried = "abcdefghijklmnopqrstuvwxyz";
    
    // colors for standard mode
    static final Color GREEN = new Color(98,183,61); 
    static final Color YELLOW = new Color(200,182,83);
    static final Color GRAY = new Color(120,124,127); 
    
    // colors for high contrast mode 
    static final Color ORANGE = new Color(255,130,5); 
    static final Color LIGHT_BLUE = new Color(0,134,255); 
    
    // HashMap to store letters for userGuess and corresponding color in grid
     private static HashMap<Character, Color> gridMap = new HashMap<>(5);
    
     // HashMap to store letters on keyboard and corresponding color
    private static HashMap<Character, Color> keyboardMap = new HashMap<>(26);


    public Game() {
        // store letters of userGuess in map
        for (int i = 0; i < userGuess.length(); i++) {
            keyboardMap.put(alphabet.charAt(i), GRAY);
        }

        // store letters of alphabet in map
        for (int j = 0; j < alphabet.length(); j++) {
            keyboardMap.put(alphabet.charAt(j), GRAY);
        }
    }



//    /**
//     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
//     * @param letter to be checked
//     * @return true if absence known
//     */
//    public static boolean absenceKnown(char letter) {
//        // if letter exists in existingLetters, then the absence is not known
//        if (existingLetters.indexOf(letter) > 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /**
//     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
//     * @param letter to be checked
//     * @return true if absence known
//     */
//    public static boolean presenceKnown(char letter) {
//        // if letter exists in existingLetters, then presenceKnown
//        if (existingLetters.indexOf(letter) > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * Checks a letter to see if absence is known and colors keyboard and mainboard accordingly
//     * @param letter to be checked
//     * @return true if letter has not been tried
//     */
//    public boolean keyNotTried(char letter) {
//        // if letter exists in lettersNotTried, return true
//        if (lettersNotTried.indexOf(letter) > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * Checks a letter is in the correct spot on the grid
//     * @param letter to be checked
//     * @return true if letter has not been tried
//     */
//    public static boolean letterLocationKnown(char letter) {
//        //to be filled
//        return false;
//    }

    /**
     * Switches the existing colors on the board to a high contrast mode for accessibility 
     */
    public static void highContrastMode(char letter) {
        // for each square in the grid
        for (Map.Entry<Character, Color> entry : gridMap.entrySet()) {
            if (gridMap.get(letter) == YELLOW) { // if color is yellow switch to light blue
                gridMap.put(letter, LIGHT_BLUE);
            } else if (gridMap.get(letter) == GREEN) { // if color is green switch to orange
                gridMap.put(letter, ORANGE);
            }
        }

        // for each key in keyboard
        for (Map.Entry<Character, Color> entry : keyboardMap.entrySet()) {
            if (keyboardMap.get(letter) == YELLOW) { // if color is yellow switch to light blue
                keyboardMap.put(letter, LIGHT_BLUE);
            } else if (keyboardMap.get(letter) == GREEN) { // if color is green switch to orange
                keyboardMap.put(letter, ORANGE);
            }
        }
        return;
    }

    /**
     * Switches the existing colors on the board to a high contrast mode for accessibility 
     */
    public static void normalMode(char letter) {
        // for each square in the grid
        // if color is light blue switch to yellow
        // if color is orange switch to green
        // for each key in keyboard
        // if color is light blue switch to yellow
        // if color is orange switch to green
        return;
    }
    
    /**
     * check and update colors for each guess made by user
     * @param inputGuess 
     */
    public static Color[] getColorsForInput (String inputGuess, String targetWord) {
        Color[] rowColors = new Color[5];
        HashMap<Character, Integer> targetCount = new HashMap<>(); 
        // put into a hashmap to store the count of each letter in target word
        for (char c : targetWord.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0)+1); 
        }
        
        // setting color to green if there are correct matches (location + presence)
        for (int i =0; i<5; i++) { 
            char targetLetter = targetWord.charAt(i); 
            char inputLetter = inputGuess.charAt(i);
            
            
            if (targetLetter==inputLetter) {
                rowColors[i] = GREEN; 
                targetCount.put(targetLetter, targetCount.get(targetLetter)-1);   
            }
        }
        // setting color to yellow if there are presence matches
        for (int i=0; i< 5; i++) {
            char inputLetter = inputGuess.charAt(i); 
            // skip this check if the character has a color already
            if (rowColors[i]!=null) { 
                continue;
            }
            // check if this letter from input exists in the target word and it hasnt used up yet
            if(targetCount.containsKey(inputLetter)&&targetCount.get(inputLetter)>0) {
                rowColors[i] = YELLOW; 
                targetCount.put(inputLetter, targetCount.get(inputLetter)-1);                
            }
            // otherwise (the input letter neither exists in target nor at the correct location), set as gray
            else { 
                rowColors[i] = GRAY; 
            }
        }
        return rowColors;
        
    }
    
    /**
     * Play game.
     */
    public static void main (String[] args) {
        System.out.println("hello");
        String[] resultColor = new String[5]; 
        Color[] colorOutput= getColorsForInput(userGuess, correctWord);
        int count = 0;
        for(Color color : colorOutput) { 
            if(color.equals(GREEN)) {
                resultColor[count] = "green";        
            }
            else if (color.equals(YELLOW)){
                resultColor[count] = "yellow";  
            }
            else { 
                resultColor[count] = "gray";      
            }
            count++;
        }
        System.out.println(Arrays.toString(resultColor));
//        // if user presses return
//        //check if colorBlindMode is on
//        if (true) { //colorBlindButtonPressed
//            highContrastMode();
//        }
//        // if colorBlindMode is off
//        if (true) { //colorBlindButtonPressed
//            normalMode();
//        }
    }
}



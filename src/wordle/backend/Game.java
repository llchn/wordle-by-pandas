package backend;

import java.awt.Color;
import java.util.Arrays;
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
    private static String correctWord = "teeth";

    // String that stores user's current guess
    private static String userGuess = "eerie";

    // String to store all possible input values
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that are correct
    private static String existingLetters = "abcdefghijklmnopqrstuvwxyz";

    // String to store remaining letters that have not been tried
    private static String lettersNotTried = "abcdefghijklmnopqrstuvwxyz";

    // boolean to switch on/off the high contrast mode
    private static boolean isContrastMode = false;

    // colors for standard mode
    public static final Color GREEN = new Color(98, 183, 61);
    public static final Color YELLOW = new Color(200, 182, 83);
    public static final Color GRAY = new Color(120, 124, 127);

    // colors for high contrast mode
    public static final Color ORANGE = new Color(255, 130, 5);
    public static final Color LIGHT_BLUE = new Color(0, 134, 255);

//    // HashMap to store letters for userGuess and corresponding color in grid
//    private static HashMap<Character, Color> gridMap = new HashMap<>(5);
//
//    // HashMap to store letters on keyboard and corresponding color
//    private static HashMap<Character, Color> keyboardMap = new HashMap<>(26);


    /**
     * Switches to a high contrast mode for accessibility
     * @param clicked 
     */
    public static void setContrastMode(boolean clicked) {
        isContrastMode = clicked;
    }
    
    /**
     * @return
     */
    public static Color getCorrectColor() { 
        if (isContrastMode) { 
            return ORANGE; 
            
        } else { 
            return GREEN;
        }
    }
    
    /**
     * @return
     */
    public static Color getPresentColor() { 
        if (isContrastMode) { 
            return LIGHT_BLUE; 
        } else { 
            return YELLOW;
        }
    }
    
    /**
     * @return
     */
    public static Color getAbsentColor() { 
        return GRAY;
    }


    /**
     * check and update colors for each guess made by user
     * 
     * @param inputGuess
     */
    public static Color[] getColorsForInput(String inputGuess,
            String targetWord) {
        Color[] rowColors = new Color[5];
        HashMap<Character, Integer> targetCount = new HashMap<>();
        // put into a hashmap to store the count of each letter in target word
        for (char c : targetWord.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        // setting color to green if there are correct matches (location +
        // presence)
        for (int i = 0; i < 5; i++) {
            char targetLetter = targetWord.charAt(i);
            char inputLetter = inputGuess.charAt(i);

            if (targetLetter == inputLetter) {
                rowColors[i] = getCorrectColor();
                targetCount.put(targetLetter,
                        targetCount.get(targetLetter) - 1);
            }
        }
        // setting color to yellow if there are presence matches
        for (int i = 0; i < 5; i++) {
            char inputLetter = inputGuess.charAt(i);
            // skip this check if the character has a color already
            if (rowColors[i] != null) {
                continue;
            }
            // check if this letter from input exists in the target word and it
            // hasnt used up yet
            if (targetCount.containsKey(inputLetter)
                    && targetCount.get(inputLetter) > 0) {
                rowColors[i] = getPresentColor();
                targetCount.put(inputLetter, targetCount.get(inputLetter) - 1);
            }
            // otherwise (the input letter neither exists in target nor at the
            // correct location), set as gray
            else {
                rowColors[i] = getAbsentColor();
            }
        }
        return rowColors;

    }

    /**
     * test game class functions
     */
    public static void main(String[] args) {
        System.out.println("hello");
        String[] resultColor = new String[5];
        Color[] colorOutput = getColorsForInput(userGuess, correctWord);
        int count = 0;
        for (Color color : colorOutput) {
            if (color.equals(GREEN)) {
                resultColor[count] = "green";
            } else if (color.equals(YELLOW)) {
                resultColor[count] = "yellow";
            } else {
                resultColor[count] = "gray";
            }
            count++;
        }
        System.out.println(Arrays.toString(resultColor));
    }
}

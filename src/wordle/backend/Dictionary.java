package backend;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Reads a file and creates a List of English Words and common words. 
 * Boolean checks which are valid user guesses and target Wordle game words.
 * Conditions for a valid user guess: 5 letters and found in the list of English words
 * Conditions for a valid target word: 5 letters and found in the list of common words
 * 
 * @author Linda Hu
 * Sources used: previous programming assignments, 
 * https://www.geeksforgeeks.org/java/generating-random-numbers-in-java
 * 
 */
public class Dictionary {
	
	//List to hold the contents of the common_words.txt file
	public static List<String> commonWords = new ArrayList<>();
	
	// List to hold the contents of the EnglishWords.txt file
	public static List<String> englishWords = new ArrayList<>();
	
	// List to hold all valid game target words in Wordle
	public static List<String> validWordleTargets = new ArrayList<>();
	
	// List to hold all valid user guesses in Wordle
	public static List<String> validWordleGuesses = new ArrayList<>();
	
	/**
	 * Reads the files, creates Lists, and checks word validity.
	 * @param args name of the files containing word data
	 * @return List of words in filename
	 */
	public static List<String> readFiles (String filename) {
		List<String> wordList = new ArrayList<>();
		
		try (Scanner in = new Scanner(new File (filename))) {
			while (in.hasNext()) {
                String currentWord = in.nextLine();
                wordList.add(currentWord);
            }
        
			in.close();
        
    		} catch (FileNotFoundException e) {
    			System.out.println ("File " + filename + 
                            " was not found.");
    		}
    
    		return wordList;
	}
	
	/**
	 * Reads files and creates valid Wordle lists of playable words and valid guesses.
	 * Checks if a randomly selected word form EnglishWords.txt is a valid user guess,
	 * and if it is a valid target word for Game to use.
	 * @param commonWordsFile, String englishWordsFile filenames to be read
	 * @return list of playable words and valid guesses.
	 */
	public static void filesSetUp (String commonWordsFile, String englishWordsFile) {
		// Reads common_words.txt file and creates list
        commonWords = readFiles(commonWordsFile);

        // Reads EnglishWords.txt file and creates List      
        englishWords = readFiles(englishWordsFile);
        validWordleGuesses = (get5LetterWords(englishWords));
        
	}
	
	/**
	 * Gets a random Wordle target word from EnglishWords.txt
	 * @return targetWord a random valid Wordle target word
	 */
	public static String getValidTarget() {
		// Check and add all valid target words from EnglishWords.txt to a new list
		for (String word : englishWords) {
			if (isValidTarget(word)) {
				validWordleTargets.add(word);
			}
		}		
        // Get a random word from the list of valid targets
        Random random = new Random();
        int rng = random.nextInt(validWordleTargets.size());
        String targetWord = validWordleTargets.get(rng);
        return targetWord;
	}
	
	/**
	 * Creates a new list of only the 5 letter words from a pre-existing list of words
	 * @param txtFileList text file to sort through
	 * @return new list of 5 letter words
	 */
	public static List<String> get5LetterWords(List<String> txtFileList) {
		List<String> fiveLetterList = new ArrayList<>();
		for (String currentWord: txtFileList) {
			if (currentWord.length() == 5) {
				fiveLetterList.add(currentWord);
			}
		}
		return fiveLetterList;
	}
	
	/**
	 * A valid guess is 5 letters, and found in the EnglishWords.txt file
	 * @param guess The user's guess to check
	 * @return true if word meets the conditions, false if not.
	 */
	public static boolean isValidGuess (String guess) {
		for (String words : validWordleGuesses) {
			if (guess.equals(words)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A valid target word is 5 letters, and found in both common_words.txt and EnglishWords.txt files
	 * @param targetWord potential Wordle guessing word to be checked
	 * @return true if word meets the conditions, false if not.
	 */
	public static boolean isValidTarget (String targetWord) {
		// isValidGuess already checks if word is a 5 letter word found in EnglishWords.txt
		if (isValidGuess(targetWord)) {
			for (String word : commonWords) {
				if (targetWord.equals(word)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
     * Test the Dictionary class
     * @param args name of the files containing word data
     */
    public static void main(String[] args) {
        String commonFile;
        if (args.length > 0) {
            commonFile = args[0];
        }
        else {
            commonFile = "common_words.txt";
        }
   
        String englishFile;
        if (args.length > 1) {
            englishFile = args[1];
        }
        else {
            englishFile = "EnglishWords.txt";
        }
        
        // test the setup method
        filesSetUp(commonFile, englishFile);
        System.out.println(getValidTarget());
        System.out.println("Dictionary successfully loaded. # of valid words " + validWordleGuesses.size());
        
        
    }
	
}
	
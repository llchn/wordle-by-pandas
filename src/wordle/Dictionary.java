package wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Dictionary Class *insert description here*
 * 
 * @author Linda Hu
 * Sources used: previous programming assignments, 
 * https://www.geeksforgeeks.org/java/generating-random-numbers-in-java,
 */
public class Dictionary {
	
	// List to hold the contents of the common_words.txt file
	static List<String> commonWords = new ArrayList<>();
	
	// List to hold the contents of the EnglishWords.txt file
	static List<String> englishWords = new ArrayList<>();
	
	// List to hold all valid game target words in Wordle
	static List<String> validWordleTarget = new ArrayList<>();
	
	// List to hold all valid user guesses in Wordle
	static List<String> validWordleGuesses = new ArrayList<>();
	
	/**
	 *  Read the words from the files and create new lists to hold each one
	 * @param args name of files containing word data
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
	 * @param args filename to be read
	 * @return List of playable words and valid guesses.
	 */
	public static void main (String[] args) {
		// Reads common_words.txt file and creates list
		String commonWordsFile;
        if (args.length == 0) {
            commonWordsFile = "common_words.txt";
        }
        else {
            commonWordsFile = args[0];
        }
        
        commonWords = readFiles(commonWordsFile);

        // Reads EnglishWords.txt file and creates List
        String englishWordsFile;
        if (args.length == 0) {
            englishWordsFile = "EnglishWords.txt";
        }
        else {
            englishWordsFile = args[0];
        }
        
        englishWords = readFiles(englishWordsFile);
        validWordleGuesses = (get5LetterWords(englishWords));
        
        // Get a random word from EnglishWords.txt
        Random random = new Random();
        int rng = random.nextInt(englishWords.size());
        String targetWord = englishWords.get(rng);
        String userGuess = targetWord;
        
        System.out.println("isValidGuess: " + userGuess + " is " + (isValidGuess(userGuess)));    
        System.out.println("isValidTarget: " + targetWord + " is " + isValidTarget(targetWord));
        
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
	
	
}
	
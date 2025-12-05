package ui; 

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import backend.Dictionary;
import backend.Game;
import javax.swing.JOptionPane; 

/**
 * Displays wordle grid of 6 guesses, keyboard, input box
 * 
 * Sources: 
 * Java Swing dialog boxes https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 * Java Swing combo boxes https://docs.oracle.com/javase/8/docs/api/javax/swing/JComboBox.html
 * 
 * Cryptography programming assignment
 * 
 * @author Lily Tran
 * 
 */
public class MainBoard extends JPanel {
    private JTextField textInputBox; 
    private WordleBoardUI grid; 
    private KeyboardUI keyboard;
    private int attemptsMade = 0; 
    private JComboBox<String> viewModeBox;
    
    /**
     * Creates the window and puts the graphics inside (wordle grid, input box)
     */
    public MainBoard(){ 
        backend.Dictionary.filesSetUp("common_words.txt", "EnglishWords.txt");
        // create the window and set the window close action
        // to also exit the program.
        JFrame f = new JFrame("Wordle by Pandas");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the panel to place the Wordle board component on
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        
        // Create panel to place keyboard component on
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setBackground(Color.WHITE);

        
        //Create the bottom panel to place the input text box
        JPanel bottomPanel = new JPanel();
        JLabel textBoxLabel = new JLabel("Your guess:");
        textInputBox = new JTextField(10);
        
        bottomPanel.add(textBoxLabel); 
        bottomPanel.add(textInputBox);
        
        JLabel comboBoxLabel = new JLabel("View mode:");
        String[] viewModeOptions = {"Default", "High contrast"};
        viewModeBox = new JComboBox<>(viewModeOptions);
        
        bottomPanel.add(comboBoxLabel); 
        bottomPanel.add(viewModeBox);
        
        String targetWord = Dictionary.getValidTarget();
        System.out.println(targetWord);
          
        //pop-up messages based on input responses 
        textInputBox.addActionListener(event-> {
            String userGuess = getUserInput().toLowerCase();
            Color[] resultColor = Game.getColorsForInput(userGuess, targetWord);
            if (getUserInput().length()<5) {
                JOptionPane.showMessageDialog(f, "Too short!");
                return; 
            }
            if (getUserInput().length()>5) {
                JOptionPane.showMessageDialog(f, "Too long!");
                return;
            }
            if (!Dictionary.validWordleGuesses.contains(getUserInput())) {
                JOptionPane.showMessageDialog(f, "Not in word list.");
                return; 
            }
            if (attemptsMade<5) {
                //update colors for the grid's relevant row
                grid.updateRowLetters(userGuess, attemptsMade);
                grid.updateRowColors(resultColor, attemptsMade);
                
                //update colors for keyboard
                for (int i=0; i<5; i++) {
                    String letterToColor = String.valueOf(userGuess.charAt(i)).toUpperCase();
                    keyboard.updateKeyColors(letterToColor, resultColor[i]);
                }

                if (userGuess.equals(targetWord)) {
                    JOptionPane.showMessageDialog(f, "You got it! Correct word: " + targetWord);
                    // no longer accept user input
                    textInputBox.setEnabled(false);
                    return;
                }
                attemptsMade++; 
                setEmptyInputBox();
            } else {
                if (!userGuess.equals(targetWord)) {
                    grid.updateRowLetters(userGuess, attemptsMade);
                    grid.updateRowColors(resultColor, attemptsMade);
                    JOptionPane.showMessageDialog(f, "Game over. Correct word: " + targetWord);
                }
                else {
                    grid.updateRowLetters(userGuess, attemptsMade);
                    grid.updateRowColors(resultColor, attemptsMade);
                    JOptionPane.showMessageDialog(f, "You got it! Correct word: " + targetWord);
                }
                // no longer accept user input
                textInputBox.setEnabled(false);
                setEmptyInputBox(); 
                
            }            
        });
        
        viewModeBox.addActionListener(event -> {
            String modeSelected = viewModeBox.getSelectedItem().toString();
            setViewMode(modeSelected);
            grid.updateRowColorMode();
        });

        
        // create the wordle board and keyboard component, place it into the panel
        grid = new WordleBoardUI();
        keyboard = new KeyboardUI();

        p.add(grid);

        // add the wordle panel to the window
        f.add(p, BorderLayout.NORTH);
        
        // create the keyboard component and place in panel
        keyboardPanel.add(keyboard);
        f.add(keyboardPanel, BorderLayout.CENTER);
        
        //add the panel with input box to the window
        f.add(bottomPanel, BorderLayout.SOUTH);
        
        // set the size of the window
        f.setSize(650,650);
        
        // prevents the user from resizing the window
        f.setResizable(false);
        
        // display the window
        f.setVisible(true);
        
    }
    
    // add comment later
    public void setViewMode(String modeName) { 
        if(modeName.equals("Default")) {
            Game.setContrastMode(false);
        }
        else if (modeName.equals("High contrast")) {
            Game.setContrastMode(true);
        }
    }
    /**
     * Gets the word that the user enters inside the box
     * 
     * @return the word that the user just entered in string type 
     */
    public String getUserInput() {
        return textInputBox.getText(); 
    }
    
    /**
     * Set the input box back to the empty state
     */
    public void setEmptyInputBox() {
        textInputBox.setText("");
    }
    
    /**
     * Runs the graphic UI of the whole game
     * @param args None
     */
    public static void main(String[] args) {
        new MainBoard();
    }
}

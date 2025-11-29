package ui; 

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Displays wordle grid of 6 guesses, keyboard, input box
 */
public class MainBoard extends JPanel {
    /**
     * Creates the window and puts the graphics inside (wordle grid, input box)
     */
    public MainBoard(){ 
        // create the window and set the window close action
        // to also exit the program.
        JFrame f = new JFrame("Wordle by Pandas");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the panel to place the Wordle board component on
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        
        //Create the bottom panel to place the input text box
        JPanel bottomPanel = new JPanel();
        JLabel textBoxLabel = new JLabel("Your guess:");
        JTextField textInputBox = new JTextField(10);
        
        bottomPanel.add(textBoxLabel); 
        bottomPanel.add(textInputBox);
        
        // create the wordle board component, place it into the panel
        WordleBoardUI cell = new WordleBoardUI();
        
        p.add(cell);

        // add the wordle panel to the window and set the size of the window
        f.add(p, BorderLayout.CENTER);
        f.setSize(650, 650);
        
        //add the panel with input box to the window
        f.add(bottomPanel, BorderLayout.SOUTH);
        
        // prevents the user from resizing the window
        f.setResizable(false);
        
        // display the window
        f.setVisible(true);

    }
    /**
     * Runs the graphic UI of the whole game
     * @param args None
     */
    public static void main(String[] args) {
        new MainBoard();
    }
}

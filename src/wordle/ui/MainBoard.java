package ui; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import example.graphics.Drawing;

public class MainBoard extends JPanel {
//    JPanel bottomPanel;
//    JTextField textInputBox; 
//    JLabel textBoxLabel; 
    public MainBoard(){ 
        // Create the window and set the window close action
        // to also exit the program.
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the panel to place the Wordle Board component on
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

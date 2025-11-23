package example.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demo for a simple graphics example.  It creates the JFrame
 * and then places the graphic component in the frame.
 */
public class Main {
    /**
     * Creates the window and puts the graphic drawing inside
     */
    public Main() {
        // Create the window and set the window close action
        // to also exit the program.
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the panel to place the drawing component on
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        
        // Create the drawing component, set its size and place
        // it in the panel.
        Drawing drawing = new Drawing();
        drawing.setPreferredSize(new Dimension(400, 400));
        p.add(drawing);

        // Add the panel to the window and set the size of the window
        f.add(p, BorderLayout.CENTER);
        f.setSize(400, 400);
        
        // This prevents the user from resizing the window
        f.setResizable(false);
        
        // Display the window
        f.setVisible(true);
    }


    /**
     * Runs the graphic example
     * @param args None
     */
    public static void main(String[] args) {
        new Main();
    }

}

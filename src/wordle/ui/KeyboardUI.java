package ui;

import javax.swing.JComponent;

public class KeyboardUI extends JComponent {

	// Keyboard key order from top left -> bottom right
	private static final String keys_top = "QWERTYUIOP";
	private static final String keys_middle = "ASDFGHJKL";
	// "<" is a temporary placeholder for the enter key
	// ">" is temporary placeholder for delete key
	private static final String keys_bottom = "<ZXCVBNM>";

	// Keyboard cell size measured in pixels
    private static final int CELL_LEFT = 25;
    private static final int CELL_TOP = 50;
    private static final int CELL_SIZE = 50;
    private static final int CELL_GAP = 10;
    private static final int ROWS = 3; 
    private static final int COLS = 9; // change later for 1st row being 10
    
    // Keyboard grid size measured in pixels
    private static final int GRID_WIDTH = (COLS * CELL_SIZE) + ((COLS - 1) * CELL_GAP);
    private static final int GRID_HEIGHT = (ROWS * CELL_SIZE) + ((ROWS - 1) * CELL_GAP);
    
}

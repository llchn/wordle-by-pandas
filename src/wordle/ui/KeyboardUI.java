package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author Linda Hu
 * 
 * Sources used: 
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html#drawString-java.lang.String-int-int-
 * 
 * 
 */
public class KeyboardUI extends JPanel {

	// Keyboard key order from top left -> bottom right
	private static final String [][] KEYS = 
		{{"Q","W","E","R","T","Y","U","I","O","P"},
		{"A","S","D","F","G","H","J","K","L"},
		{"ENTER","Z","X","C","V","B","N","M","DELETE"}};

    private static final int ROWS = 3; 
    // Temporary Col Value
    private static int COLS = 10; 

    // Keyboard cell sizes
    private static int CELL_WIDTH = 40;
    private static final int CELL_HEIGHT = 40;
    private static final int CELL_GAP = 2;
    
    int 	KEYBOARD_WIDTH = COLS * (CELL_WIDTH + CELL_GAP) + CELL_GAP;
	int KEYBOARD_HEIGHT = ROWS * (CELL_HEIGHT + CELL_GAP) + CELL_GAP;
    
    // Gray color specified in RGB
    private static final Color lightGray = new Color(120,124,127);
    private String[][] cellKeys;
    private Color[][] cellColors;
    
    	/**
    	 * Constructor
    	 */
    	public KeyboardUI() {
    	    // data info of what's inside each box (letter, specific colors)
    	    cellKeys = new String[ROWS][];
    	    cellColors = new Color[ROWS][];
    	    
    	    for (int r = 0; r < ROWS; r++) {
    	        // Creates a new row of keys
    	        COLS = KEYS[r].length;
    	        
    	        cellKeys[r] = new String[COLS];
    	        cellColors[r] = new Color[COLS];
    	        
    	        for (int c = 0; c < COLS; c++) {
    	            cellKeys[r][c] = KEYS[r][c]; 
    	            cellColors[r][c] = lightGray;  
    	        }
    	    }

    	    setPreferredSize(new Dimension(KEYBOARD_WIDTH, KEYBOARD_HEIGHT));
    	}
    
    /**
     * Draws the keyboard in with color
     * @param g the graphics to draw on
     */
    public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		
    		g.setFont(new Font("Helvetica", Font.BOLD, 15));

    	    for (int r = 0; r < ROWS; r++) {
    	        int columns = KEYS[r].length;
    	        for (int c = 0; c < columns; c++) {
    	            int cellLeft = CELL_GAP + c * (CELL_WIDTH + CELL_GAP);
    	            int cellTop = CELL_GAP + r * (CELL_HEIGHT + CELL_GAP);

    	            g.setColor(cellColors[r][c]);
    	            g.fillRect(cellLeft, cellTop, CELL_WIDTH, CELL_HEIGHT);

    	            g.setColor(Color.BLACK);
    	            g.drawRect(cellLeft, cellTop, CELL_WIDTH, CELL_HEIGHT);

    	            String currentKey = cellKeys[r][c];

    	            int midWidth = cellLeft + CELL_WIDTH / 2;
    	            int midHeight = cellTop + CELL_HEIGHT / 2;

    	            g.drawString(currentKey, midWidth, midHeight);
    	        }
    	    }
    	}
   
}

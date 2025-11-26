package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

public class WordleBoardUI extends JComponent { 
    // size information used in drawing the wordle board, in pixels
    private static final int CELL_LEFT = 25; //int x 
    private static final int CELL_TOP = 50; // int y
    private static final int CELL_SIZE = 50;
    private static final int CELL_GAP = 10;
    private static final int ROWS = 6; 
    private static final int COLS = 5;
    
    private static final int GRID_WIDTH = (COLS * CELL_SIZE) + ((COLS - 1) * CELL_GAP);
    private static final int GRID_HEIGHT = (ROWS * CELL_SIZE) + ((ROWS - 1) * CELL_GAP);
    
    private static final int COMPONENT_WIDTH = CELL_LEFT * 2 + GRID_WIDTH;
    private static final int COMPONENT_HEIGHT = CELL_TOP * 2 + GRID_HEIGHT;
    
    // start points for drawing boxes
    private static final int START_LEFT = (COMPONENT_WIDTH - GRID_WIDTH)/2;
    private static final int START_TOP = (COMPONENT_HEIGHT - GRID_HEIGHT)/2;  
    
    // where to store data
    private char[][] cellLetters;
    private Color[][] cellColors;
    
    public WordleBoardUI() {
        // data info of what's inside each box (letter, specific colors)
        cellLetters = new char[ROWS][COLS];
        cellColors = new Color[ROWS][COLS];
        
        //default data 
        for (int r = 0; r < ROWS; r++) { 
            for (int c = 0; c < COLS; c++) {
                cellLetters[r][c] = ' '; 
                cellColors[r][c] = Color.white;  
            }
        }
        this.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));          
    }
    
    // default cell color
    private static final Color CELL_COLOR = new Color(221, 240, 240);
    
    /**
     * Draws 30 cells of the grid
     * @param g the graphics object to draw on
     */
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        //repeatedly creating cells by using offset
        for (int r=0; r<ROWS;r++) {
            for (int c=0; c<COLS; c++) {
                int leftMargin = START_LEFT + (c * (CELL_SIZE + CELL_GAP));
                int topMargin = START_TOP + (r * (CELL_SIZE + CELL_GAP));
                g.setColor(CELL_COLOR);
                g.fillRect(leftMargin, topMargin, CELL_SIZE, CELL_SIZE);
            }
        }     
    } 
}

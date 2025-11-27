package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

/**
 * !!!insert some description later
 * 
 * @author Lily Tran 
 * 
 * Sources used: 
 * Java8 Oracle docs relating to Swing Graphics
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 * https://docs.oracle.com/javase/tutorial/2d/text/measuringtext.html
 * 
 * Computer graphics facts relating to x-y coordinates https://math.hws.edu/eck/cs124/
 * javanotes5/c6/s3.html#:~:text=A%20graphics%20context%20draws%20in,the%20grid%20lines
 * %20between%20them.)
 */

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
        // dummy test to see how letters will appear, *delete later
        cellLetters[0][0] = 'D'; 
        cellLetters[0][1] = 'O'; 
        cellLetters[0][2] = 'N'; 
        cellLetters[0][3] = 'U'; 
        cellLetters[0][4] = 'T'; 
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
                
                //drawing the box first to avoid contradicting colors (cell's vs letter's colors)
                g.setColor(CELL_COLOR);
                g.fillRect(leftMargin, topMargin, CELL_SIZE, CELL_SIZE);
                if (cellLetters[r][c]!=' ') {
                    
                    g.setFont(new Font("Helvetica", Font.BOLD, 15));   
                    g.setColor(Color.black);
                    
                    FontMetrics metrics = g.getFontMetrics(); 
                    int letterWdth = metrics.stringWidth(String.valueOf(cellLetters[r][c]));
                    int letterHgt = metrics.getHeight(); 
                    int widthOffset = (CELL_SIZE - letterWdth)/2;
                    int hgtOffset = (CELL_SIZE-letterHgt)/2 + letterHgt; 
                    g.drawString(String.valueOf(cellLetters[r][c]), leftMargin + widthOffset, topMargin+hgtOffset); 
                }               
            }
        }     
    } 
}

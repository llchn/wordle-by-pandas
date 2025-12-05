package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

import backend.Game;

/**
 * 
 * @author Linda Hu
 * 
 *         Sources used: Example graphics code provided,
 *         https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html#drawString-java.lang.String-int-int-,
 * 
 * 
 */
public class KeyboardUI extends JPanel {

    // Keyboard key order from top left -> bottom right
    private static final String[][] KEYS = {
            { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" },
            { "A", "S", "D", "F", "G", "H", "J", "K", "L" },
            { "ENTER", "Z", "X", "C", "V", "B", "N", "M", "DELETE" } };

    private static final int ROWS = 3;
    // Maximum Col Value
    private static int COLS = 10;

    // Keyboard cell sizes
    private static final int CELL_WIDTH = 45;
    private static final int CELL_HEIGHT = 45;
    private static final int CELL_GAP = 2;

    int KEYBOARD_WIDTH = COLS * (CELL_WIDTH + CELL_GAP) + CELL_GAP;
    int KEYBOARD_HEIGHT = ROWS * (CELL_HEIGHT + CELL_GAP) + CELL_GAP;

    // Gray color specified in RGB
    private static final Color lightGray = new Color(120, 124, 127);
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
                cellColors[r][c] = Color.WHITE;
            }
        }

        setPreferredSize(new Dimension(KEYBOARD_WIDTH, KEYBOARD_HEIGHT));
    }

    /**
     * Draws the keyboard in with color
     * 
     * @param g the graphics to draw on
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Helvetica", Font.BOLD, 15));

        for (int r = 0; r < ROWS; r++) {
            int columns = KEYS[r].length;

            // Creates pointers to a cell's top left corner
            int cellLeft = CELL_GAP;
            int cellTop = CELL_GAP + r * (CELL_HEIGHT + CELL_GAP);
            int currentCellWidth;

            for (int c = 0; c < columns; c++) {
                String currentKey = cellKeys[r][c];

                // Adjust position for the 2nd row of keys
                if (currentKey.equals("A")) {
                    cellLeft += 20;
                }
                // Create larger key cells for "ENTER" & "DELETE"
                if (currentKey.equals("ENTER") || currentKey.equals("DELETE")) {
                    currentCellWidth = 69;
                } else {
                    currentCellWidth = 45;
                }

                // Fill colors
                g.setColor(lightGray);
                g.fillRect(cellLeft, cellTop, currentCellWidth, CELL_HEIGHT);

                g.setColor(Color.BLACK);
                g.drawRect(cellLeft, cellTop, currentCellWidth, CELL_HEIGHT);

                // get specifics metrics of each cell to scale exactly to the
                // middle of box
                FontMetrics metrics = g.getFontMetrics();
                int letterWidth = metrics.stringWidth(currentKey);
                int letterHeight = metrics.getHeight();
                // Draw character in the middle of the cell
                int midWidth = cellLeft + (currentCellWidth - letterWidth) / 2;
                int midHeight = cellTop + (CELL_HEIGHT - letterHeight);
                g.drawString(currentKey, midWidth, midHeight);

                // Update pointer to next cells' top left corner
                cellLeft += currentCellWidth + CELL_GAP;
            }
        }
    }
    /**
     * tell Java to paint new rows with updated color data
     * @param colors the color data array we get after correctness check
     * @param row
     */
    public void updateRowColors(Color[] colors, int row) { 
        for (int i =0; i< COLS; i++) { 
            cellColors[row][i] = colors[i];
        }
        repaint();
    }
    /**
     * tell Java to paint the existing rows in the given color mode
     */
    public void updateKeyColorMode() { 
        for (int r = 0; r<ROWS; r ++) {
            for (int c =0; c<COLS; c++) {
                Color currColorStatus = cellColors[r][c];    
                if (currColorStatus.equals(Game.GREEN)) {
                    cellColors[r][c] = Game.ORANGE;
                }
                else if (currColorStatus.equals(Game.YELLOW)){
                    cellColors[r][c] = Game.LIGHT_BLUE;
                }                
                else if (currColorStatus.equals(Game.LIGHT_BLUE)){
                    cellColors[r][c] = Game.YELLOW;
                }
                else if (currColorStatus.equals(Game.ORANGE)) {
                    cellColors[r][c] = Game.GREEN;
                }
            }
        }
        repaint();
    }

}

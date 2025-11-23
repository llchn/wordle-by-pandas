package example.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

/**
 * Example code for drawing custom user interface components.  This example
 * draws a simple house.  It shows how to define your own size, location and color
 * for a component. 
 */
public class Drawing extends JComponent {
    // Location information.  This is measured in pixels from the top left 
    // corner of the component.  Together these will be used to define the
    // location of the top left corner of the wall of the house. 
    private static final int WALL_TOP = 200;
    private static final int WALL_LEFT = 150;
    
    // Size information used in the drawing.  Measured in pixels.
    private static final int WALL_HEIGHT = 100;
    private static final int WALL_WIDTH = 100;
    
    // Color specified in RGB.  Indivdual numbers range from 0 to 255.
    // Lower values are darker, higher values are lighter.  Use a color
    // chooser tool to find out an RGB value to use.
    private static final Color WALL_COLOR = new Color(210, 226, 204);
    
    // Defining the peak of the roof relative to the top of the wall
    private static final int ROOF_TOP = WALL_TOP - 50;
    
    // Defining the horizontal location of the peak as the midway
    // point of the wall of the house.
    private static final int ROOF_MIDDLE = WALL_LEFT + WALL_WIDTH / 2;
    
    /**
     * Draws a simple house
     * @param g the graphics object to draw on
     */
    public void paintComponent (Graphics g) {
        // This should always be called.
        super.paintComponent(g);
        
        // Draw the wall of the house
        g.setColor(WALL_COLOR);
        g.fillRect(WALL_LEFT, WALL_TOP, WALL_WIDTH, WALL_HEIGHT);
        
        // Draw the roof of the house.
        Polygon p = new Polygon();
        p.addPoint(WALL_LEFT, WALL_TOP);
        p.addPoint(WALL_LEFT + WALL_WIDTH, WALL_TOP);
        p.addPoint(ROOF_MIDDLE, ROOF_TOP);
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(p);    

    }
}

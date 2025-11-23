package example.animation;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import animation.AbstractAnimation;
import animation.AnimatedObject;

/**
 * This class provides a simple demonstration of how you would implement an 
 * animation (or game!) that contains multiple animated objects.
 *
 */
public class AnimationDemo extends AbstractAnimation {
    // The width of the window, in pixels.
    private static final int WINDOW_WIDTH = 600;
    
    // The height of the window, in pixels.
    private static final int WINDOW_HEIGHT = 600;
    
    // The object that moves during the animation.  You might have
    // many objects!
    private AnimatedObject shape = new AnimatedObjectDemo(this);

    @Override
    /**
     * Updates the animated object for the next frame of the animation
     * and repaints the window.
     */
    protected void nextFrame() {
        shape.nextFrame();
        repaint();
    }

    /**
     * Paint the animation by painting the objects in the animation.
     * @param g the graphic context to draw on
     */
    public void paintComponent(Graphics g) {
        // Note that your code should not call paintComponent directly.
        // Instead your code calls repaint (as shown in the nextFrame
        // method above, and repaint will call paintComponent.
        
        super.paintComponent(g);
        shape.paint(g);
    }

    /**
     * The main method creates a window for the animation to run in,
     * initializes the animation and starts it running.
     * @param args none
     */
    public static void main(String[] args) {
        // JFrame is the class for a window.  Create the window,
        // set the window's title and its size.
        JFrame f = new JFrame();
        f.setTitle("Animation Demo");
        f.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        // This says that when the user closes the window, the
        // entire program should exit.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the animation.
        AnimationDemo demo = new AnimationDemo();

        // Add the animation to the window
        Container contentPane = f.getContentPane();
        contentPane.add(demo, BorderLayout.CENTER);

        // Display the window.
        f.setVisible(true);

        // Start the animation
        demo.start();
    }

}

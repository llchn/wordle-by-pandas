package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import backend.*;

class GameTest {
    // colors for default mode
    public static final Color GREEN = new Color(98, 183, 61);
    public static final Color YELLOW = new Color(200, 182, 83);
    public static final Color GRAY = new Color(120, 124, 127);

    // colors for high contrast mode
    public static final Color ORANGE = new Color(255, 130, 5);
    public static final Color LIGHT_BLUE = new Color(0, 134, 255);

    @Test
    void contrastButtonClicked() {
        Game.setContrastMode(true);
        Color[] colorOutput = Game.getColorsForInput("hooks", "shook");
        assertEquals(colorOutput[0], LIGHT_BLUE);
        assertEquals(colorOutput[1], LIGHT_BLUE);
        assertEquals(colorOutput[2], ORANGE);
        assertEquals(colorOutput[3], LIGHT_BLUE);
        assertEquals(colorOutput[4], LIGHT_BLUE);
    }

    @Test
    void allLettersIncorrect() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("soars", "teeth");
        for (Color color : colorOutput) {
            assertEquals(color, GRAY);
        }
    }

    @Test
    void mixYellowAndGray() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("audio", "hoped");
        assertEquals(colorOutput[0], GRAY);
        assertEquals(colorOutput[1], GRAY);
        assertEquals(colorOutput[2], YELLOW);
        assertEquals(colorOutput[3], GRAY);
        assertEquals(colorOutput[4], YELLOW);
    }

    @Test
    void mixGreenAndGray() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("sling", "skirt");
        assertEquals(colorOutput[0], GREEN);
        assertEquals(colorOutput[1], GRAY);
        assertEquals(colorOutput[2], GREEN);
        assertEquals(colorOutput[3], GRAY);
        assertEquals(colorOutput[4], GRAY);
    }

    @Test
    void mixGreenAndYellow() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("hooks", "shook");
        assertEquals(colorOutput[0], YELLOW);
        assertEquals(colorOutput[1], YELLOW);
        assertEquals(colorOutput[2], GREEN);
        assertEquals(colorOutput[3], YELLOW);
        assertEquals(colorOutput[4], YELLOW);
    }

    @Test
    void mixAllColors() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("steel", "trees");
        assertEquals(colorOutput[0], YELLOW);
        assertEquals(colorOutput[1], YELLOW);
        assertEquals(colorOutput[2], GREEN);
        assertEquals(colorOutput[3], GREEN);
        assertEquals(colorOutput[4], GRAY);
    }

    @Test
    void allLettersCorrect() {
        Game.setContrastMode(false);
        Color[] colorOutput = Game.getColorsForInput("teeth", "teeth");
        for (Color color : colorOutput) {
            assertEquals(color, GREEN);
        }
    }
    
    

}

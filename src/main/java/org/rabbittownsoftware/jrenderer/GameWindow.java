package main.java.org.rabbittownsoftware.jrenderer;

import javax.swing.JFrame;

/**
 * GameWindow creates a simple Swing window with a GameCanvas attached.
 */
@SuppressWarnings("unused")
public class GameWindow
{
    /**
     * Creates and returns a new game window.
     *
     * @param title   Window title.
     * @param width   Window width in pixels.
     * @param height  Window height in pixels.
     * @param canvas  The GameCanvas to attach.
     * @return The configured JFrame.
     */
    public static JFrame create(String title, int width, int height, GameCanvas canvas)
    {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(canvas);

        return frame;
    }
}

package main.java.org.rabbittownsoftware.jrenderer;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * GameCanvas is a JPanel that uses a Renderer to draw content.
 *
 * It does not own a game loop — you call repaint() externally
 * (or hook it into a loop) to refresh.
 */
@SuppressWarnings("unused")
public class GameCanvas extends JPanel
{
    private final Renderer renderer;
    private double cameraX = 0;
    private double cameraY = 0;

    /**
     * Creates a new GameCanvas.
     *
     * @param renderer The Renderer to use for drawing.
     */
    public GameCanvas(Renderer renderer)
    {
        this.renderer = renderer;

        setOpaque(true);
        setBackground(Color.BLACK);

        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * Sets the camera offset for rendering.
     *
     * @param x World X offset.
     * @param y World Y offset.
     */
    public void setCamera(double x, double y)
    {
        this.cameraX = x;
        this.cameraY = y;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (g instanceof Graphics2D g2d)
        {
            renderer.render(g2d, cameraX, cameraY);
        }
    }
}

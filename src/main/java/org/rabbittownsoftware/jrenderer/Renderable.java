package main.java.org.rabbittownsoftware.jrenderer;

import java.awt.Graphics2D;

/**
 * Something that can be drawn by the Renderer.
 *
 * A Renderable provides its world-space coordinates and
 * knows how to draw itself given a Graphics2D context.
 */
@SuppressWarnings("unused")
public interface Renderable
{
    /**
     * @return World X coordinate of this object.
     */
    double getX();

    /**
     * @return World Y coordinate of this object.
     */
    double getY();

    /**
     * Draw this object at a pixel position on screen.
     *
     * @param g             The Graphics2D context.
     * @param screenX       Pixel X position on screen (already camera-adjusted).
     * @param screenY       Pixel Y position on screen (already camera-adjusted).
     * @param pixelsPerUnit How many pixels represent one world unit.
     */
    void draw(Graphics2D g, int screenX, int screenY, int pixelsPerUnit);
}

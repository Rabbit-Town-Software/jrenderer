package main.java.org.rabbittownsoftware.jrenderer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import java.awt.Graphics2D;

/**
 * Renderer draws Renderable objects onto a Graphics2D surface.
 *
 * <p>
 * It does not enforce any specific camera system.
 * Callers provide a camera/world offset when calling render().
 * </p>
 */
@SuppressWarnings("unused")
public class Renderer
{
    private final List<Renderable> renderables = new ArrayList<>();
    private final int pixelsPerUnit;

    /**
     * Creates a new Renderer.
     *
     * @param pixelsPerUnit How many pixels = 1 world unit. Must be > 0.
     */
    public Renderer(int pixelsPerUnit)
    {
        if (pixelsPerUnit <= 0)
            throw new IllegalArgumentException("pixelsPerUnit must be > 0.");
        this.pixelsPerUnit = pixelsPerUnit;
    }

    /**
     * Adds a Renderable to be drawn every frame.
     *
     * @param renderable The object to add.
     */
    public void addRenderable(Renderable renderable)
    {
        renderables.add(renderable);
    }

    /**
     * Clears all Renderables.
     */
    public void clear()
    {
        renderables.clear();
    }

    /**
     * Renders all Renderables with the given camera offset.
     *
     * @param g        Graphics2D context.
     * @param cameraX  World X offset (camera position).
     * @param cameraY  World Y offset (camera position).
     */
    public void render(Graphics2D g, double cameraX, double cameraY)
    {
        // Reset transforms so we draw cleanly
        g.setTransform(new AffineTransform());

        for (Renderable obj : renderables)
        {
            int px = Math.round((float)((obj.getX() - cameraX) * pixelsPerUnit));
            int py = Math.round((float)((obj.getY() - cameraY) * pixelsPerUnit));

            obj.draw(g, px, py, pixelsPerUnit);
        }
    }
}

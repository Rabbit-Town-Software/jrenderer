# JRenderer

JRenderer is a **lightweight 2D rendering library for Java (Swing/AWT)**.  
It provides a simple abstraction for drawing "renderable" objects with world coordinates, camera offsets, and pixels-per-unit scaling.

---

## Features
- Minimal and flexible 2D rendering API.
- Renderable interface for custom objects.
- Camera offset support for world-to-screen translation.
- Adjustable pixels-per-unit scaling.
- Plug-and-play with Swing (`GameCanvas` + `GameWindow` provided).

---

## Installation

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/jrenderer/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/jrenderer-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=jrenderer-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=jrenderer   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `jrenderer-1.0.0-sources.jar` and `jrenderer-1.0.0-javadoc.jar` for inline docs in your IDE.

---

## Quick Example

```java
public class Main
{
    public static void main(String[] args)
    {
        Renderer renderer = new Renderer(32); // 32px per unit
        GameCanvas canvas = new GameCanvas(renderer);

        JFrame window = GameWindow.create("JRenderer Demo", 800, 600, canvas);
        window.setVisible(true);

        // Add a simple square renderable
        renderer.addRenderable(new Renderable() 
        {
            @Override
            public double getX() { return 5; }
            @Override
            public double getY() { return 5; }
            @Override
            public void draw(Graphics2D g, int x, int y, int ppu)
            {
                g.fillRect(x, y, ppu, ppu);
            }
        });

        // Run a repaint loop (~60fps)
        new javax.swing.Timer(16, e -> canvas.repaint()).start();
    }
}
```

---

## License

JRenderer is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/jrenderer/issues/new)

---


## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>

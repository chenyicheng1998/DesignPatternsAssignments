package graphics;

import javafx.scene.canvas.GraphicsContext;

public interface TileGraphic {
    void render(GraphicsContext gc, double x, double y, double size);
}


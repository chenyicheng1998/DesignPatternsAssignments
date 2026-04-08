package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ColorTileGraphic implements TileGraphic {
    private final Color fillColor;
    private final Color borderColor;

    public ColorTileGraphic(Color fillColor, Color borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public void render(GraphicsContext gc, double x, double y, double size) {
        gc.setFill(fillColor);
        gc.fillRect(x, y, size, size);
        gc.setStroke(borderColor);
        gc.strokeRect(x, y, size, size);
    }
}


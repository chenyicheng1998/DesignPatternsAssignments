package graphics;

import javafx.scene.paint.Color;
import tiles.TileType;

import java.util.EnumMap;
import java.util.Map;

public class TileGraphicFactory {
    private final Map<TileType, TileGraphic> cache = new EnumMap<>(TileType.class);

    public TileGraphic getGraphic(TileType tileType) {
        TileGraphic graphic = cache.get(tileType);
        if (graphic == null) {
            graphic = createGraphic(tileType);
            cache.put(tileType, graphic);
        }
        return graphic;
    }

    private TileGraphic createGraphic(TileType tileType) {
        return switch (tileType) {
            case ROAD -> new ColorTileGraphic(Color.LIGHTGRAY, Color.DIMGRAY);
            case FOREST -> new ColorTileGraphic(Color.FORESTGREEN, Color.DARKGREEN);
            case WATER -> new ColorTileGraphic(Color.DODGERBLUE, Color.DARKBLUE);
            case SWAMP -> new ColorTileGraphic(Color.DARKOLIVEGREEN, Color.OLIVE);
            case BUILDING -> new ColorTileGraphic(Color.SANDYBROWN, Color.SADDLEBROWN);
        };
    }

    public int getSharedGraphicCount() {
        return cache.size();
    }
}


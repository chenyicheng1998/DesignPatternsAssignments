# Assignment 17 - Flyweight Rendering for RPG

This project renders a random RPG tile map in JavaFX and applies the Flyweight pattern to share tile graphics.

## Relation to Assignment 1 (Factory Method)

This implementation reuses the same creator/product idea from `Assignment1`:

- Abstract map class (`maps.Map`) defines the factory method `createTile()` and generation loop.
- Concrete creators:
  - `maps.CityMap` creates random `RoadTile`, `ForestTile`, `BuildingTile`.
  - `maps.WildernessMap` creates random `SwampTile`, `WaterTile`, `ForestTile`.

So the map generation logic follows Assignment1 style, and Assignment17 extends it with graphical rendering.

## What is implemented

- **Factory Method map generation**
  - `maps.Map` is the abstract creator.
  - `maps.CityMap` and `maps.WildernessMap` override `createTile()`.
- **Flyweight rendering**
  - `graphics.TileGraphic` is the flyweight interface.
  - `graphics.ColorTileGraphic` is the concrete flyweight (intrinsic state: colors/style).
  - `graphics.TileGraphicFactory` caches one graphic per `TileType` and reuses it across the whole map.
- **JavaFX game view**
  - `game.Game` creates a map first, then renders it on a JavaFX `Canvas` using shared flyweights.

## Intrinsic vs extrinsic state

- **Intrinsic (shared):** tile visual style (`TileGraphic` instances in `TileGraphicFactory`).
- **Extrinsic (per draw call):** row/column position and pixel coordinates used while drawing each tile.

## Run

From project root:

```powershell
mvn -pl Assignment17 -am compile
mvn -pl Assignment17 javafx:run
```

When the app starts, it prints the generated map type and number of shared tile graphics.

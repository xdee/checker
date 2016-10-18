package com.roz;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public enum TileType {
        ILLEGAL, BLANK
    }

    private TileType tileType;

    public TileType getTileType() {
        return tileType;
    }

    private Piece piece;

    public boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile(TileType tileType, int x, int y) {
        this.tileType = tileType;
        setWidth(Checker.TILE_SIZE);
        setHeight(Checker.TILE_SIZE);

        relocate(x * Checker.TILE_SIZE, y * Checker.TILE_SIZE);

        setFill(tileType == TileType.BLANK ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }

    public void selectTile() {
        setFill(Color.BLUE);
    }
}

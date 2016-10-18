package com.roz;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public enum TileType {
        ILLEGAL, BLANK
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
        setWidth(Checker.TILE_SIZE);
        setHeight(Checker.TILE_SIZE);

        relocate(x * Checker.TILE_SIZE, y * Checker.TILE_SIZE);

        setFill(tileType == TileType.BLANK ? Color.valueOf("#feb") : Color.valueOf("#582"));

        setOnMousePressed(e -> {
//            if (hasPiece())
            System.out.println("Hello");
        });

        if (getPiece() != null) {
            piece.setFocusTraversable(true);
            piece.setOnMousePressed(e -> {
                System.out.println("yes");
            });
        }
    }
}

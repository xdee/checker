package com.roz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Checker extends Application {

    public static final int TILE_SIZE = 80;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    Board board;

    int oldX, oldY;


    private boolean isSelected = false;

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        board = new Board();
        board.createBoard();

        for (int i = 0; i < board.board[0].length; i++) {
            for (int j = 0; j < board.board[1].length; j++) {
                Piece piece = null;
                Tile tile = null;
                switch (board.board[i][j]) {
                    case RED:
                        tile = new Tile(Tile.TileType.BLANK, i, j);
                        piece = makePiece(PieceType.RED, i, j);
                        break;
                    case WHITE:
                        tile = new Tile(Tile.TileType.BLANK, i, j);
                        piece = makePiece(PieceType.WHITE, i, j);
                        break;
                    case ILLEGAL:
                        tile = new Tile(Tile.TileType.ILLEGAL, i, j);
                        break;
                    case BLANK:
                        tile = new Tile(Tile.TileType.BLANK, i, j);
                        break;
                }
                if (tile != null)
                    tileGroup.getChildren().add(tile);

                final int x = i;
                final int y = j;
                if (tile.getTileType() != Tile.TileType.ILLEGAL) {
                    tile.setOnMousePressed(e -> {
                        mousePressed(x, y);
                    });
                }

                if (piece != null) {
                        tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);

                    piece.setOnMousePressed(e -> {
                        mousePressed(x, y);
                    });

                }
            }
        }

        return root;
    }

    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);
        piece.setOnMouseReleased(e -> {

        });
        return piece;
    }

    private void mousePressed(int x, int y) {

        Tile tile = (Tile) tileGroup.getChildren().get(x * WIDTH + y);

        if (tile.hasPiece()) {
            isSelected = true;

            tile.selectTile();

            oldX = x;
            oldY = y;
        } else {
            if (isSelected) {
                board.move(oldX, oldY, x, y);

            }
        }

    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

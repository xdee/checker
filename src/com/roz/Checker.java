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

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        Board board = new Board();
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

                if (piece != null) {
                    if (tile != null)
                        tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);

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

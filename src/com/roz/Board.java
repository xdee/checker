package com.roz;

public class Board {

    public BoardType[][] board = new BoardType[Checker.WIDTH][Checker.HEIGHT];

    public void createBoard() {
        //mark illegal spots
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {

                if ((i + j) % 2== 0)
                    board[i][j] = BoardType.ILLEGAL;
                else
                    board[i][j] = BoardType.BLANK;
            }
        }

        // mark red
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < 3; j++) {

                if ((i + j) % 2 != 0)
                    board[i][j] = BoardType.RED;
            }
        }

        // mark white
        for (int i = 0; i < board[0].length; i++) {
            for (int j = board[1].length - 3; j < board[1].length; j++) {

                if ((i + j) % 2 != 0)
                    board[i][j] = BoardType.WHITE;
            }
        }
    }

    public void move(int oldX, int oldY, int newX, int newY) {
        BoardType boardType = board[oldX][oldY];
        board[newX][newY] = boardType;
        board[oldX][oldY] = BoardType.BLANK;
    }

}

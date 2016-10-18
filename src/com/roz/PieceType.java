package com.roz;

/**
 * Created by Xdee on 10/17/2016.
 */
public enum PieceType {
    RED(1), WHITE(-1);

    final int moveDir;

    //
    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
}

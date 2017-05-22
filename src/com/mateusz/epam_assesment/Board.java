package com.mateusz.epam_assesment;

import lombok.Data;

/**
 * Created by Mateusz on 22.05.2017.
 */
@Data
public class Board {

    private String[][] board;
    private int size;

    public void initializeBoard(int size) {
        board = new String[size][size];
        this.size = size;
        clearBoard();
    }

    public void drawBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println("");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");;
            }
        }
    }

    private void clearBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ApiConstants.NOTHING;
            }
        }
    }
}

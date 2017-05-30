package com.mateusz.epam_assesment;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Mateusz on 22.05.2017.
 */

public enum Board {
Instance;

    @Getter
    @Setter
    private String[][] board;

    @Getter
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

    public String[][] getBoard() {
        return board;
    }

    private void clearBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ApiConstants.NOTHING;
            }
        }
    }
}

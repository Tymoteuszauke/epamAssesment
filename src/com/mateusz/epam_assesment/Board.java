package com.mateusz.epam_assesment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 22.05.2017.
 */
public class Board {

    String[][] board;

    public void initializeBoard(int boardCapacity) {
        board = new String[boardCapacity][boardCapacity];
    }
}

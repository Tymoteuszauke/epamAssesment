package com.mateusz.epam_assesment;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Game game = new Game();

//        while(true) {
//            game.start();
//        }

        Board board = new Board();
        board.initializeBoard(3);
        board.drawBoard();

    }
}

package com.mateusz.epam_assesment;

import com.mateusz.epam_assesment.player.Player;
import com.mateusz.epam_assesment.player.PlayerImp;

import java.util.Scanner;

/**
 * Created by Mateusz on 22.05.2017.
 */
public class Game {

    private Player playerCross;
    private Player playerCircle;
    private Board board;
    private boolean isRunning;

    Scanner scanner = new Scanner(System.in);

    Game() {
        playerCircle = new PlayerImp();
        playerCircle.setSign(ApiConstants.CIRLCE);
        playerCross = new PlayerImp();
        playerCross.setSign(ApiConstants.CROSS);

        board = new Board();
        board.initializeBoard(3);

    }

    public void start() {

        isRunning = true;


        while (isRunning) {

            drawOnBoard(playerCross);
            board.drawBoard();
            checkForWinner();
            drawOnBoard(playerCircle);


        }
    }

    public void drawOnBoard(Player player) {

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        board.getBoard()[x][y] = player.drawSign();

    }

    public void checkForWinner() {

    }
}

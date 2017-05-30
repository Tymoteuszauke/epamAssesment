package com.mateusz.epam_assesment;

import com.mateusz.epam_assesment.exception.AlreadyTakenPositionException;
import com.mateusz.epam_assesment.player.Player;
import com.mateusz.epam_assesment.player.PlayerImp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.mateusz.epam_assesment.utils.CommonUtils.printLine;


/**
 * Created by Mateusz on 22.05.2017.
 */
public class Game {

    private Player playerCross;
    private Player playerCircle;
    private Board board;
    private int boardSize;

    private List<Player> players;

    private Scanner scanner = new Scanner(System.in);

    Game() {
        this(3);
    }

    public Game(int boardSize) {
        players = new ArrayList<>();

        playerCircle = new PlayerImp();
        playerCircle.setSign(ApiConstants.CIRLCE);
        playerCross = new PlayerImp();
        playerCross.setSign(ApiConstants.CROSS);
        playerCross.setTurnLock(true);
        players.add(playerCircle);
        players.add(playerCross);
        this.boardSize = boardSize;
    }

    public void start() {

        Board.Instance.initializeBoard(boardSize);
        board = Board.Instance;

        boolean isRunning = true;

        printLine("Player X starts");

        while (isRunning) {

            Player currentPlayer = players
                    .stream()
                    .filter(Player::hasTurnLock)
                    .findAny()
                    .get();

            try {
                board.drawBoard();
                drawOnBoard(currentPlayer);

            } catch (IndexOutOfBoundsException e) {
                printLine("You can't draw beside board's range!");
                board.drawBoard();
            } catch (AlreadyTakenPositionException e) {
                printLine("You cannot overdraw already taken position");
            }

            if (checkForWinner(currentPlayer.getSign())) {
                currentPlayer.setWinCount(currentPlayer.getWinCount() + 1);
                printLine("Players score: X: " + players.get(1).getWinCount() + " " + "O: " + players.get(0).getWinCount());

                promptContinue();
                isRunning = false;
            }

            setLock();
        }
    }

    private void drawOnBoard(Player player) throws AlreadyTakenPositionException {

        try {
            System.out.println();

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (!board.getBoard()[x][y].equals(ApiConstants.NOTHING)) throw new AlreadyTakenPositionException();

            if (x < board.getBoard().length || y < board.getBoard().length) {
                board.getBoard()[x][y] = player.drawSign();
            }
        } catch (InputMismatchException e) {
            printLine("Only integers!");
        }
    }

    private boolean checkForWinner(String sign) {

        boolean hasWinner = false;

        if (checkDiagonal(sign) || checkColumn(sign) || checkRow(sign)) hasWinner = true;

        return hasWinner;
    }

    private void setLock() {
        for (Player player : players) {
            if (player.hasTurnLock()) {
                player.setTurnLock(false);
            } else {
                player.setTurnLock(true);
            }
        }

    }

    private boolean checkRow(String sign) {
        int score = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; i < board.getSize(); i++) {
                if (board.getBoard()[i][j].equals(sign)) {
                    score++;
                    if (score == board.getSize()) {
                        printLine(String.format("Player with sign: '%s' won!", sign));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkColumn(String sign) {
        int score = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; i < board.getSize(); i++) {
                if (board.getBoard()[j][i].equals(sign)) {
                    score++;
                    if (score == board.getSize()) {
                        System.out.println(String.format("Player with sign: '%s' won!", sign));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(String sign) {
        for (int i = 0; i < board.getSize(); i++) {
            if (!board.getBoard()[i][i].equals(sign))
                return false;

        }
        System.out.println(String.format("Player with sign: '%s' won!", sign));
        return true;
    }

    private void promptContinue() {
        System.out.print("Do you wish to continue game? y/n ");
        switch (scanner.next()) {
            case "y":
                start();
            break;
            case "n":
                return;
        }

    }
}

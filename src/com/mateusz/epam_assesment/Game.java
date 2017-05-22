package com.mateusz.epam_assesment;

import com.mateusz.epam_assesment.exception.AlreadyTakenPositionException;
import com.mateusz.epam_assesment.player.Player;
import com.mateusz.epam_assesment.player.PlayerImp;

import java.util.*;

/**
 * Created by Mateusz on 22.05.2017.
 */
public class Game {

    private Player playerCross;
    private Player playerCircle;
    private Board board;

    private List<Player> players;
    boolean isRunning;

    private Scanner scanner = new Scanner(System.in);

    Game() {

        players = new ArrayList<>();

        playerCircle = new PlayerImp();
        playerCircle.setSign(ApiConstants.CIRLCE);
        playerCross = new PlayerImp();
        playerCross.setSign(ApiConstants.CROSS);
        playerCross.setTurnLock(true);
        players.add(playerCircle);
        players.add(playerCross);

        board = new Board();
        board.initializeBoard(3);

    }

    public void start() {

        boolean isRunning = true;


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
                System.out.println("You can't draw beside board's range!");
                board.drawBoard();
            } catch (AlreadyTakenPositionException e) {
                System.out.println("You cannot overdraw already taken position");
            }

            if (checkForWinner(currentPlayer.getSign())) {
                currentPlayer.setWinCount(currentPlayer.getWinCount() + 1);

                System.out.print("Players score: X: " + players.get(1).getWinCount() + " " + "O: " + players.get(0).getWinCount());

                isRunning = false;
            }

            setLock();
        }
    }

    public void drawOnBoard(Player player) throws AlreadyTakenPositionException {

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (!board.getBoard()[x][y].equals(ApiConstants.NOTHING)) throw new AlreadyTakenPositionException();

        if (x < board.getBoard().length || y < board.getBoard().length) {
            board.getBoard()[x][y] = player.drawSign();
        }
    }

    public boolean checkForWinner(String sign) {

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
                        System.out.println(String.format("Player with sign: '%s' won!", sign));
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
}

package com.mateusz.epam_assesment;

import com.mateusz.epam_assesment.player.Player;
import com.mateusz.epam_assesment.player.PlayerImp;

/**
 * Created by Mateusz on 22.05.2017.
 */
public class Game {

    private Player playerCross;
    private Player playerCircle;
    private Board board;

    Game() {
        playerCircle = new PlayerImp();
        playerCircle.setSign(ApiConstants.CIRLCE);
        playerCross = new PlayerImp();
        playerCross.setSign(ApiConstants.CROSS);

        board = new Board();
        board.initializeBoard(3);
    }

    public void start() {

        

    }
}

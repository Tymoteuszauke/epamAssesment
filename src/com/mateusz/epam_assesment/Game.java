package com.mateusz.epam_assesment;

import com.mateusz.epam_assesment.player.Player;

/**
 * Created by Mateusz on 22.05.2017.
 */
public class Game {

    Player playerCross;
    Player playerCircle;
    Board board;

    Game() {
        playerCircle = new Player();
        playerCircle.setSign(ApiConstants.CIRLCE);
        playerCross = new Player();
        playerCross.setSign(ApiConstants.CROSS);
    }

    public void start() {

    }
}

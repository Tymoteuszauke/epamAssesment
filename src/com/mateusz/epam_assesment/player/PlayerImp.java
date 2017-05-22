package com.mateusz.epam_assesment.player;

import lombok.Data;

/**
 * Created by Mateusz on 22.05.2017.
 */
@Data
public class PlayerImp implements Player {

    private String sign;
    private int winCount;
    private boolean turnLock;


    @Override
    public String drawSign() {
        return sign;
    }

    @Override
    public boolean hasTurnLock() {
        return turnLock;
    }

    @Override
    public void setTurnLock(boolean turnLock) {
        this.turnLock = turnLock;
    }
}

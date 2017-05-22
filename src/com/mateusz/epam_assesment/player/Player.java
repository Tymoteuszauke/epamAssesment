package com.mateusz.epam_assesment.player;

/**
 * Created by Mateusz on 22.05.2017.
 */
public interface Player {
    String drawSign();
    void setSign(String sign);
    String getSign();
    boolean hasTurnLock();
    void setTurnLock(boolean turnLock);
    void setWinCount(int winCount);
    int getWinCount();
}

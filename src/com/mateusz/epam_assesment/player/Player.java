package com.mateusz.epam_assesment.player;

import lombok.Data;

/**
 * Created by Mateusz on 22.05.2017.
 */
@Data
public class Player implements PlayerSkill {

    public String sign;
    public int winCount;

    @Override
    public String put(int position) {
        return null;
    }

    @Override
    public void setSign(String sign) {

    }



}

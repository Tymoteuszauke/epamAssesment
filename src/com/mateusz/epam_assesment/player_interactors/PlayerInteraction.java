package com.mateusz.epam_assesment.player_interactors;

import java.util.Scanner;

/**
 * Created by Mateusz on 30.05.2017.
 */
public interface PlayerInteraction {
    Scanner scanner = new Scanner(System.in);
    void printText();
    void scanAnswer();
    void make();
}

package org.cheercode;

import org.cheercode.game.Game;
import org.cheercode.game.GuessCardColorGame;
import org.cheercode.game.GuessCardSuitGame;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.Render;

public class ColoredMain {
    public static void main(String[] args) {
        Render render = new ColoredConsoleRender();
//        GuessCardColorGame guessCardColorGame = new GuessCardColorGame(render);
//        guessCardColorGame.start();

        Game guessCardSuitGame = new GuessCardSuitGame(render);
        guessCardSuitGame.start();
    }
}
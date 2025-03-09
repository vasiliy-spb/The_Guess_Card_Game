package org.cheercode;

import org.cheercode.game.GuessCardColorGame;
import org.cheercode.renders.MonochromeConsoleRender;
import org.cheercode.renders.Render;

public class MonochromeMain {
    public static void main(String[] args) {
        Render render = new MonochromeConsoleRender();
        GuessCardColorGame guessCardColorGame = new GuessCardColorGame(render);
        guessCardColorGame.start();
    }
}

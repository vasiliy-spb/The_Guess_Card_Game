package org.cheercode;

import org.cheercode.game.Game;
import org.cheercode.game.GameResultAnalyzer;
import org.cheercode.renders.MonochromeConsoleRender;
import org.cheercode.renders.Render;

public class MonochromeMain {
    public static void main(String[] args) {
        Render render = new MonochromeConsoleRender();
        GameResultAnalyzer gameResultAnalyzer = new GameResultAnalyzer();
        Game game = new Game(render, gameResultAnalyzer);
        game.start();
    }
}

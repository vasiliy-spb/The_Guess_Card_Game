package org.cheercode;

import org.cheercode.game.Game;
import org.cheercode.game.GameResultAnalyzer;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.Render;

public class ColoredMain {
    public static void main(String[] args) {
        Render render = new ColoredConsoleRender();
        GameResultAnalyzer gameResultAnalyzer = new GameResultAnalyzer();
        Game game = new Game(render, gameResultAnalyzer);
        game.start();
    }
}
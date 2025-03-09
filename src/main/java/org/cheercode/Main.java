package org.cheercode;

import org.cheercode.game.Game;
import org.cheercode.game.GameResultAnalyzer;
import org.cheercode.renders.ConsoleRender;
import org.cheercode.renders.Render;

public class Main {
    public static void main(String[] args) {
        Render render = new ConsoleRender();
        GameResultAnalyzer gameResultAnalyzer = new GameResultAnalyzer();
        Game game = new Game(render, gameResultAnalyzer);
        game.start();
    }
}
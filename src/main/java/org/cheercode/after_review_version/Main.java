package org.cheercode.after_review_version;

import org.cheercode.after_review_version.games.Game;
import org.cheercode.after_review_version.games.ScoreCounter;
import org.cheercode.deck.Deck;
import org.cheercode.factories.DeckFactory;
import org.cheercode.after_review_version.factories.bet.BetFactory;
import org.cheercode.after_review_version.factories.bet.MultiBetFactory;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.Render;

public class Main {
    public static void main(String[] args) {
        int min = 0;
        int max = 20;
        int score = 10;
        ScoreCounter scoreCounter = new ScoreCounter(min, max, score);
        Deck deck = DeckFactory.createDeck();
        Render render = new ColoredConsoleRender();
        BetFactory betFactory = new MultiBetFactory();
        Game game = new Game(scoreCounter, deck, render, betFactory);
        game.start();
    }
}

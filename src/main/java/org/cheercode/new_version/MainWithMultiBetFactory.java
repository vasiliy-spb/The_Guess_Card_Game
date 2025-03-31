package org.cheercode.new_version;

import org.cheercode.deck.Deck;
import org.cheercode.factories.DeckFactory;
import org.cheercode.new_version.bet_factories.BetFactory;
import org.cheercode.new_version.bet_factories.MultiBetFactory;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.Render;

public class MainWithMultiBetFactory {
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

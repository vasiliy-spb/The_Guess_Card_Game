package org.cheercode.new_version;

import org.cheercode.cards.Card;
import org.cheercode.deck.Deck;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.MonochromeConsoleRender;
import org.cheercode.renders.Render;

public class GeneralMain {
//    public static void main(String[] args) {
//        int min = 0;
//        int max = 20;
//        int score = 10;
//        ScoreCounter scoreCounter = new ScoreCounter(min, max, score);
//        Deck deck = DeckFactory.createDeck();
////        printDeck(deck, new MonochromeConsoleRender());
//        Render render = new ColoredConsoleRender();
//        Game game = new Game(scoreCounter, deck, render);
//        game.start();
//    }

    private static void printDeck(Deck deck, Render render) {
        for (Card card : deck.toList()) {
            render.render(card);
        }
    }
}

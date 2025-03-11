package org.cheercode.games;

import org.cheercode.cards.Card;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.GameResultAnalyzer;

import java.util.Collections;
import java.util.Stack;

public abstract class GuessCardGame<T> implements Game {
    protected int guessedCardsCount = 0;
    protected final Render render;
    protected final GameResultAnalyzer<T> gameResultAnalyzer;
    private final Stack<Card> deck;

    public GuessCardGame(Render render, GameResultAnalyzer<T> gameResultAnalyzer) {
        this.render = render;
        this.gameResultAnalyzer = gameResultAnalyzer;
        this.deck = DeckFactory.createDeck();
    }

    @Override
    public void start() {
        render.showHelloMessage();
        render.showStatistics(deck.size(), guessedCardsCount);
        shuffleDeck();
        while (!deck.empty()) {
            nextTurn();
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void nextTurn() {
        T selectedAnswer = askUserChoice();
        Card turnCard = getTurnCard();
        render.render(turnCard);
        processResult(selectedAnswer, turnCard);
        render.showStatistics(deck.size(), guessedCardsCount);
    }

    protected abstract T askUserChoice();

    protected abstract void processResult(T selectedAnswer, Card turnCard);

    private Card getTurnCard() {
        return deck.pop();
    }
}

package org.cheercode.game;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.Render;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public class Game {
    private final Stack<Card> deck;
    private final Render render;
    private final GameResultAnalyzer gameResultAnalyzer;
    private int guessedCardsCount = 0;

    public Game(Render render, GameResultAnalyzer gameResultAnalyzer) {
        this.render = render;
        this.gameResultAnalyzer = gameResultAnalyzer;
        this.deck = DeckFactory.createDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void start() {
        render.showHelloMessage();
        render.showStatistics(deck.size(), guessedCardsCount);
        shuffleDeck();
        while (!deck.empty()) {
            nextTurn();
        }
    }

    private void nextTurn() {
        CardColors selectedColor = askSelectedColor();
        Card turnCard = getTurnCard();
        render.render(turnCard);
        processResult(selectedColor, turnCard);
        render.showStatistics(deck.size(), guessedCardsCount);
    }

    private void processResult(CardColors selectedColor, Card turnCard) {
        boolean won = gameResultAnalyzer.getResult(selectedColor, turnCard);
        if (won) {
            render.showVictoryMessage();
            guessedCardsCount++;
        } else {
            render.showLoseMessage();
        }
    }

    private CardColors askSelectedColor() {
        String title = """
                Выберите цвет карты:
                R — красный
                B — чёрный
                """;
        String errorMessage = "Неправильный ввод";
        final char redKey = 'r';
        final char blackKey = 'b';
        Set<Character> keys = Set.of(redKey, blackKey);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char answer = dialog.input();

        return switch (answer) {
            case redKey -> CardColors.RED;
            case blackKey -> CardColors.BLACK;
            default -> throw new IllegalArgumentException("Unknown color for key: " + answer);
        };
    }

    private Card getTurnCard() {
        return deck.pop();
    }
}

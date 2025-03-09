package org.cheercode.game;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.factories.DeckFactory;
import org.cheercode.result_analyzers.CardColorGameResultAnalyzer;
import org.cheercode.renders.Render;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public class GuessCardColorGame implements Game {
    private static final char RED_KEY = 'r';
    private static final char BLACK_KEY = 'b';
    private final Stack<Card> deck;
    private final Render render;
    private final CardColorGameResultAnalyzer cardColorGameResultAnalyzer;
    private int guessedCardsCount = 0;

    public GuessCardColorGame(Render render) {
        this.render = render;
        this.cardColorGameResultAnalyzer = new CardColorGameResultAnalyzer();
        this.deck = DeckFactory.createDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
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

    private void nextTurn() {
        CardColors selectedColor = askColor();
        Card turnCard = getTurnCard();
        render.render(turnCard);
        processResult(selectedColor, turnCard);
        render.showStatistics(deck.size(), guessedCardsCount);
    }

    private void processResult(CardColors selectedColor, Card turnCard) {
        boolean isPlayerWon = cardColorGameResultAnalyzer.getResult(selectedColor, turnCard);
        if (isPlayerWon) {
            render.showVictoryMessage();
            guessedCardsCount++;
        } else {
            render.showLoseMessage();
        }
    }

    private CardColors askColor() {
        String title = """
                Выберите цвет карты:
                R — красный
                B — чёрный
                """;
        String errorMessage = "Неправильный ввод";
        Set<Character> keys = Set.of(RED_KEY, BLACK_KEY);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char selectedColorKey = dialog.input();

        return getCardColor(selectedColorKey);
    }

    private static CardColors getCardColor(char selectedColorKey) {
        return switch (selectedColorKey) {
            case RED_KEY -> CardColors.RED;
            case BLACK_KEY -> CardColors.BLACK;
            default -> throw new IllegalArgumentException("Unknown color for key: " + selectedColorKey);
        };
    }

    private Card getTurnCard() {
        return deck.pop();
    }
}

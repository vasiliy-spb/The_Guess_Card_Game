package org.cheercode.games;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.result_analyzers.CardColorGameResultAnalyzer;
import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardColorGame extends GuessCardGame<CardColors> {
    private static final char RED_KEY = 'r';
    private static final char BLACK_KEY = 'b';
    private static final String WIN_COLOR_MESSAGE = "Вы угадали цвет карты!";

    public GuessCardColorGame(Render render) {
        super(render, new CardColorGameResultAnalyzer());
    }

    @Override
    protected CardColors askUserChoice() {
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

    @Override
    protected void processResult(CardColors selectedColor, Card turnCard) {
        boolean isPlayerWon = gameResultAnalyzer.getResult(selectedColor, turnCard);
        if (isPlayerWon) {
            render.showMessage(WIN_COLOR_MESSAGE);
            guessedCardsCount++;
        } else {
            render.showLoseMessage();
        }
    }
}

package org.cheercode.game;

import org.cheercode.cards.CardColors;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.result_analyzers.CardColorGameResultAnalyzer;
import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardColorGame extends GuessCardGame<CardColors> {
    private static final char RED_KEY = 'r';
    private static final char BLACK_KEY = 'b';

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
}

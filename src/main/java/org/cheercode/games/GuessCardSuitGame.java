package org.cheercode.games;

import org.cheercode.cards.CardSuits;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.dialogs.Dialog;
import org.cheercode.result_analyzers.CardSuitsGameResultAnalyzer;
import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardSuitGame extends GuessCardGame<CardSuits> {
    private static final char HEARTS_KEY = 'h';
    private static final char DIAMONDS_KEY = 'd';
    private static final char CLUBS_KEY = 'c';
    private static final char SPADES_KEY = 's';

    public GuessCardSuitGame(Render render) {
        super(render, new CardSuitsGameResultAnalyzer());
    }

    @Override
    protected CardSuits askUserChoice() {
        String title = """
                Выберите масть карты:
                H — червы
                D — бубны
                C — трефы
                S — пики
                """;
        String errorMessage = "Неправильный ввод";
        Set<Character> keys = Set.of(HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char selectedColorKey = dialog.input();

        return getCardSuit(selectedColorKey);
    }

    private static CardSuits getCardSuit(char selectedSuitsKey) {
        return switch (selectedSuitsKey) {
            case HEARTS_KEY -> CardSuits.HEARTS;
            case DIAMONDS_KEY -> CardSuits.DIAMONDS;
            case CLUBS_KEY -> CardSuits.CLUBS;
            case SPADES_KEY -> CardSuits.SPADES;
            default -> throw new IllegalArgumentException("Unknown suit for key: " + selectedSuitsKey);
        };
    }
}

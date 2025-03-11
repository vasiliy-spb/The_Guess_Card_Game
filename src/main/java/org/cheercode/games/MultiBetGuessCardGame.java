package org.cheercode.games;

import org.cheercode.cards.*;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.dialogs.Dialog;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.MultiBetGameResultAnalyzer;

import java.util.Set;

public class MultiBetGuessCardGame extends GuessCardGame<CardAttribute> {
    private static final char RED_KEY = 'r';
    private static final char BLACK_KEY = 'b';
    private static final char HEARTS_KEY = 'h';
    private static final char DIAMONDS_KEY = 'd';
    private static final char CLUBS_KEY = 'c';
    private static final char SPADES_KEY = 's';
    private static final char NUMBERS_KEY = 'n';
    private static final char FACES_KEY = 'f';
    private static final String WIN_CARD_MESSAGE = "Вы угадали карту!";

    public MultiBetGuessCardGame(Render render) {
        super(render, new MultiBetGameResultAnalyzer());
    }

    @Override
    protected CardAttribute askUserChoice() {
        String title = """
                Возможные ставки:
                Цвет (R — красный, B — чёрный)
                Масть (H — червы, D — бубны, C — трефы, S — пики)
                Картинка или числовая карта (N — числовая, F — картинка)
                Сделайте ставку:
                """;
        String errorMessage = "Неправильный ввод";
        Set<Character> keys = Set.of(RED_KEY, BLACK_KEY, HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY, NUMBERS_KEY, FACES_KEY);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char selectedAttributeKey = dialog.input();

        return getCardAttribute(selectedAttributeKey);
    }

    private CardAttribute getCardAttribute(char attributeKey) {
        return switch (attributeKey) {
            case RED_KEY -> CardColors.RED;
            case BLACK_KEY -> CardColors.BLACK;
            case HEARTS_KEY -> CardSuits.HEARTS;
            case DIAMONDS_KEY -> CardSuits.DIAMONDS;
            case CLUBS_KEY -> CardSuits.CLUBS;
            case SPADES_KEY -> CardSuits.SPADES;
            case NUMBERS_KEY -> CardRanks.TEN;
            case FACES_KEY -> CardRanks.ACE;
            default -> throw new IllegalArgumentException("Unknown card attribute for key: " + attributeKey);
        };
    }

    @Override
    protected void processResult(CardAttribute selectedAttribute, Card turnCard) {
        boolean isPlayerWon = gameResultAnalyzer.getResult(selectedAttribute, turnCard);
        if (isPlayerWon) {
            render.showMessage(WIN_CARD_MESSAGE);
            guessedCardsCount++;
        } else {
            render.showLoseMessage();
        }
    }
}

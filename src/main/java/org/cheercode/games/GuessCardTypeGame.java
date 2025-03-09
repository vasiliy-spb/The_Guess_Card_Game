package org.cheercode.games;

import org.cheercode.cards.CardRanks;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.dialogs.Dialog;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.CardTypeGameResultAnalyzer;

import java.util.Set;

public class GuessCardTypeGame extends GuessCardGame<CardRanks> {
    private static final char NUMBER_CARDS_KEY = 'n';
    private static final char FACE_CARDS_KEY = 'f';

    public GuessCardTypeGame(Render render) {
        super(render, new CardTypeGameResultAnalyzer());
    }

    @Override
    protected CardRanks askUserChoice() {
        String title = """
                Выберите тип карты:
                N — числовая карта
                F — карта с картинкой или туз
                """;
        String errorMessage = "Неправильный ввод";
        Set<Character> keys = Set.of(NUMBER_CARDS_KEY, FACE_CARDS_KEY);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char selectedTypeKey = dialog.input();

        return getCardRand(selectedTypeKey);
    }

    private CardRanks getCardRand(char selectedTypeKey) {
        return switch (selectedTypeKey) {
            case NUMBER_CARDS_KEY -> CardRanks.TEN;
            case FACE_CARDS_KEY -> CardRanks.ACE;
            default -> throw new IllegalArgumentException("Unknown type for key: " + selectedTypeKey);
        };
    }
}

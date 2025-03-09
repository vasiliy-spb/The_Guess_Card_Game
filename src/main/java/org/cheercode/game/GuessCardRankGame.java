package org.cheercode.game;

import org.cheercode.cards.CardRanks;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.StringDialog;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.CardRankGameResultAnalyzer;

import java.util.List;

public class GuessCardRankGame extends GuessCardGame<CardRanks> {
    private static final String TWO_KEY = "2";
    private static final String THREE_KEY = "3";
    private static final String FOUR_KEY = "4";
    private static final String FIVE_KEY = "5";
    private static final String SIX_KEY = "6";
    private static final String SEVEN_KEY = "7";
    private static final String EIGHT_KEY = "8";
    private static final String NINE_KEY = "9";
    private static final String TEN_KEY = "10";
    private static final String JACK_KEY = "J";
    private static final String QUEEN_KEY = "Q";
    private static final String KING_KEY = "K";
    private static final String ACE_KEY = "A";

    public GuessCardRankGame(Render render) {
        super(render, new CardRankGameResultAnalyzer());
    }

    @Override
    protected CardRanks askUserChoice() {
        String title = """
                Выберите достоинство карты:
                2 - 10 — числовая карта
                J — валет
                Q — дама
                K — король
                A — туз
                """;
        String errorMessage = "Неправильный ввод";
        List<String> keys = List.of(TWO_KEY, THREE_KEY, FOUR_KEY, FIVE_KEY, SIX_KEY, SEVEN_KEY, EIGHT_KEY, NINE_KEY, TEN_KEY, JACK_KEY, QUEEN_KEY, KING_KEY, ACE_KEY);

        Dialog<String> dialog = new StringDialog(title, errorMessage, keys);
        String selectedRankKey = dialog.input();
        return getCardRank(selectedRankKey);
    }

    private CardRanks getCardRank(String rankKey) {
        return switch (rankKey) {
            case TWO_KEY -> CardRanks.TWO;
            case THREE_KEY -> CardRanks.THREE;
            case FOUR_KEY -> CardRanks.FOUR;
            case FIVE_KEY -> CardRanks.FIVE;
            case SIX_KEY -> CardRanks.SIX;
            case SEVEN_KEY -> CardRanks.SEVEN;
            case EIGHT_KEY -> CardRanks.EIGHT;
            case NINE_KEY -> CardRanks.NINE;
            case TEN_KEY -> CardRanks.TEN;
            case JACK_KEY -> CardRanks.JACK;
            case QUEEN_KEY -> CardRanks.QUEEN;
            case KING_KEY -> CardRanks.KING;
            case ACE_KEY -> CardRanks.ACE;
            default -> throw new IllegalArgumentException("Unknown rank for key: " + rankKey);
        };
    }
}

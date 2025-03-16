package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardRankGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите достоинство карты:
            2 - 10 — числовая карта
            J — валет
            Q — дама
            K — король
            A — туз
            """;
    private static final Set<String> DIALOG_KEYS = Set.of(TWO_KEY, THREE_KEY, FOUR_KEY, FIVE_KEY, SIX_KEY, SEVEN_KEY, EIGHT_KEY, NINE_KEY, TEN_KEY, JACK_KEY, QUEEN_KEY, KING_KEY, ACE_KEY);

    public GuessCardRankGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

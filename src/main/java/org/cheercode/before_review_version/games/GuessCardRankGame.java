package org.cheercode.before_review_version.games;

import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardRankGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите достоинство карты:
            %s - %s — числовая карта
            %s — валет
            %s — дама
            %s — король
            %s — туз
            """.formatted(AttributeKeys.TWO_KEY, AttributeKeys.TEN_KEY, AttributeKeys.JACK_KEY, AttributeKeys.QUEEN_KEY, AttributeKeys.KING_KEY, AttributeKeys.ACE_KEY);
    private static final Set<String> DIALOG_KEYS = Set.of(AttributeKeys.TWO_KEY, AttributeKeys.THREE_KEY, AttributeKeys.FOUR_KEY, AttributeKeys.FIVE_KEY, AttributeKeys.SIX_KEY, AttributeKeys.SEVEN_KEY, AttributeKeys.EIGHT_KEY, AttributeKeys.NINE_KEY, AttributeKeys.TEN_KEY, AttributeKeys.JACK_KEY, AttributeKeys.QUEEN_KEY, AttributeKeys.KING_KEY, AttributeKeys.ACE_KEY);

    public GuessCardRankGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

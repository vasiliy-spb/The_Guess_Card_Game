package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.games.AttributeKeys.*;

public class GuessCardSuitGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите масть карты:
            %s — червы
            %s — бубны
            %s — трефы
            %s — пики
            """.formatted(HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY);
    private static final Set<String> DIALOG_KEYS = Set.of(HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY);

    public GuessCardSuitGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

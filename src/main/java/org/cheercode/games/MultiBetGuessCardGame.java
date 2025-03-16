package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.games.AttributeKeys.*;

public class MultiBetGuessCardGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Возможные ставки:
            Цвет (%s — красный, %s — чёрный)
            Масть (%s — червы, %s — бубны, %s — трефы, %s — пики)
            Картинка или числовая карта (%s — числовая, %s — картинка)
            Достоинство (%s - %s, %s, %s, %s, %s)
            Сделайте ставку:
            """.formatted(RED_KEY, BLACK_KEY,
            HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY,
            NUMBERS_KEY, FACES_KEY,
            TWO_KEY, TEN_KEY, JACK_KEY, QUEEN_KEY, KING_KEY, ACE_KEY);
    private static final Set<String> DIALOG_KEYS = Set.of(
            RED_KEY, BLACK_KEY,
            HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY,
            NUMBERS_KEY, FACES_KEY,
            TWO_KEY, THREE_KEY, FOUR_KEY, FIVE_KEY, SIX_KEY, SEVEN_KEY, EIGHT_KEY, NINE_KEY, TEN_KEY,
            JACK_KEY, QUEEN_KEY, KING_KEY, ACE_KEY);

    public MultiBetGuessCardGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

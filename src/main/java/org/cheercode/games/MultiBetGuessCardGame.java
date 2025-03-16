package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.games.AttributeKeys.*;

public class MultiBetGuessCardGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Возможные ставки:
            Цвет (R — красный, B — чёрный)
            Масть (H — червы, D — бубны, C — трефы, S — пики)
            Картинка или числовая карта (N — числовая, F — картинка)
            Достоинство (2-10, J, Q, K, A)
            Сделайте ставку:
            """;
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

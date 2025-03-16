package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.Keys.FACES_KEY;
import static org.cheercode.Keys.NUMBERS_KEY;

public class GuessCardTypeGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите тип карты:
            N — числовая карта
            F — карта с картинкой или туз
            """;
    private static final Set<String> DIALOG_KEYS = Set.of(NUMBERS_KEY, FACES_KEY);

    public GuessCardTypeGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

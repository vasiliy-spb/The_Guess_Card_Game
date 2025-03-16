package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.games.AttributeKeys.FACES_KEY;
import static org.cheercode.games.AttributeKeys.NUMBERS_KEY;

public class GuessCardTypeGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите тип карты:
            %s — числовая карта
            %s — карта с картинкой или туз
            """.formatted(NUMBERS_KEY, FACES_KEY);
    private static final Set<String> DIALOG_KEYS = Set.of(NUMBERS_KEY, FACES_KEY);

    public GuessCardTypeGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

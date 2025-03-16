package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

import static org.cheercode.games.AttributeKeys.BLACK_KEY;
import static org.cheercode.games.AttributeKeys.RED_KEY;

public class GuessCardColorGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите цвет карты:
            R — красный
            B — чёрный
            """;
    private static final Set<String> DIALOG_KEYS = Set.of(RED_KEY, BLACK_KEY);

    public GuessCardColorGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

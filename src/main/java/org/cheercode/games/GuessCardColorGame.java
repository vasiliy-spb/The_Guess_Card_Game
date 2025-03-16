package org.cheercode.games;

import org.cheercode.renders.Render;

import java.util.Set;

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

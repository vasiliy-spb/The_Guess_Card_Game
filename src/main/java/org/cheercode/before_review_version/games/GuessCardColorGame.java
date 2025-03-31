package org.cheercode.before_review_version.games;

import org.cheercode.renders.Render;

import java.util.Set;

public class GuessCardColorGame extends GuessCardGame {
    private static final String DIALOG_TITLE = """
            Выберите цвет карты:
            %s — красный
            %s — чёрный
            """.formatted(AttributeKeys.RED_KEY, AttributeKeys.BLACK_KEY);
    private static final Set<String> DIALOG_KEYS = Set.of(AttributeKeys.RED_KEY, AttributeKeys.BLACK_KEY);

    public GuessCardColorGame(Render render) {
        super(render, DIALOG_TITLE, DIALOG_KEYS);
    }
}

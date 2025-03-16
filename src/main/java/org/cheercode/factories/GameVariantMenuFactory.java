package org.cheercode.factories;

import org.cheercode.menu.GameMenu;
import org.cheercode.menu.GameVariantMenu;
import org.cheercode.menu.GameVariants;
import org.cheercode.menu.items.GameVariantMenuItem;
import org.cheercode.menu.items.MenuItem;

import java.util.List;

public final class GameVariantMenuFactory implements MenuFactory<GameVariants> {
    private static final int COLOR_KEY = 1;
    private static final int SUIT_KEY = 2;
    private static final int TYPE_KEY = 3;
    private static final int RANK_KEY = 4;
    private static final int MULTI_BET_KEY = 5;
    private static final String TITLE = "Выберите вариант игры: ";
    private static final String COLOR_TITLE = "Угадывать цвет карты";
    private static final String SUIT_TITLE = "Угадывать масть карты";
    private static final String TYPE_TITLE = "Угадывать тип карты";
    private static final String RANK_TITLE = "Угадывать достоинство карты";
    private static final String MULTI_BET_TITLE = "Угадывать любой атрибут карты";
    private static final List<MenuItem<Integer, GameVariants>> GAME_VARIANT_ITEMS = List.of(
            new GameVariantMenuItem(COLOR_KEY, COLOR_TITLE, GameVariants.GUESS_COLOR_GAME),
            new GameVariantMenuItem(SUIT_KEY, SUIT_TITLE, GameVariants.GUESS_SUIT_GAME),
            new GameVariantMenuItem(TYPE_KEY, TYPE_TITLE, GameVariants.GUESS_TYPE_GAME),
            new GameVariantMenuItem(RANK_KEY, RANK_TITLE, GameVariants.GUESS_RANK_GAME),
            new GameVariantMenuItem(MULTI_BET_KEY, MULTI_BET_TITLE, GameVariants.MULTI_BET_GAME)
    );

    @Override
    public GameMenu<Integer, GameVariants> getMenu() {
        return new GameVariantMenu(TITLE, GAME_VARIANT_ITEMS);
    }
}

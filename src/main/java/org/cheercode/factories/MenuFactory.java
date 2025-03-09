package org.cheercode.factories;

import org.cheercode.menu.*;
import org.cheercode.menu.items.GameVariantMenuItem;
import org.cheercode.menu.items.MenuItem;
import org.cheercode.menu.items.RenderVariantMenuItem;

import java.util.List;

public final class MenuFactory {
    private MenuFactory() {
    }

    public static GameMenu<Integer, GameVariants> getGameVariantMenu() {
        String gameVariantMenuTitle = "Выберите вариант игры: ";
        List<MenuItem<Integer, GameVariants>> gameVariantItems = List.of(
                new GameVariantMenuItem(1, "Угадывать цвет карты", GameVariants.GUESS_COLOR_GAME),
                new GameVariantMenuItem(2, "Угадывать масть карты", GameVariants.GUESS_SUIT_GAME),
                new GameVariantMenuItem(3, "Угадывать тип карты", GameVariants.GUESS_TYPE_GAME),
                new GameVariantMenuItem(4, "Угадывать достоинство карты", GameVariants.GUESS_RANK_GAME)
        );
        return new GameVariantMenu(gameVariantMenuTitle, gameVariantItems);
    }

    public static GameMenu<Integer, RenderVariants> getRenderVariantMenu() {
        String renderVariantMenuTitle = "Выберите вариант отрисовки карт: ";
        List<MenuItem<Integer, RenderVariants>> renderVariantItems = List.of(
                new RenderVariantMenuItem(1, "Цветные карты", RenderVariants.COLORED_RENDER),
                new RenderVariantMenuItem(2, "Монохромные карты", RenderVariants.MONOCHROME_RENDER)
        );
        return new RenderVariantMenu(renderVariantMenuTitle, renderVariantItems);
    }
}

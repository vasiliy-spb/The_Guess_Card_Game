package org.cheercode.factories.menu;

import org.cheercode.menu.GameMenu;
import org.cheercode.menu.RenderVariantMenu;
import org.cheercode.menu.RenderVariants;
import org.cheercode.menu.items.MenuItem;
import org.cheercode.menu.items.RenderVariantMenuItem;

import java.util.List;

public final class RenderVariantMenuFactory implements MenuFactory<RenderVariants> {
    private static final int COLORED_KEY = 1;
    private static final int MONOCHROME_KEY = 2;
    private static final String TITLE = "Выберите вариант отрисовки карт: ";
    private static final String COLORED_TITLE = "Цветные карты";
    private static final String MONOCHROME_TITLE = "Монохромные карты";
    private static final List<MenuItem<Integer, RenderVariants>> RENDER_VARIANT_ITEMS = List.of(
            new RenderVariantMenuItem(COLORED_KEY, COLORED_TITLE, RenderVariants.COLORED_RENDER),
            new RenderVariantMenuItem(MONOCHROME_KEY, MONOCHROME_TITLE, RenderVariants.MONOCHROME_RENDER)
    );

    @Override
    public GameMenu<Integer, RenderVariants> getMenu() {
        return new RenderVariantMenu(TITLE, RENDER_VARIANT_ITEMS);
    }
}

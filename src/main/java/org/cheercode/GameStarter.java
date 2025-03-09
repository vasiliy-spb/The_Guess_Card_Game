package org.cheercode;

import org.cheercode.game.Game;
import org.cheercode.game.GuessCardColorGame;
import org.cheercode.game.GuessCardSuitGame;
import org.cheercode.game.GuessCardTypeGame;
import org.cheercode.menu.*;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.MonochromeConsoleRender;
import org.cheercode.renders.Render;

import java.util.List;

public class GameStarter {
    private Game game;
    private Render render;

    public GameStarter() {
        init();
    }

    private void init() {
        String gameVariantMenuTitle = "Выберите вариант игры: ";
        List<MenuItem<Integer, GameVariants>> gameVariantItems = List.of(
                new GameVariantMenuItem(1, "Угадывать цвет карты", GameVariants.GUESS_COLOR_GAME),
                new GameVariantMenuItem(2, "Угадывать масть карты", GameVariants.GUESS_SUIT_GAME),
                new GameVariantMenuItem(3, "Угадывать тип карты", GameVariants.GUESS_TYPE_GAME)
        );
        GameMenu<Integer, GameVariants> gameVariantMenu = new GameVariantMenu(gameVariantMenuTitle, gameVariantItems);
        gameVariantMenu.show();
        GameVariants selectedGameVariant = gameVariantMenu.select();

        String renderVariantMenuTitle = "Выберите вариант отрисовки карт: ";
        List<MenuItem<Integer, RenderVariants>> renderVariantItems = List.of(
                new RenderVariantMenuItem(1, "Цветные карты", RenderVariants.COLORED_RENDER),
                new RenderVariantMenuItem(2, "Монохромные карты", RenderVariants.MONOCHROME_RENDER)
        );
        GameMenu<Integer, RenderVariants> renderVariantMenu = new RenderVariantMenu(renderVariantMenuTitle, renderVariantItems);
        renderVariantMenu.show();
        RenderVariants selectedRenderVariant = renderVariantMenu.select();

        initRender(selectedRenderVariant);
        initGame(selectedGameVariant);
    }

    private void initGame(GameVariants gameVariant) {
        this.game = switch (gameVariant) {
            case GUESS_COLOR_GAME -> new GuessCardColorGame(render);
            case GUESS_SUIT_GAME -> new GuessCardSuitGame(render);
            case GUESS_TYPE_GAME -> new GuessCardTypeGame(render);
            default -> throw new IllegalArgumentException("Game variant does not exist: " + gameVariant);
        };
    }

    private void initRender(RenderVariants renderVariant) {
        this.render = switch (renderVariant) {
            case COLORED_RENDER -> new ColoredConsoleRender();
            case MONOCHROME_RENDER -> new MonochromeConsoleRender();
            default -> throw new IllegalArgumentException("Render does not exist for render variant: " + renderVariant);
        };
    }

    public void start() {
        game.start();
    }
}

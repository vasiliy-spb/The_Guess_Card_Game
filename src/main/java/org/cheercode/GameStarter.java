package org.cheercode;

import org.cheercode.factories.MenuFactory;
import org.cheercode.game.*;
import org.cheercode.menu.*;
import org.cheercode.renders.ColoredConsoleRender;
import org.cheercode.renders.MonochromeConsoleRender;
import org.cheercode.renders.Render;

public class GameStarter {
    private Game game;
    private Render render;

    public GameStarter() {
        init();
    }

    private void init() {
        GameMenu<Integer, GameVariants> gameVariantMenu = MenuFactory.getGameVariantMenu();
        gameVariantMenu.show();
        GameVariants selectedGameVariant = gameVariantMenu.select();

        GameMenu<Integer, RenderVariants> renderVariantMenu = MenuFactory.getRenderVariantMenu();
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
            case GUESS_RANK_GAME -> new GuessCardRankGame(render);
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

package org.cheercode.before_review_version;

import org.cheercode.before_review_version.games.*;
import org.cheercode.before_review_version.menu.GameMenu;
import org.cheercode.before_review_version.menu.GameVariants;
import org.cheercode.before_review_version.menu.RenderVariants;
import org.cheercode.factories.menu.GameVariantMenuFactory;
import org.cheercode.factories.menu.MenuFactory;
import org.cheercode.factories.menu.RenderVariantMenuFactory;
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
        MenuFactory<GameVariants> gameVariantsMenuFactory = new GameVariantMenuFactory();
        GameMenu<Integer, GameVariants> gameVariantMenu = gameVariantsMenuFactory.getMenu();
        gameVariantMenu.show();
        GameVariants selectedGameVariant = gameVariantMenu.select();

        MenuFactory<RenderVariants> renderVariantsMenuFactory = new RenderVariantMenuFactory();
        GameMenu<Integer, RenderVariants> renderVariantMenu = renderVariantsMenuFactory.getMenu();
        renderVariantMenu.show();
        RenderVariants selectedRenderVariant = renderVariantMenu.select();

        initRender(selectedRenderVariant);
        initGame(selectedGameVariant);
    }

    private void initRender(RenderVariants renderVariant) {
        this.render = switch (renderVariant) {
            case COLORED_RENDER -> new ColoredConsoleRender();
            case MONOCHROME_RENDER -> new MonochromeConsoleRender();
            default -> throw new IllegalArgumentException("Render does not exist for render variant: " + renderVariant);
        };
    }

    private void initGame(GameVariants gameVariant) {
        if (render == null) {
            throw new IllegalStateException("The render should be initialized before game creating.");
        }
        this.game = switch (gameVariant) {
            case GUESS_COLOR_GAME -> new GuessCardColorGame(render);
            case GUESS_SUIT_GAME -> new GuessCardSuitGame(render);
            case GUESS_TYPE_GAME -> new GuessCardTypeGame(render);
            case GUESS_RANK_GAME -> new GuessCardRankGame(render);
            case MULTI_BET_GAME -> new MultiBetGuessCardGame(render);
            default -> throw new IllegalArgumentException("Game variant does not exist: " + gameVariant);
        };
    }

    public void start() {
        game.start();
    }
}

package org.cheercode.menu.items;

import org.cheercode.menu.GameVariants;

public class GameVariantMenuItem extends MenuItem<Integer, GameVariants> {

    public GameVariantMenuItem(Integer key, String title, GameVariants result) {
        super(key, title, result);
    }
}

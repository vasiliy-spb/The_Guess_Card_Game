package org.cheercode.factories.menu;

import org.cheercode.before_review_version.menu.GameMenu;

public interface MenuFactory<T> {
    GameMenu<Integer, T> getMenu();
}

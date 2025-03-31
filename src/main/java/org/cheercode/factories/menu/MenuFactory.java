package org.cheercode.factories.menu;

import org.cheercode.before_review_version.menu.GameMenu;
import org.cheercode.menu.*;

public interface MenuFactory<T> {
    GameMenu<Integer, T> getMenu();
}

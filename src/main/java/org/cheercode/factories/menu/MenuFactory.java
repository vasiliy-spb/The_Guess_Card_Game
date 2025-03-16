package org.cheercode.factories.menu;

import org.cheercode.menu.*;

public interface MenuFactory<T> {
    GameMenu<Integer, T> getMenu();
}

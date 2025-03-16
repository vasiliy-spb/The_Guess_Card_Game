package org.cheercode.factories;

import org.cheercode.menu.*;

public interface MenuFactory<T> {
    GameMenu<Integer, T> getMenu();
}

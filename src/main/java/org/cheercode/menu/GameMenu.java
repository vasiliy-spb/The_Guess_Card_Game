package org.cheercode.menu;

import java.util.List;

public abstract class GameMenu<K, R>{
    protected String title;
    protected List<MenuItem<K, R>> items;

    public GameMenu(String title, List<MenuItem<K, R>> items) {
        this.title = title;
        this.items = items;
    }

    public void show() {
        System.out.println(title);
        for (MenuItem<K, R> item : items) {
            System.out.println(item.getStringRepresentation());
        }
    }

    public abstract R select();
}

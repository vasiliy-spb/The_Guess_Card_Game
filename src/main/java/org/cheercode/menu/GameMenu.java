package org.cheercode.menu;

import org.cheercode.menu.items.MenuItem;

import java.util.List;

public abstract class GameMenu<K, R> {
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

    protected R getSelectedItem(int selectedItemNumber) {
        MenuItem<K, R> selectedItem = items.get(selectedItemNumber - 1);
        return selectedItem.getResult();
    }
}

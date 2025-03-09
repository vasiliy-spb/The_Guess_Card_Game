package org.cheercode.menu;

import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.IntegerMinMaxDialog;

import java.util.List;

public class GameVariantMenu extends GameMenu<Integer, GameVariants> {

    public GameVariantMenu(String title, List<MenuItem<Integer, GameVariants>> items) {
        super(title, items);
    }

    @Override
    public GameVariants select() {
        String errorMessage = "Неправильный ввод.";
        Dialog<Integer> dialog = new IntegerMinMaxDialog(title, errorMessage, 1, items.size());
        int selectedItemNumber = dialog.input();
        return items.get(selectedItemNumber - 1).result;
    }
}

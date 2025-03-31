package org.cheercode.before_review_version.menu;

import org.cheercode.before_review_version.dialogs.Dialog;
import org.cheercode.before_review_version.dialogs.IntegerMinMaxDialog;
import org.cheercode.before_review_version.menu.items.MenuItem;

import java.util.List;

public class RenderVariantMenu extends GameMenu<Integer, RenderVariants> {
    public RenderVariantMenu(String title, List<MenuItem<Integer, RenderVariants>> menuItems) {
        super(title, menuItems);
    }

    @Override
    public RenderVariants select() {
        String errorMessage = "Неправильный ввод.";
        Dialog<Integer> dialog = new IntegerMinMaxDialog(title, errorMessage, 1, items.size());
        int selectedItemNumber = dialog.input();
        return getSelectedItem(selectedItemNumber);
    }
}

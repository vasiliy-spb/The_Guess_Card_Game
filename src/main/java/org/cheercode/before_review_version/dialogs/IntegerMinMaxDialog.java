package org.cheercode.before_review_version.dialogs;

public class IntegerMinMaxDialog extends AbstractDialog<Integer> {
    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        super(title,
                error,
                s -> Integer.parseInt(s.trim().toLowerCase()),
                n -> n >= min && n <= max
        );
    }
}

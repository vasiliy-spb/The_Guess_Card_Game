package org.cheercode.after_review_version.dialogs;

import org.cheercode.before_review_version.dialogs.AbstractDialog;

import java.util.function.Predicate;

public class StringDialogWithPredicate extends AbstractDialog<String> {
    public StringDialogWithPredicate(String title, String error, Predicate<String> validator) {
        super(title,
                error,
                s -> s.trim().toUpperCase(),
                validator
        );
    }
}

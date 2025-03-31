package org.cheercode.new_version;

import org.cheercode.dialogs.AbstractDialog;

import java.util.Set;
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

package org.cheercode.before_review_version.dialogs;

import java.util.Set;

public class StringDialog extends AbstractDialog<String> {
    public StringDialog(String title, String error, Set<String> keys) {
        super(title,
                error,
                s -> s.trim().toUpperCase(),
                keys::contains
        );
    }
}

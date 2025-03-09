package org.cheercode.dialogs;

import java.util.List;

public class StringDialog extends AbstractDialog<String> {
    public StringDialog(String title, String error, List<String> keys) {
        super(title,
                error,
                s -> s.trim().toUpperCase(),
                keys::contains
        );
    }
}

package org.cheercode.menu.items;

public abstract class MenuItem<K, R> {
    private static final String REPRESENTATION_DELIMITER = " — ";
    private final K key;
    private final String title;
    private final R result;

    public MenuItem(K key, String title, R result) {
        this.key = key;
        this.title = title;
        this.result = result;
    }

    public String getStringRepresentation() {
        return key + REPRESENTATION_DELIMITER + title;
    }

    public R getResult() {
        return result;
    }
}

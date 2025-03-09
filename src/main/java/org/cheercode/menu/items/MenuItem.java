package org.cheercode.menu.items;

public abstract class MenuItem<T, R> {
    protected final T key;
    protected final String title;
    protected final R result;

    public MenuItem(T key, String title, R result) {
        this.key = key;
        this.title = title;
        this.result = result;
    }

    public String getStringRepresentation() {
        return key + " — " + title;
    }

    public R getResult() {
        return result;
    }
}

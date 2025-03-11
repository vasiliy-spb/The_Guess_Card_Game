package org.cheercode.cards;

public enum CardSuits implements CardAttribute {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");
    private final String value;

    CardSuits(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

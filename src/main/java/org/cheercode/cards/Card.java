package org.cheercode.cards;

public class Card {
    private final CardColors color;
    private final CardRanks rank;
    private final CardSuits suit;

    public Card(CardColors color, CardRanks rank, CardSuits suit) {
        this.color = color;
        this.rank = rank;
        this.suit = suit;
    }

    public CardColors getColor() {
        return color;
    }

    public CardRanks getRank() {
        return rank;
    }

    public CardSuits getSuit() {
        return suit;
    }
}

package org.cheercode.deck;

import org.cheercode.cards.Card;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards;

    public Deck() {
        this.cards = new Stack<>();
    }

    public void add(Card card) {
        cards.push(card);
    }

    public Card take() {
        if (isEmpty()) {
            throw new IllegalStateException("Deck is empty.");
        }
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.empty();
    }

    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}

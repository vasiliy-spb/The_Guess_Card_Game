package org.cheercode.factories;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

import java.util.Stack;

public final class DeckFactory {
    private DeckFactory() {
    }

    public static Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        for (CardSuits suit : CardSuits.values()) {
            CardColors color = getColor(suit);
            for (CardRanks rank : CardRanks.values()) {
                Card card = new Card(color, rank, suit);
                deck.push(card);
            }
        }
        return deck;
    }

    private static CardColors getColor(CardSuits suit) {
        if (suit.equals(CardSuits.HEARTS) || suit.equals(CardSuits.DIAMONDS)) {
            return CardColors.RED;
        }
        return CardColors.BLACK;
    }
}

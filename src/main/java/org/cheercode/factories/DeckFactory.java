package org.cheercode.factories;

import org.cheercode.deck.Deck;
import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

public final class DeckFactory {
    private DeckFactory() {
    }

    public static Deck createDeck() {
        Deck deck = new Deck();
        for (CardSuits suit : CardSuits.values()) {
            CardColors color = getColor(suit);
            for (CardRanks rank : CardRanks.values()) {
                Card card = new Card(color, rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    private static CardColors getColor(CardSuits suit) {
        return switch (suit) {
            case HEARTS, DIAMONDS -> CardColors.RED;
            default -> CardColors.BLACK;
        };
    }
}

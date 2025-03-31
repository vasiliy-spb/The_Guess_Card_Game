package org.cheercode.new_version.bets;

import org.cheercode.cards.CardSuits;

public class SuitBet extends Bet {
    private static final int BONUS = 2;
    private static final int PENALTY = 2;
    private final CardSuits suit;

    public SuitBet(CardSuits suit) {
        super(BONUS, PENALTY);
        this.suit = suit;
    }

    public CardSuits getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "SuitBet{" +
                "suit=" + suit +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                '}';
    }
}

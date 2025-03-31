package org.cheercode.after_review_version.factories.bet;

import org.cheercode.cards.CardSuits;
import org.cheercode.after_review_version.bets.Bet;
import org.cheercode.after_review_version.bets.SuitBet;

public class SuitsBetFactory extends AbstractBetFactory {
    public static final String HEARTS_KEY = "H";
    public static final String DIAMONDS_KEY = "D";
    public static final String CLUBS_KEY = "C";
    public static final String SPADES_KEY = "S";

    @Override
    public Bet get(String key) {
        return switch (key) {
            case HEARTS_KEY -> new SuitBet(CardSuits.HEARTS);
            case DIAMONDS_KEY -> new SuitBet(CardSuits.DIAMONDS);
            case CLUBS_KEY -> new SuitBet(CardSuits.CLUBS);
            case SPADES_KEY -> new SuitBet(CardSuits.SPADES);
            default -> throw new IllegalArgumentException("Unknown bet for key: " + key);
        };
    }
}

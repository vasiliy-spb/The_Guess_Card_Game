package org.cheercode.after_review_version.factories.bet;

import org.cheercode.after_review_version.bets.Bet;
import org.cheercode.after_review_version.bets.FaceBet;
import org.cheercode.after_review_version.bets.NumberBet;

public class TypeBetFactory extends AbstractBetFactory {
    public static final String NUMBERS_KEY = "N";
    public static final String FACES_KEY = "F";

    @Override
    public Bet get(String key) {
        return switch (key) {
            case NUMBERS_KEY -> new NumberBet();
            case FACES_KEY -> new FaceBet();
            default -> throw new IllegalArgumentException("Unknown bet for key: " + key);
        };
    }
}

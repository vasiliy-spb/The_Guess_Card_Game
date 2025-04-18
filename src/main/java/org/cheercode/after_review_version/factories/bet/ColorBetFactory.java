package org.cheercode.after_review_version.factories.bet;

import org.cheercode.cards.CardColors;
import org.cheercode.after_review_version.bets.Bet;
import org.cheercode.after_review_version.bets.ColorBet;

public class ColorBetFactory extends AbstractBetFactory {
    public static final String RED_KEY = "R";
    public static final String BLACK_KEY = "B";

    @Override
    public Bet get(String key) {
        return switch (key) {
            case RED_KEY -> new ColorBet(CardColors.RED);
            case BLACK_KEY -> new ColorBet(CardColors.BLACK);
            default -> throw new IllegalArgumentException("Unknown bet for key: " + key);
        };
    }
}

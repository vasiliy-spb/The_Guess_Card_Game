package org.cheercode.after_review_version.bets;

import org.cheercode.cards.CardColors;

public class ColorBet extends Bet {
    private static final int BONUS = 1;
    private static final int PENALTY = 1;
    private final CardColors color;

    public ColorBet(CardColors color) {
        super(BONUS, PENALTY);
        this.color = color;
    }

    public CardColors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ColorBet{" +
                "color=" + color +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                '}';
    }
}

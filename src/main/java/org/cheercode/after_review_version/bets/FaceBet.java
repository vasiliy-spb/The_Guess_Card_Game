package org.cheercode.after_review_version.bets;

public class FaceBet extends Bet {
    private static final int BONUS = 2;
    private static final int PENALTY = 1;

    public FaceBet() {
        super(BONUS, PENALTY);
    }

    @Override
    public String toString() {
        return "FaceBet{" +
                "bonus=" + bonus +
                ", penalty=" + penalty +
                '}';
    }
}

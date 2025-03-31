package org.cheercode.after_review_version.bets;

public class NumberBet extends Bet {
    private static final int BONUS = 1;
    private static final int PENALTY = 2;

    public NumberBet() {
        super(BONUS, PENALTY);
    }

    @Override
    public String toString() {
        return "NumberBet{" +
                "bonus=" + bonus +
                ", penalty=" + penalty +
                '}';
    }
}

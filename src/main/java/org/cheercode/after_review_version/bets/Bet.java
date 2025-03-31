package org.cheercode.after_review_version.bets;

public abstract class Bet {
    protected final int bonus;
    protected final int penalty;

    public Bet(int bonus, int penalty) {
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public int getBonus() {
        return bonus;
    }

    public int getPenalty() {
        return penalty;
    }
}

package org.cheercode.new_version.bets;

import org.cheercode.cards.CardRanks;

public class RankBet extends Bet {
    private static final int BONUS = 10;
    private static final int PENALTY = 3;
    private final CardRanks rank;

    public RankBet(CardRanks rank) {
        super(BONUS, PENALTY);
        this.rank = rank;
    }

    public CardRanks getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "RankBet{" +
                "rank=" + rank +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                '}';
    }
}

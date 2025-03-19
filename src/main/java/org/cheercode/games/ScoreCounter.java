package org.cheercode.games;

import org.cheercode.bets.Bet;
import org.cheercode.bets.BetType;

public class ScoreCounter {
    private static final int COLOR_BONUS = 1;
    private static final int SUIT_BONUS = 2;
    private static final int NUMBER_BONUS = 1;
    private static final int FACE_BONUS = 2;
    private static final int RANK_BONUS = 10;
    private static final int COLOR_PENALTY = 1;
    private static final int SUIT_PENALTY = 2;
    private static final int NUMBER_PENALTY = 2;
    private static final int FACE_PENALTY = 1;
    private static final int RANK_PENALTY = 3;
    private final int minScore;
    private final int maxScore;
    private int score;

    public ScoreCounter(int score, int minScore, int maxScore) {
        this.score = score;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public int getScore() {
        return score;
    }

    public void addBetScore(Bet bet) {
        BetType betType = bet.type();
        score += switch (betType) {
            case COLOR -> COLOR_BONUS;
            case SUIT -> SUIT_BONUS;
            case NUMBER -> NUMBER_BONUS;
            case FACE -> FACE_BONUS;
            case RANK -> RANK_BONUS;
        };
        score = Math.min(score, maxScore);
    }

    public void subtractBetScore(Bet bet) {
        BetType betType = bet.type();
        score -= switch (betType) {
            case COLOR -> COLOR_PENALTY;
            case SUIT -> SUIT_PENALTY;
            case NUMBER -> NUMBER_PENALTY;
            case FACE -> FACE_PENALTY;
            case RANK -> RANK_PENALTY;
        };
        score = Math.max(score, minScore);
    }
}

package org.cheercode.after_review_version.result_analyzers;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;
import org.cheercode.after_review_version.bets.*;

public final class BetResultAnalyzer {
    private BetResultAnalyzer() {
    }

    public static boolean isWin(Bet bet, Card card) {
        if (bet instanceof ColorBet colorBet) {
            return colorBet.getColor() == card.color();
        }
        if (bet instanceof SuitBet suitBet) {
            return suitBet.getSuit() == card.suit();
        }
        if (bet instanceof RankBet rankBet) {
            return rankBet.getRank() == card.rank();
        }
        if (bet instanceof NumberBet) {
            return isNumber(card);
        }
        if (bet instanceof FaceBet) {
            return isFace(card);
        }
        throw new IllegalArgumentException("Unknown bet: " + bet);
    }

    private static boolean isNumber(Card card) {
        return card.rank().ordinal() <= CardRanks.TEN.ordinal();
    }

    private static boolean isFace(Card card) {
        return !isNumber(card);
    }
}

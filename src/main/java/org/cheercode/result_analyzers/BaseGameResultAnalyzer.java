package org.cheercode.result_analyzers;

import org.cheercode.bets.Bet;
import org.cheercode.bets.BetType;
import org.cheercode.cards.*;

public class BaseGameResultAnalyzer implements GameResultAnalyzer {
    @Override
    public boolean getResult(Bet bet, Card card) {
        try {
            BetType betType = bet.type();
            return switch (betType) {
                case COLOR -> compareColors((CardColors) bet.attribute(), card);
                case SUIT -> compareSuits((CardSuits) bet.attribute(), card);
                case RANK -> compareRanks((CardRanks) bet.attribute(), card);
                case NUMBER, FACE -> compareTypes((CardRanks) bet.attribute(), card);
                default -> false;
            };
        } catch (ClassCastException e) {
            return false;
        }
    }

    private boolean compareColors(CardColors color, Card card) {
        return color.equals(card.color());
    }

    private boolean compareSuits(CardSuits suit, Card card) {
        return suit.equals(card.suit());
    }

    private boolean compareRanks(CardRanks rank, Card card) {
        return rank.equals(card.rank());
    }

    private boolean compareTypes(CardRanks rank, Card card) {
        return switch (card.rank()) {
            case TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN -> rank.equals(CardRanks.TEN);
            case JACK, QUEEN, KING, ACE -> rank.equals(CardRanks.ACE);
            default -> false;
        };
    }
}

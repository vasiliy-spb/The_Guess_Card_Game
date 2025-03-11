package org.cheercode.result_analyzers;

import org.cheercode.cards.*;

public class MultiBetGameResultAnalyzer implements GameResultAnalyzer<CardAttribute> {
    @Override
    public boolean getResult(CardAttribute selectedType, Card card) {
        if (selectedType instanceof CardColors color) {
            return compareColors(color, card);
        }
        if (selectedType instanceof CardSuits suit) {
            return compareSuits(suit, card);
        }
        if (selectedType instanceof CardRanks rank) {
            return compareRank(rank, card);
        }
        return false;
    }

    private boolean compareRank(CardRanks selectedRank, Card card) {
        CardRanks cardRank = card.rank();
        return switch (cardRank) {
            case TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN -> selectedRank.equals(CardRanks.TEN);
            case JACK, QUEEN, KING, ACE -> selectedRank.equals(CardRanks.ACE);
            default -> false;
        };
    }

    private boolean compareSuits(CardSuits selectedSuit, Card card) {
        return selectedSuit.equals(card.suit());
    }

    private boolean compareColors(CardColors selectedColor, Card card) {
        return selectedColor.equals(card.color());
    }
}

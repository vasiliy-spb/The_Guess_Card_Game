package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;

public class CardTypeGameResultAnalyzer implements GameResultAnalyzer<org.cheercode.cards.CardRanks> {
    @Override
    public boolean getResult(CardRanks selectedType, Card card) {
        CardRanks cardRank = card.rank();
        return switch (cardRank) {
            case TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN -> selectedType.equals(CardRanks.TEN);
            case JACK, QUEEN, KING, ACE -> selectedType.equals(CardRanks.ACE);
            default -> false;
        };
    }
}

package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;

public class CardRankGameResultAnalyzer implements GameResultAnalyzer<org.cheercode.cards.CardRanks> {
    @Override
    public boolean getResult(CardRanks selectedRank, Card card) {
        CardRanks cardRank = card.rank();
        return selectedRank.equals(cardRank);
    }
}

package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;

public class SuperBetGameResultAnalyzer implements GameResultAnalyzer<org.cheercode.cards.Card> {
    @Override
    public boolean getResult(Card selectedType, Card card) {
        return selectedType.equals(card);
    }
}

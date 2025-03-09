package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardSuits;

public class CardSuitsGameResultAnalyzer implements GameResultAnalyzer<CardSuits> {
    @Override
    public boolean getResult(CardSuits selectedSuit, Card card) {
        return selectedSuit.equals(card.getSuit());
    }
}

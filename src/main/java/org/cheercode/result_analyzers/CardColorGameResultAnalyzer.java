package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;

public class CardColorGameResultAnalyzer implements GameResultAnalyzer<CardColors> {
    @Override
    public boolean getResult(CardColors selectedColor, Card card) {
        return selectedColor.equals(card.color());
    }
}

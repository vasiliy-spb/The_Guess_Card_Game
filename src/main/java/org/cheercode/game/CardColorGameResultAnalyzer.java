package org.cheercode.game;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;

public class CardColorGameResultAnalyzer {
    public boolean getResult(CardColors selectedColor, Card card) {
        return selectedColor.equals(card.getColor());
    }
}

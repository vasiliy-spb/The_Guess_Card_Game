package org.cheercode.game;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardSuits;

public class CardSuitsGameResultAnalyzer extends CardColorGameResultAnalyzer {
    public boolean getResult(CardSuits selectedSuit, Card card) {
        return selectedSuit.equals(card.getSuit());
    }
}

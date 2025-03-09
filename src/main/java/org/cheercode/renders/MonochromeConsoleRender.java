package org.cheercode.renders;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;

public class MonochromeConsoleRender extends AbstractConsoleRender {
    @Override
    protected String getRepresentation(Card card) {
        String rankRepresentation = getRankRepresentation(card);
        return card.suit().getValue() + " " + rankRepresentation;
    }

    private String getRankRepresentation(Card card) {
        CardRanks rank = card.rank();
        return switch (rank) {
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case ACE -> "A";
        };
    }
}

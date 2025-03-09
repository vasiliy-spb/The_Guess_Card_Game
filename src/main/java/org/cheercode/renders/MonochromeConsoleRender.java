package org.cheercode.renders;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;

public class MonochromeConsoleRender extends AbstractConsoleRender {
    private static final String REPRESENTATION_DELIMITER = " ";
    private static final String TWO_RANK_REPRESENTATION = "2";
    private static final String THREE_RANK_REPRESENTATION = "3";
    private static final String FOUR_RANK_REPRESENTATION = "4";
    private static final String FIVE_RANK_REPRESENTATION = "5";
    private static final String SIX_RANK_REPRESENTATION = "6";
    private static final String SEVEN_RANK_REPRESENTATION = "7";
    private static final String EIGHT_RANK_REPRESENTATION = "8";
    private static final String NINE_RANK_REPRESENTATION = "9";
    private static final String TEN_RANK_REPRESENTATION = "10";
    private static final String JACK_RANK_REPRESENTATION = "J";
    private static final String QUEEN_RANK_REPRESENTATION = "Q";
    private static final String KING_RANK_REPRESENTATION = "K";
    private static final String ACE_RANK_REPRESENTATION = "A";

    @Override
    protected String getRepresentation(Card card) {
        String rankRepresentation = getRankRepresentation(card);
        return card.suit().getValue() + REPRESENTATION_DELIMITER + rankRepresentation;
    }

    private String getRankRepresentation(Card card) {
        CardRanks rank = card.rank();
        return switch (rank) {
            case TWO -> TWO_RANK_REPRESENTATION;
            case THREE -> THREE_RANK_REPRESENTATION;
            case FOUR -> FOUR_RANK_REPRESENTATION;
            case FIVE -> FIVE_RANK_REPRESENTATION;
            case SIX -> SIX_RANK_REPRESENTATION;
            case SEVEN -> SEVEN_RANK_REPRESENTATION;
            case EIGHT -> EIGHT_RANK_REPRESENTATION;
            case NINE -> NINE_RANK_REPRESENTATION;
            case TEN -> TEN_RANK_REPRESENTATION;
            case JACK -> JACK_RANK_REPRESENTATION;
            case QUEEN -> QUEEN_RANK_REPRESENTATION;
            case KING -> KING_RANK_REPRESENTATION;
            case ACE -> ACE_RANK_REPRESENTATION;
        };
    }
}

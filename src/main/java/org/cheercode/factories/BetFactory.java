package org.cheercode.factories;

import org.cheercode.bets.Bet;
import org.cheercode.bets.BetType;
import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

import static org.cheercode.Keys.*;

public final class BetFactory {
    private BetFactory() {
    }

    public static Bet createBet(String attributeKey) {
        return switch (attributeKey) {
            case RED_KEY -> new Bet(CardColors.RED, BetType.COLOR);
            case BLACK_KEY -> new Bet(CardColors.BLACK, BetType.COLOR);

            case HEARTS_KEY -> new Bet(CardSuits.HEARTS, BetType.SUIT);
            case DIAMONDS_KEY -> new Bet(CardSuits.DIAMONDS, BetType.SUIT);
            case CLUBS_KEY -> new Bet(CardSuits.CLUBS, BetType.SUIT);
            case SPADES_KEY -> new Bet(CardSuits.SPADES, BetType.SUIT);

            case NUMBERS_KEY -> new Bet(CardRanks.TEN, BetType.NUMBER);
            case FACES_KEY -> new Bet(CardRanks.ACE, BetType.FACE);

            case TWO_KEY -> new Bet(CardRanks.TWO, BetType.RANK);
            case THREE_KEY -> new Bet(CardRanks.THREE, BetType.RANK);
            case FOUR_KEY -> new Bet(CardRanks.FOUR, BetType.RANK);
            case FIVE_KEY -> new Bet(CardRanks.FIVE, BetType.RANK);
            case SIX_KEY -> new Bet(CardRanks.SIX, BetType.RANK);
            case SEVEN_KEY -> new Bet(CardRanks.SEVEN, BetType.RANK);
            case EIGHT_KEY -> new Bet(CardRanks.EIGHT, BetType.RANK);
            case NINE_KEY -> new Bet(CardRanks.NINE, BetType.RANK);
            case TEN_KEY -> new Bet(CardRanks.TEN, BetType.RANK);
            case JACK_KEY -> new Bet(CardRanks.JACK, BetType.RANK);
            case QUEEN_KEY -> new Bet(CardRanks.QUEEN, BetType.RANK);
            case KING_KEY -> new Bet(CardRanks.KING, BetType.RANK);
            case ACE_KEY -> new Bet(CardRanks.ACE, BetType.RANK);

            default -> throw new IllegalArgumentException("Unknown bet for key: " + attributeKey);
        };
    }
}

package org.cheercode.new_version.bet_factories;

import org.cheercode.cards.CardRanks;
import org.cheercode.new_version.bets.Bet;
import org.cheercode.new_version.bets.RankBet;

public class RankBetFactory extends AbstractBetFactory {
    public static final String TWO_KEY = "2";
    public static final String THREE_KEY = "3";
    public static final String FOUR_KEY = "4";
    public static final String FIVE_KEY = "5";
    public static final String SIX_KEY = "6";
    public static final String SEVEN_KEY = "7";
    public static final String EIGHT_KEY = "8";
    public static final String NINE_KEY = "9";
    public static final String TEN_KEY = "10";
    public static final String JACK_KEY = "J";
    public static final String QUEEN_KEY = "Q";
    public static final String KING_KEY = "K";
    public static final String ACE_KEY = "A";

    @Override
    public Bet get(String key) {
        return switch (key) {
            case TWO_KEY -> new RankBet(CardRanks.TWO);
            case THREE_KEY -> new RankBet(CardRanks.THREE);
            case FOUR_KEY -> new RankBet(CardRanks.FOUR);
            case FIVE_KEY -> new RankBet(CardRanks.FIVE);
            case SIX_KEY -> new RankBet(CardRanks.SIX);
            case SEVEN_KEY -> new RankBet(CardRanks.SEVEN);
            case EIGHT_KEY -> new RankBet(CardRanks.EIGHT);
            case NINE_KEY -> new RankBet(CardRanks.NINE);
            case TEN_KEY -> new RankBet(CardRanks.TEN);
            case JACK_KEY -> new RankBet(CardRanks.JACK);
            case QUEEN_KEY -> new RankBet(CardRanks.QUEEN);
            case KING_KEY -> new RankBet(CardRanks.KING);
            case ACE_KEY -> new RankBet(CardRanks.ACE);
            default -> throw new IllegalArgumentException("Unknown bet for key: " + key);
        };
    }
}

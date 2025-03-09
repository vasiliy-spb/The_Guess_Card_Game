package org.cheercode.factories;

import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardImagesTemplates;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

import java.util.HashMap;
import java.util.Map;

public final class CardRepresentationFactory {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    private CardRepresentationFactory() {
    }

    public static Map<String, String> createCardRepresentations() {
        Map<String, String> cardRepresentations = new HashMap<>();
        for (CardSuits suit : CardSuits.values()) {
            for (CardRanks rank : CardRanks.values()) {
                String key = getKey(suit, rank);
                String representation = getRepresentation(suit, rank);
                cardRepresentations.put(key, representation);
            }
        }
        return cardRepresentations;
    }

    private static String getKey(CardSuits suit, CardRanks rank) {
        return suit + "_" + rank;
    }

    private static String getRepresentation(CardSuits suit, CardRanks rank) {
        String template =
                switch (rank) {
                    case TWO -> CardImagesTemplates.TWO;
                    case THREE -> CardImagesTemplates.THREE;
                    case FOUR -> CardImagesTemplates.FOUR;
                    case FIVE -> CardImagesTemplates.FIVE;
                    case SIX -> CardImagesTemplates.SIX;
                    case SEVEN -> CardImagesTemplates.SEVEN;
                    case EIGHT -> CardImagesTemplates.EIGHT;
                    case NINE -> CardImagesTemplates.NINE;
                    case TEN -> CardImagesTemplates.TEN;
                    case JACK -> CardImagesTemplates.JACK;
                    case QUEEN -> CardImagesTemplates.QUEEN;
                    case KING -> CardImagesTemplates.KING;
                    case ACE -> CardImagesTemplates.ACE;
                };
        String suitValue = suit.getValue();
        String representation = template.replace("%s", suitValue);

        CardColors color = determineColor(suit);
        if (color.equals(CardColors.RED)) {
            representation = RED + representation + RESET;
        } else {
            representation = GREEN + representation + RESET;
        }
        return representation;
    }

    private static CardColors determineColor(CardSuits suit) {
        if (suit.equals(CardSuits.HEARTS) || suit.equals(CardSuits.DIAMONDS)) {
            return CardColors.RED;
        }
        return CardColors.BLACK;
    }
}

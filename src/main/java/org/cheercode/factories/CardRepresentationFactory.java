package org.cheercode.factories;

import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardImagesTemplates;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

import java.util.HashMap;
import java.util.Map;

public final class CardRepresentationFactory {
    private static final String RESET_CONSOLE_COLOR = "\u001B[0m";
    private static final String RED_CONSOLE_COLOR = "\u001B[31m";
    private static final String GREEN_CONSOLE_COLOR = "\u001B[32m";
    private static final String TEMPLATE_PLACE_HOLDER = "%s";

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
        String template = getTemplate(rank);
        String suitValue = suit.getValue();
        String representation = putSuitValueOnTemplate(template, suitValue);
        CardColors color = determineColor(suit);
        representation = paintRepresentation(color, representation);
        return representation;
    }

    private static String getTemplate(CardRanks rank) {
        return switch (rank) {
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
    }

    private static String putSuitValueOnTemplate(String template, String suitValue) {
        return template.replace(TEMPLATE_PLACE_HOLDER, suitValue);
    }

    private static CardColors determineColor(CardSuits suit) {
        if (suit.equals(CardSuits.HEARTS) || suit.equals(CardSuits.DIAMONDS)) {
            return CardColors.RED;
        }
        return CardColors.BLACK;
    }

    private static String paintRepresentation(CardColors color, String representation) {
        if (color.equals(CardColors.RED)) {
            return RED_CONSOLE_COLOR + representation + RESET_CONSOLE_COLOR;
        }
        return GREEN_CONSOLE_COLOR + representation + RESET_CONSOLE_COLOR;
    }
}

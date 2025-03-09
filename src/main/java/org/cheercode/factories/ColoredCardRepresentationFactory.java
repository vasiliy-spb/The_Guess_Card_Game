package org.cheercode.factories;

import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardImagesTemplates;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

public final class ColoredCardRepresentationFactory extends AbstractCardRepresentationFactory {
    private static final String RESET_CONSOLE_COLOR = "\u001B[0m";
    private static final String RED_CONSOLE_COLOR = "\u001B[31m";
    private static final String GREEN_CONSOLE_COLOR = "\u001B[32m";
    private static final String TEMPLATE_PLACE_HOLDER = "%s";

    @Override
    protected String getRepresentation(CardSuits suit, CardRanks rank) {
        String template = getTemplate(rank);
        String suitValue = suit.getValue();
        String representation = putSuitValueOnTemplate(template, suitValue);
        CardColors color = determineColor(suit);
        representation = paintRepresentation(color, representation);
        return representation;
    }

    private String getTemplate(CardRanks rank) {
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

    private String putSuitValueOnTemplate(String template, String suitValue) {
        return template.replace(TEMPLATE_PLACE_HOLDER, suitValue);
    }

    private CardColors determineColor(CardSuits suit) {
        if (suit.equals(CardSuits.HEARTS) || suit.equals(CardSuits.DIAMONDS)) {
            return CardColors.RED;
        }
        return CardColors.BLACK;
    }

    private String paintRepresentation(CardColors color, String representation) {
        if (color.equals(CardColors.RED)) {
            return RED_CONSOLE_COLOR + representation + RESET_CONSOLE_COLOR;
        }
        return GREEN_CONSOLE_COLOR + representation + RESET_CONSOLE_COLOR;
    }
}

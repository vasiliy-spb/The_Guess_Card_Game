package org.cheercode.renders;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;
import org.cheercode.factories.CardRepresentationFactory;

import java.util.Map;

public class ColoredConsoleRender extends AbstractConsoleRender {
    private static final String KEY_DELIMITER = "_";
    private final Map<String, String> cardRepresentations;

    public ColoredConsoleRender() {
        this.cardRepresentations = CardRepresentationFactory.createCardRepresentations();
    }

    @Override
    protected String getRepresentation(Card card) {
        String key = getKey(card);
        return cardRepresentations.get(key);
    }

    private String getKey(Card card) {
        CardSuits suit = card.suit();
        CardRanks rank = card.rank();
        return suit + KEY_DELIMITER + rank;
    }
}

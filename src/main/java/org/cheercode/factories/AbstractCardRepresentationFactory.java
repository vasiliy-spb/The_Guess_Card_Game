package org.cheercode.factories;

import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCardRepresentationFactory implements CardRepresentationFactory {
    private static final String KEY_DELIMITER = "_";

    @Override
    public Map<String, String> createCardRepresentations() {
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

    protected abstract String getRepresentation(CardSuits suit, CardRanks rank);

    private String getKey(CardSuits suit, CardRanks rank) {
        return suit + KEY_DELIMITER + rank;
    }
}

package org.cheercode.renders;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;
import org.cheercode.factories.card_representation.CardRepresentationFactory;

import java.util.Map;

public abstract class AbstractConsoleRender implements Render {
    private static final String KEY_DELIMITER = "_";
    private final Map<String, String> cardRepresentations;

    public AbstractConsoleRender(CardRepresentationFactory cardRepresentationFactory) {
        this.cardRepresentations = cardRepresentationFactory.createCardRepresentations();
    }

    @Override
    public void showHelloMessage() {
        System.out.println("""
                ИГРА УГАДАЙ КАРТУ
                -----------------
                """);
    }

    @Override
    public void showStatistics(int deckSize, int guessedCardsCount, int score) {
        System.out.printf("Карт в колоде: %d\n", deckSize);
        System.out.printf("Угадано: %d\n", guessedCardsCount);
        System.out.printf("Счёт: %d\n", score);
        System.out.println("-------");
    }

    @Override
    public void render(Card card) {
        String representation = getRepresentation(card);
        System.out.println(representation);
    }

    private String getRepresentation(Card card) {
        String key = getKey(card);
        return cardRepresentations.get(key);
    }

    private String getKey(Card card) {
        CardSuits suit = card.suit();
        CardRanks rank = card.rank();
        return suit + KEY_DELIMITER + rank;
    }

    @Override
    public void showTurnVictoryMessage() {
        System.out.println("ВЫ УГАДАЛИ!");
        System.out.println();
    }

    @Override
    public void showTurnLoseMessage() {
        System.out.println("Вы не угадали..");
        System.out.println();
    }

    @Override
    public void showGameVictoryMessage() {
        System.out.println("ВЫ ПОБЕДИЛИ!");
    }

    @Override
    public void showGameLoseMessage() {
        System.out.println("Вы проиграли..");
    }
}

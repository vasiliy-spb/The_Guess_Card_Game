package org.cheercode.renders;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;
import org.cheercode.factories.CardRepresentationFactory;

import java.util.Map;

public class ConsoleRender implements Render {
    private final Map<String, String> cardRepresentations;

    public ConsoleRender() {
        this.cardRepresentations = CardRepresentationFactory.createCardRepresentations();
    }

    @Override
    public void showHelloMessage() {
        System.out.println("""
                ИГРА УГАДАЙ КАРТУ
                -----------------
                """);
    }

    @Override
    public void showStatistics(int deckSize, int guessedCardsCount) {
        System.out.printf("Карт в колоде: %d\n", deckSize);
        System.out.printf("Угадано: %d\n", guessedCardsCount);
        System.out.println("-------");
    }

    @Override
    public void render(Card card) {
        String key = getKey(card);
        String representation = cardRepresentations.get(key);
        System.out.println("Выпала карта:");
        System.out.println(representation);
    }

    @Override
    public void showVictoryMessage() {
        System.out.println("YOU WIN!");
    }

    @Override
    public void showLoseMessage() {
        System.out.println("You lose..");
    }

    private String getKey(Card card) {
        CardSuits suit = card.getSuit();
        CardRanks rank = card.getRank();
        return suit + "_" + rank;
    }
}

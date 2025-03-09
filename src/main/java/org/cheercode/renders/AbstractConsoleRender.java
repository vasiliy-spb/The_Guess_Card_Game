package org.cheercode.renders;

import org.cheercode.cards.Card;

public abstract class AbstractConsoleRender implements Render {
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
        String representation = getRepresentation(card);
        System.out.println("Выпала карта:");
        System.out.println(representation);
    }

    protected abstract String getRepresentation(Card card);

    @Override
    public void showVictoryMessage() {
        System.out.println("ВЫ УГАДАЛИ!");
        System.out.println();
    }

    @Override
    public void showLoseMessage() {
        System.out.println("Вы не угадали..");
        System.out.println();
    }
}

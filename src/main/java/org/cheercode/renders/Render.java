package org.cheercode.renders;

import org.cheercode.cards.Card;

public interface Render {
    void showHelloMessage();

    void showStatistics(int deckSize, int guessedCardsCount);

    void render(Card card);

    void showVictoryMessage();

    void showLoseMessage();
}

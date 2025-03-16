package org.cheercode.renders;

import org.cheercode.cards.Card;

public interface Render {
    void showHelloMessage();

    void showStatistics(int deckSize, int guessedCardsCount, int score);

    void render(Card card);

    void showTurnVictoryMessage();

    void showTurnLoseMessage();

    void showGameVictoryMessage();

    void showGameLoseMessage();
}

package org.cheercode.new_version;

import org.cheercode.cards.Card;
import org.cheercode.deck.Deck;
import org.cheercode.dialogs.Dialog;
import org.cheercode.new_version.bets.Bet;
import org.cheercode.new_version.factories.BetFactory;
import org.cheercode.renders.Render;

public class Game {
    private static final String TITLE = "Введите ставку: ";
    private static final String ERROR = "Неправильный ввод.";
    private final ScoreCounter scoreCounter;
    private final Deck deck;
    private final Render render;
    private int guessedCardCount = 0;
    private final Dialog<String> dialog;
    private final BetFactory betFactory;

    public Game(ScoreCounter scoreCounter, Deck deck, Render render, BetFactory betFactory) {
        this.scoreCounter = scoreCounter;
        this.deck = deck;
        this.render = render;
        this.betFactory = betFactory;
        this.dialog = new StringDialogWithPredicate(TITLE, ERROR, this.betFactory::isValid);
    }

    public void start() {
        deck.shuffle();
        while (!isGameOver()) {
            showStatistic();
            nextTurn();
            if (isWin()) {
                showGameWinMessage();
            }
            if (isLose()) {
                showGameLoseMessage();
            }
        }
    }

    private void showStatistic() {
        System.out.println("Карт в колоде: " + deck.size());
        System.out.println("Угадано: " + guessedCardCount);
        System.out.printf("Очки: %d/%d\n", scoreCounter.getScore(), scoreCounter.getMaxValue());
    }

    private boolean isGameOver() {
        return isWin() || isLose();
    }

    private boolean isWin() {
        return scoreCounter.isMaxValue();
    }

    private boolean isLose() {
        return scoreCounter.isMinValue() || deck.isEmpty();
    }

    private void nextTurn() {
        String selectedKey = dialog.input();
        Bet bet = betFactory.get(selectedKey);

        Card turnCard = deck.take();

        System.out.println("Выпала карта: ");
        render.render(turnCard);

        boolean isBetWin = BetResultAnalyzer.isWin(bet, turnCard);

        if (isBetWin) {
            showBetWinMessage();
            guessedCardCount++;
            scoreCounter.add(bet.getBonus());
        } else {
            showBetLoseMessage();
            scoreCounter.sub(bet.getPenalty());
        }
    }

    private void showBetLoseMessage() {
        System.out.println("Вы не угадали..");
    }

    private void showBetWinMessage() {
        System.out.println("ВЫ УГАДАЛИ!");
    }

    private void showGameWinMessage() {
        showStatistic();
        System.out.println("ВЫ ПОБЕДИЛИ!!!");
    }

    private void showGameLoseMessage() {
        showStatistic();
        System.out.println("Вы проиграли..");
    }

}

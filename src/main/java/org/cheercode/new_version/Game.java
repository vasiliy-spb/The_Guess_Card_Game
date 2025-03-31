package org.cheercode.new_version;

import org.cheercode.cards.Card;
import org.cheercode.deck.Deck;
import org.cheercode.dialogs.Dialog;
import org.cheercode.new_version.bets.Bet;
import org.cheercode.new_version.bet_factories.BetFactory;
import org.cheercode.renders.Render;

public class Game {
    private static final String TITLE = "Введите ставку:";
    private static final String ERROR = "Неправильный ввод.";
    private static final String TURN_CARD_MESSAGE = "Выпала карта:";
    private static final String POSSIBLE_BET_TEMPLATE = "Возможные ставки:\n";
    private static final String BET_WIN_MESSAGE = "ВЫ УГАДАЛИ!";
    private static final String BET_LOSE_MESSAGE = "Вы не угадали..";
    private static final String GAME_WIN_MESSAGE = "ВЫ ПОБЕДИЛИ!!!";
    private static final String GAME_LOSE_MESSAGE = "Вы проиграли..";
    private static final String DECK_STATISTIC_TEMPLATE = "Карт в колоде: %d\n";
    private static final String GUESSED_CARD_STATISTIC_TEMPLATE = "Угадано: %d\n";
    private static final String SCORE_STATISTIC_TEMPLATE = "Очки: %d/%d\n";
    private final String possibleBetMessage;
    private final ScoreCounter scoreCounter;
    private final Deck deck;
    private final Render render;
    private final Dialog<String> dialog;
    private final BetFactory betFactory;
    private int guessedCardCount = 0;

    public Game(ScoreCounter scoreCounter, Deck deck, Render render, BetFactory betFactory) {
        this.possibleBetMessage = POSSIBLE_BET_TEMPLATE + KeyBetHandler.get(betFactory);
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
        System.out.printf(DECK_STATISTIC_TEMPLATE, deck.size());
        System.out.printf(GUESSED_CARD_STATISTIC_TEMPLATE, guessedCardCount);
        System.out.printf(SCORE_STATISTIC_TEMPLATE, scoreCounter.getScore(), scoreCounter.getMaxValue());
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
        System.out.println(possibleBetMessage);
        String selectedKey = dialog.input();
        Bet bet = betFactory.get(selectedKey);

        Card turnCard = deck.take();
        System.out.println(TURN_CARD_MESSAGE);
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
        System.out.println(BET_LOSE_MESSAGE);
    }

    private void showBetWinMessage() {
        System.out.println(BET_WIN_MESSAGE);
    }

    private void showGameWinMessage() {
        showStatistic();
        System.out.println(GAME_WIN_MESSAGE);
    }

    private void showGameLoseMessage() {
        showStatistic();
        System.out.println(GAME_LOSE_MESSAGE);
    }
}

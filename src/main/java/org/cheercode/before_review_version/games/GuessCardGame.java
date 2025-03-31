package org.cheercode.before_review_version.games;

import org.cheercode.before_review_version.bets.Bet;
import org.cheercode.cards.Card;
import org.cheercode.deck.Deck;
import org.cheercode.before_review_version.dialogs.Dialog;
import org.cheercode.before_review_version.dialogs.StringDialog;
import org.cheercode.factories.BetFactory;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.Render;
import org.cheercode.before_review_version.result_analyzers.BaseGameResultAnalyzer;
import org.cheercode.before_review_version.result_analyzers.GameResultAnalyzer;

import java.util.Set;

public abstract class GuessCardGame implements Game {
    private static final int INITIAL_SCORE = 10;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 20;
    private static final String ERROR_MESSAGE_FOR_DIALOG = "Неправильный ввод";
    private final String dialogTitle;
    private final Set<String> dialogKeys;
    private final Deck deck;
    private final Render render;
    private final GameResultAnalyzer gameResultAnalyzer;
    private final ScoreCounter scoreCounter;
    private int guessedCardsCount = 0;

    public GuessCardGame(Render render, String dialogTitle, Set<String> dialogKeys) {
        this.render = render;
        this.gameResultAnalyzer = new BaseGameResultAnalyzer();
        this.deck = DeckFactory.createDeck();
        this.scoreCounter = new ScoreCounter(INITIAL_SCORE, MIN_SCORE, MAX_SCORE);
        this.dialogTitle = dialogTitle;
        this.dialogKeys = dialogKeys;
    }

    @Override
    public void start() {
        render.showHelloMessage();
        int deckSize = deck.size();
        int currentScore = scoreCounter.getScore();
        render.showStatistics(deckSize, guessedCardsCount, currentScore);

        shuffleDeck();

        while (!isGameOver()) {
            nextTurn();
        }

        showGameResult();
    }

    private void shuffleDeck() {
        deck.shuffle();
    }

    private boolean isGameOver() {
        int currentScore = scoreCounter.getScore();
        return scoreOutOfBound(currentScore) || deck.isEmpty();
    }

    private static boolean scoreOutOfBound(int score) {
        return score >= MAX_SCORE || score <= MIN_SCORE;
    }

    private void nextTurn() {
        Bet selectedAnswer = askUserChoice();
        Card turnCard = getTurnCard();
        System.out.println("Выпала карта: ");
        render.render(turnCard);

        processResult(selectedAnswer, turnCard);

        int deckSize = deck.size();
        int currentScore = scoreCounter.getScore();
        render.showStatistics(deckSize, guessedCardsCount, currentScore);
    }

    private Bet askUserChoice() {
        Dialog<String> dialog = new StringDialog(dialogTitle, ERROR_MESSAGE_FOR_DIALOG, dialogKeys);
        String selectedAttributeKey = dialog.input();

        return getBet(selectedAttributeKey);
    }

    protected Bet getBet(String selectedAttributeKey) {
        selectedAttributeKey = selectedAttributeKey.trim().toUpperCase();
        return BetFactory.createBet(selectedAttributeKey);
    }

    private Card getTurnCard() {
        return deck.take();
    }

    private void processResult(Bet usersBet, Card turnCard) {
        boolean isPlayerWon = gameResultAnalyzer.getResult(usersBet, turnCard);
        if (isPlayerWon) {
            processWinning(usersBet);
        } else {
            processLoss(usersBet);
        }
    }

    private void processWinning(Bet usersBet) {
        scoreCounter.addBetScore(usersBet);
        render.showTurnVictoryMessage();
        guessedCardsCount++;
    }

    private void processLoss(Bet usersBet) {
        scoreCounter.subtractBetScore(usersBet);
        render.showTurnLoseMessage();
    }

    private void showGameResult() {
        if (isAchieveMaxScore()) {
            render.showGameVictoryMessage();
        } else {
            render.showGameLoseMessage();
        }
    }

    private boolean isAchieveMaxScore() {
        return scoreCounter.getScore() >= MAX_SCORE;
    }
}

package org.cheercode.games;

import org.cheercode.bets.Bet;
import org.cheercode.bets.BetType;
import org.cheercode.ScoreCounter;
import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.StringDialog;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.BaseGameResultAnalyzer;
import org.cheercode.result_analyzers.GameResultAnalyzer;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public abstract class GuessCardGame implements Game {
    protected static final String RED_KEY = "R";
    protected static final String BLACK_KEY = "B";
    protected static final String HEARTS_KEY = "H";
    protected static final String DIAMONDS_KEY = "D";
    protected static final String CLUBS_KEY = "C";
    protected static final String SPADES_KEY = "S";
    protected static final String NUMBERS_KEY = "N";
    protected static final String FACES_KEY = "F";
    protected static final String TWO_KEY = "2";
    protected static final String THREE_KEY = "3";
    protected static final String FOUR_KEY = "4";
    protected static final String FIVE_KEY = "5";
    protected static final String SIX_KEY = "6";
    protected static final String SEVEN_KEY = "7";
    protected static final String EIGHT_KEY = "8";
    protected static final String NINE_KEY = "9";
    protected static final String TEN_KEY = "10";
    protected static final String JACK_KEY = "J";
    protected static final String QUEEN_KEY = "Q";
    protected static final String KING_KEY = "K";
    protected static final String ACE_KEY = "A";
    private static final int INITIAL_SCORE = 10;
    private static final int MAX_SCORE = 20;
    private static final int MIN_SCORE = 0;
    protected int guessedCardsCount = 0;
    private final Stack<Card> deck;
    private final Render render;
    private final GameResultAnalyzer gameResultAnalyzer;
    private final ScoreCounter scoreCounter;
    private final String dialogTitle;
    private final Set<String> dialogKeys;

    public GuessCardGame(Render render, String dialogTitle, Set<String> dialogKeys) {
        this.render = render;
        this.gameResultAnalyzer = new BaseGameResultAnalyzer();
        this.deck = DeckFactory.createDeck();
        this.scoreCounter = new ScoreCounter(INITIAL_SCORE);
        this.dialogTitle = dialogTitle;
        this.dialogKeys = dialogKeys;
    }

    @Override
    public void start() {
        render.showHelloMessage();
        render.showStatistics(deck.size(), guessedCardsCount, scoreCounter.getScore());
        shuffleDeck();
        while (!isGameOver()) {
            nextTurn();
        }
        showGameResult();
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private boolean isGameOver() {
        int currentScore = scoreCounter.getScore();
        return currentScore >= MAX_SCORE || currentScore <= MIN_SCORE || deck.empty();
    }

    private void nextTurn() {
        Bet selectedAnswer = askUserChoice();
        Card turnCard = getTurnCard();
        render.render(turnCard);
        processResult(selectedAnswer, turnCard);
        render.showStatistics(deck.size(), guessedCardsCount, scoreCounter.getScore());
    }

    private Bet askUserChoice() {
        String errorMessage = "Неправильный ввод";

        Dialog<String> dialog = new StringDialog(dialogTitle, errorMessage, dialogKeys);
        String selectedAttributeKey = dialog.input();

        return getBet(selectedAttributeKey);
    }

    protected Bet getBet(String selectedAttributeKey) {
        selectedAttributeKey = selectedAttributeKey.trim().toUpperCase();
        return switch (selectedAttributeKey) {
            case RED_KEY -> new Bet(CardColors.RED, BetType.COLOR);
            case BLACK_KEY -> new Bet(CardColors.BLACK, BetType.COLOR);

            case HEARTS_KEY -> new Bet(CardSuits.HEARTS, BetType.SUIT);
            case DIAMONDS_KEY -> new Bet(CardSuits.DIAMONDS, BetType.SUIT);
            case CLUBS_KEY -> new Bet(CardSuits.CLUBS, BetType.SUIT);
            case SPADES_KEY -> new Bet(CardSuits.SPADES, BetType.SUIT);

            case NUMBERS_KEY -> new Bet(CardRanks.TEN, BetType.NUMBER);
            case FACES_KEY -> new Bet(CardRanks.ACE, BetType.FACE);

            case TWO_KEY -> new Bet(CardRanks.TWO, BetType.RANK);
            case THREE_KEY -> new Bet(CardRanks.THREE, BetType.RANK);
            case FOUR_KEY -> new Bet(CardRanks.FOUR, BetType.RANK);
            case FIVE_KEY -> new Bet(CardRanks.FIVE, BetType.RANK);
            case SIX_KEY -> new Bet(CardRanks.SIX, BetType.RANK);
            case SEVEN_KEY -> new Bet(CardRanks.SEVEN, BetType.RANK);
            case EIGHT_KEY -> new Bet(CardRanks.EIGHT, BetType.RANK);
            case NINE_KEY -> new Bet(CardRanks.NINE, BetType.RANK);
            case TEN_KEY -> new Bet(CardRanks.TEN, BetType.RANK);
            case JACK_KEY -> new Bet(CardRanks.JACK, BetType.RANK);
            case QUEEN_KEY -> new Bet(CardRanks.QUEEN, BetType.RANK);
            case KING_KEY -> new Bet(CardRanks.KING, BetType.RANK);
            case ACE_KEY -> new Bet(CardRanks.ACE, BetType.RANK);

            default -> throw new IllegalArgumentException("Unknown bet for key: " + selectedAttributeKey);
        };
    }

    private Card getTurnCard() {
        return deck.pop();
    }

    private void processResult(Bet usersBet, Card turnCard) {
        boolean isPlayerWon = gameResultAnalyzer.getResult(usersBet, turnCard);
        if (isPlayerWon) {
            scoreCounter.addScore(usersBet);
            render.showTurnVictoryMessage();
            guessedCardsCount++;
        } else {
            scoreCounter.subtractScore(usersBet);
            render.showTurnLoseMessage();
        }
    }

    private void showGameResult() {
        if (scoreCounter.getScore() >= MAX_SCORE) {
            render.showGameVictoryMessage();
        } else {
            render.showGameLoseMessage();
        }
    }
}

package org.cheercode.game;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardSuits;
import org.cheercode.dialogs.CharacterDialog;
import org.cheercode.dialogs.Dialog;
import org.cheercode.factories.DeckFactory;
import org.cheercode.renders.Render;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public class GuessCardSuitGame implements Game {
    private static final char HEARTS_KEY = 'h';
    private static final char DIAMONDS_KEY = 'd';
    private static final char CLUBS_KEY = 'c';
    private static final char SPADES_KEY = 's';
    private final Stack<Card> deck;
    private final Render render;
    private final CardSuitsGameResultAnalyzer cardSuitsGameResultAnalyzer;
    private int guessedCardsCount = 0;

    public GuessCardSuitGame(Render render) {
        this.render = render;
        this.cardSuitsGameResultAnalyzer = new CardSuitsGameResultAnalyzer();
        this.deck = DeckFactory.createDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    @Override
    public void start() {
        render.showHelloMessage();
        render.showStatistics(deck.size(), guessedCardsCount);
        shuffleDeck();
        while (!deck.empty()) {
            nextTurn();
        }
    }

    private void nextTurn() {
        CardSuits selectedSuit = askSuit();
        Card turnCard = getTurnCard();
        render.render(turnCard);
        processResult(selectedSuit, turnCard);
        render.showStatistics(deck.size(), guessedCardsCount);
    }

    private void processResult(CardSuits selectedSuit, Card turnCard) {
        boolean isPlayerWon = cardSuitsGameResultAnalyzer.getResult(selectedSuit, turnCard);
        if (isPlayerWon) {
            render.showVictoryMessage();
            guessedCardsCount++;
        } else {
            render.showLoseMessage();
        }
    }

    private CardSuits askSuit() {
        String title = """
                Выберите масть карты:
                H — червы
                D — бубны
                C — трефы
                S — пики
                """;
        String errorMessage = "Неправильный ввод";
        Set<Character> keys = Set.of(HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY);

        Dialog<Character> dialog = new CharacterDialog(title, errorMessage, keys);
        char selectedColorKey = dialog.input();

        return getCardSuit(selectedColorKey);
    }

    private static CardSuits getCardSuit(char selectedSuitsKey) {
        return switch (selectedSuitsKey) {
            case HEARTS_KEY -> CardSuits.HEARTS;
            case DIAMONDS_KEY -> CardSuits.DIAMONDS;
            case CLUBS_KEY -> CardSuits.CLUBS;
            case SPADES_KEY -> CardSuits.SPADES;
            default -> throw new IllegalArgumentException("Unknown suit for key: " + selectedSuitsKey);
        };
    }

    private Card getTurnCard() {
        return deck.pop();
    }
}

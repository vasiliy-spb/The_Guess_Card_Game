package org.cheercode.games;

import org.cheercode.cards.Card;
import org.cheercode.cards.CardColors;
import org.cheercode.cards.CardRanks;
import org.cheercode.cards.CardSuits;
import org.cheercode.dialogs.Dialog;
import org.cheercode.dialogs.StringDialog;
import org.cheercode.renders.Render;
import org.cheercode.result_analyzers.CardColorGameResultAnalyzer;
import org.cheercode.result_analyzers.CardRankGameResultAnalyzer;
import org.cheercode.result_analyzers.CardSuitsGameResultAnalyzer;
import org.cheercode.result_analyzers.SuperBetGameResultAnalyzer;

import java.util.HashSet;
import java.util.Set;

public class SuperBetGuessCardGame extends GuessCardGame<Card> {
    private static final String KEY_DELIMITER = " ";
    private static final String HEARTS_KEY = "h";
    private static final String DIAMONDS_KEY = "d";
    private static final String CLUBS_KEY = "c";
    private static final String SPADES_KEY = "s";
    private static final String TWO_KEY = "2";
    private static final String THREE_KEY = "3";
    private static final String FOUR_KEY = "4";
    private static final String FIVE_KEY = "5";
    private static final String SIX_KEY = "6";
    private static final String SEVEN_KEY = "7";
    private static final String EIGHT_KEY = "8";
    private static final String NINE_KEY = "9";
    private static final String TEN_KEY = "10";
    private static final String JACK_KEY = "j";
    private static final String QUEEN_KEY = "q";
    private static final String KING_KEY = "k";
    private static final String ACE_KEY = "a";
    private static final String WIN_COLOR_MESSAGE = "Вы угадали цвет карты!";
    private static final String WIN_SUIT_MESSAGE = "Вы угадали масть карты!";
    private static final String WIN_RANK_MESSAGE = "Вы угадали достоинство карты!";
    private static final String WIN_CARD_MESSAGE = "ВЫ УГАДАЛИ КАРТУ!";
    private static final CardColorGameResultAnalyzer cardColorGameResultAnalyzer = new CardColorGameResultAnalyzer();
    private static final CardSuitsGameResultAnalyzer cardSuitsGameResultAnalyzer = new CardSuitsGameResultAnalyzer();
    private static final CardRankGameResultAnalyzer cardRankGameResultAnalyzer = new CardRankGameResultAnalyzer();

    public SuperBetGuessCardGame(Render render) {
        super(render, new SuperBetGameResultAnalyzer());
    }

    @Override
    protected Card askUserChoice() {
        String title = """
                Введите через пробел — достоинство и масть (например "A D" — Туз ♦):
                Достоинство (2-10 — для числовой карты, J, Q, K, A — для картинки)
                Масть (H — червы, D — бубны, C — трефы, S — пики)
                Выберите карту:
                """;
        String errorMessage = "Неправильный ввод";
        Set<String> keys = createKeys();

        Dialog<String> dialog = new StringDialog(title, errorMessage, keys);
        String selectedKey = dialog.input();

        return getCard(selectedKey);
    }

    private Set<String> createKeys() {
        Set<String> keys = new HashSet<>();
        Set<String> suitsKeys = Set.of(HEARTS_KEY, DIAMONDS_KEY, CLUBS_KEY, SPADES_KEY);

        for (String suitsKey : suitsKeys) {
            for (int digitRank = 2; digitRank <= 10; digitRank++) {
                String key = digitRank + KEY_DELIMITER + suitsKey;
                keys.add(key.toUpperCase());
            }
            keys.add((JACK_KEY + KEY_DELIMITER + suitsKey).toUpperCase());
            keys.add((QUEEN_KEY + KEY_DELIMITER + suitsKey).toUpperCase());
            keys.add((KING_KEY + KEY_DELIMITER + suitsKey).toUpperCase());
            keys.add((ACE_KEY + KEY_DELIMITER + suitsKey).toUpperCase());
        }
        return keys;
    }

    private Card getCard(String key) {
        CardRanks rank = parseRank(key);
        CardSuits suit = parseSuit(key);
        CardColors color = getColor(suit);
        return new Card(color, rank, suit);
    }

    private CardRanks parseRank(String key) {
        String rankValue = key.split(KEY_DELIMITER)[0].toLowerCase();
        return getRank(rankValue);
    }

    private CardRanks getRank(String rankValue) {
        return switch (rankValue) {
            case TWO_KEY -> CardRanks.TWO;
            case THREE_KEY -> CardRanks.THREE;
            case FOUR_KEY -> CardRanks.FOUR;
            case FIVE_KEY -> CardRanks.FIVE;
            case SIX_KEY -> CardRanks.SIX;
            case SEVEN_KEY -> CardRanks.SEVEN;
            case EIGHT_KEY -> CardRanks.EIGHT;
            case NINE_KEY -> CardRanks.NINE;
            case TEN_KEY -> CardRanks.TEN;
            case JACK_KEY -> CardRanks.JACK;
            case QUEEN_KEY -> CardRanks.QUEEN;
            case KING_KEY -> CardRanks.KING;
            case ACE_KEY -> CardRanks.ACE;
            default -> throw new IllegalArgumentException("Unknown rank for value: " + rankValue);
        };
    }

    private CardSuits parseSuit(String key) {
        String suitValue = key.split(KEY_DELIMITER)[1].toLowerCase();
        return getSuit(suitValue);
    }

    private CardSuits getSuit(String suitValue) {
        return switch (suitValue) {
            case HEARTS_KEY -> CardSuits.HEARTS;
            case DIAMONDS_KEY -> CardSuits.DIAMONDS;
            case CLUBS_KEY -> CardSuits.CLUBS;
            case SPADES_KEY -> CardSuits.SPADES;
            default -> throw new IllegalArgumentException("Unknown suit for value: " + suitValue);
        };
    }

    private CardColors getColor(CardSuits suit) {
        return switch (suit) {
            case HEARTS, DIAMONDS -> CardColors.RED;
            case CLUBS, SPADES -> CardColors.BLACK;
            default -> throw new IllegalArgumentException("Unknown color for suit: " + suit);
        };
    }

    @Override
    protected void processResult(Card selectedCard, Card turnCard) {
        boolean guessedColor = cardColorGameResultAnalyzer.getResult(selectedCard.color(), turnCard);
        if (guessedColor) {
            render.showMessage(WIN_COLOR_MESSAGE);
        }

        boolean guessedSuit = cardSuitsGameResultAnalyzer.getResult(selectedCard.suit(), turnCard);
        if (guessedSuit) {
            render.showMessage(WIN_SUIT_MESSAGE);
        }

        boolean guessedRank = cardRankGameResultAnalyzer.getResult(selectedCard.rank(), turnCard);
        if (guessedRank) {
            render.showMessage(WIN_RANK_MESSAGE);
        }

        boolean guessedCard = gameResultAnalyzer.getResult(selectedCard, turnCard);
        if (guessedCard) {
            render.showMessage(WIN_CARD_MESSAGE);
        }

        if (!guessedColor && !guessedSuit && !guessedRank && !guessedCard) {
            render.showLoseMessage();
        } else {
            guessedCardsCount++;
        }
    }
}

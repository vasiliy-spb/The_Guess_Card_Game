package org.cheercode.result_analyzers;

import org.cheercode.bets.Bet;
import org.cheercode.cards.Card;

public interface GameResultAnalyzer {
    boolean getResult(Bet bet, Card card);
}

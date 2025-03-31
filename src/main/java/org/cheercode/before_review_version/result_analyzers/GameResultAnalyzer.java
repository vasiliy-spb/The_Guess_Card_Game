package org.cheercode.before_review_version.result_analyzers;

import org.cheercode.before_review_version.bets.Bet;
import org.cheercode.cards.Card;

public interface GameResultAnalyzer {
    boolean getResult(Bet bet, Card card);
}

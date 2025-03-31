package org.cheercode.after_review_version.factories.bet;

import org.cheercode.after_review_version.bets.Bet;

public interface BetFactory {
    Bet get(String key);

    boolean isValid(String key);
}

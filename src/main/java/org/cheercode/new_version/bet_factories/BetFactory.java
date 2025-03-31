package org.cheercode.new_version.bet_factories;

import org.cheercode.new_version.bets.Bet;

public interface BetFactory {
    Bet get(String key);

    boolean isValid(String key);
}

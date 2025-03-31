package org.cheercode.new_version.factories;

import org.cheercode.new_version.bets.Bet;

import java.util.List;

public class MultiBetFactory extends AbstractBetFactory {
    private final List<BetFactory> factories = List.of(
            new ColorBetFactory(),
            new SuitsBetFactory(),
            new RankBetFactory(),
            new TypeBetFactory()
    );

    @Override
    public Bet get(String key) {
        for (BetFactory factory : factories) {
            if (factory.isValid(key)) {
                return factory.get(key);
            }
        }
        throw new IllegalArgumentException("Unknown key bet: " + key);
    }
}

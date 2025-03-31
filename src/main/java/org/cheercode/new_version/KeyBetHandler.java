package org.cheercode.new_version;

import org.cheercode.new_version.factories.*;

public final class KeyBetHandler {
    private static final String COLOR_BET_FACTORY_TEMPLATE = """
            Цвет (%s — красный, %s — чёрный)
            """;
    private static final String SUIT_BET_FACTORY_TEMPLATE = """
            Масть (%s — червы, %s — бубны, %s — трефы, %s — пики)
            """;
    private static final String TYPE_BET_FACTORY_TEMPLATE = """
            Картинка или числовая карта (%s — числовая, %s — картинка)
            """;
    private static final String RANK_BET_FACTORY_TEMPLATE = """
            Достоинство (%s - %s, %s, %s, %s, %s)
            """;

    private KeyBetHandler() {
    }

    public static String get(BetFactory betFactory) {
        StringBuilder result = new StringBuilder();
        if (betFactory instanceof ColorBetFactory || betFactory instanceof MultiBetFactory) {
            result.append(COLOR_BET_FACTORY_TEMPLATE.formatted(ColorBetFactory.RED_KEY, ColorBetFactory.BLACK_KEY));
        }
        if (betFactory instanceof SuitsBetFactory || betFactory instanceof MultiBetFactory) {
            result.append(SUIT_BET_FACTORY_TEMPLATE.formatted(SuitsBetFactory.HEARTS_KEY, SuitsBetFactory.DIAMONDS_KEY, SuitsBetFactory.CLUBS_KEY, SuitsBetFactory.SPADES_KEY));
        }
        if (betFactory instanceof TypeBetFactory || betFactory instanceof MultiBetFactory) {
            result.append(TYPE_BET_FACTORY_TEMPLATE.formatted(TypeBetFactory.NUMBERS_KEY, TypeBetFactory.FACES_KEY));
        }
        if (betFactory instanceof RankBetFactory || betFactory instanceof MultiBetFactory) {
            result.append(RANK_BET_FACTORY_TEMPLATE.formatted(RankBetFactory.TWO_KEY, RankBetFactory.TEN_KEY, RankBetFactory.JACK_KEY, RankBetFactory.QUEEN_KEY, RankBetFactory.KING_KEY, RankBetFactory.ACE_KEY));
        }
        return result.toString().trim();
    }
}

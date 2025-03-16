package org.cheercode.bets;

import org.cheercode.cards.CardAttribute;

public record Bet(CardAttribute attribute, BetType type) {
}

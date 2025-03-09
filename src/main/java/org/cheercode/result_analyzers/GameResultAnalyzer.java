package org.cheercode.result_analyzers;

import org.cheercode.cards.Card;

public interface GameResultAnalyzer<T> {
    boolean getResult(T selectedType, Card card);
}

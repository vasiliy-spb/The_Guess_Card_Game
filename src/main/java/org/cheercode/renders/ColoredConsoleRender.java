package org.cheercode.renders;

import org.cheercode.factories.card_representation.ColoredCardRepresentationFactory;

public class ColoredConsoleRender extends AbstractConsoleRender {
    public ColoredConsoleRender() {
        super(new ColoredCardRepresentationFactory());
    }
}

package org.cheercode.renders;

import org.cheercode.factories.ColoredCardRepresentationFactory;

public class ColoredConsoleRender extends AbstractConsoleRender {
    public ColoredConsoleRender() {
        super(new ColoredCardRepresentationFactory());
    }
}

package org.cheercode.renders;

import org.cheercode.factories.card_representation.MonochromeCardRepresentationFactory;

public class MonochromeConsoleRender extends AbstractConsoleRender {
    public MonochromeConsoleRender() {
        super(new MonochromeCardRepresentationFactory());
    }
}

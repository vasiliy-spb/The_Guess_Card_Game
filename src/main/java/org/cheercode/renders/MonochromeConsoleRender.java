package org.cheercode.renders;

import org.cheercode.factories.MonochromeCardRepresentationFactory;

public class MonochromeConsoleRender extends AbstractConsoleRender {
    public MonochromeConsoleRender() {
        super(new MonochromeCardRepresentationFactory());
    }
}

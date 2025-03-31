package org.cheercode.after_review_version.factories.bet;

public abstract class AbstractBetFactory implements BetFactory {
    public boolean isValid(String key) {
        try {
            get(key);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
